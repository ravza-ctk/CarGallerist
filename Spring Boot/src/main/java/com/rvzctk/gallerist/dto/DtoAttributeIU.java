package com.rvzctk.gallerist.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAttributeIU {

    @NotNull
    private String code;
    private String name;
}