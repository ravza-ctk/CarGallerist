package com.rvzctk.gallerist.service;


import com.rvzctk.gallerist.dto.AuthRequest;
import com.rvzctk.gallerist.dto.AuthResponse;
import com.rvzctk.gallerist.dto.DtoUser;
import com.rvzctk.gallerist.dto.RefreshTokenRequest;

public interface IAuthenticationService {

        public DtoUser register(AuthRequest input);

        public AuthResponse authenticate(AuthRequest input);

        public AuthResponse refreshToken(RefreshTokenRequest input);
}
