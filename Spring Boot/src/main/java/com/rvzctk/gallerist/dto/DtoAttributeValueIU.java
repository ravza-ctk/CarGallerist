package com.rvzctk.gallerist.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAttributeValueIU {

    @NotNull
    private String value;

    @NotNull
    private Long attributeId;
}