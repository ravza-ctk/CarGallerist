package com.rvzctk.gallerist.controller;

import com.rvzctk.gallerist.dto.AuthRequest;
import com.rvzctk.gallerist.dto.AuthResponse;
import com.rvzctk.gallerist.dto.DtoUser;
import com.rvzctk.gallerist.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest input);

    public RootEntity<AuthResponse> authenticate(AuthRequest input);

    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
}
