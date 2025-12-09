package com.rvzctk.gallerist.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthRequest {


        @NotEmpty
        private String username;

        @NotEmpty
        private String password;


}
