package com.rvzctk.gallerist.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rvzctk.gallerist.dto.AuthRequest;
import com.rvzctk.gallerist.dto.AuthResponse;
import com.rvzctk.gallerist.dto.DtoUser;
import com.rvzctk.gallerist.dto.RefreshTokenRequest;
import com.rvzctk.gallerist.exception.BaseException;
import com.rvzctk.gallerist.exception.ErrorMessage;
import com.rvzctk.gallerist.exception.MessageType;
import com.rvzctk.gallerist.jwt.JWTService;
import com.rvzctk.gallerist.model.RefreshToken;
import com.rvzctk.gallerist.model.User;
import com.rvzctk.gallerist.repository.RefreshTokenRepository;
import com.rvzctk.gallerist.repository.UserRepository;
import com.rvzctk.gallerist.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private User createUser(AuthRequest input) {
        User user = new User();
        user.setCreatedDate(new Date());
        user.setUsername(input.getUsername());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return user;
    }

    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setCreatedDate(new Date());
        refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setUser(user);
        return refreshToken;
    }

    @Override
    public DtoUser register(AuthRequest input) {
        DtoUser dtoUser = new DtoUser();

        User savedUser = userRepository.save(createUser(input));

        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;
    }

    @Override
    public AuthResponse authenticate(AuthRequest input) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(input.getUsername(), input.getPassword());
            authenticationProvider.authenticate(authenticationToken);

            Optional<User> optUser = userRepository.findByUsername(input.getUsername());

            String accessToken = jwtService.generateToken(optUser.get());
            RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(optUser.get()));

            return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INVALID, e.getMessage()));
        }
    }

    public boolean isValidRefreshToken(Date expiredDate) {
        return new Date().before(expiredDate);
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest input) {
        Optional<RefreshToken> optRefreshToken = refreshTokenRepository.findByRefreshToken(input.getRefreshToken());
        if(optRefreshToken.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_NOT_FOUND, input.getRefreshToken()));
        }

        if(!isValidRefreshToken(optRefreshToken.get().getExpiredDate())) {
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_IS_EXPIRED, input.getRefreshToken()));
        }

        User user = optRefreshToken.get().getUser();
        String accessToken = jwtService.generateToken(user);
        RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(user));


        return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
    }


}
