package com.rvzctk.gallerist.dto;

import java.math.BigDecimal;

import com.rvzctk.gallerist.attribute.AttributeValue;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAccountIU {

    @NotNull
    private String accountNo;

    @NotNull
    private String iban;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Long currencyTypeId;
}
