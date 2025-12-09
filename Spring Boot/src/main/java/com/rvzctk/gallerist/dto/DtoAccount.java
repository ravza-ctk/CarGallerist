package com.rvzctk.gallerist.dto;

import java.math.BigDecimal;

import com.rvzctk.gallerist.attribute.AttributeValue;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAccount extends DtoBase{

    private String accountNo;

    private String iban;

    private BigDecimal amount;

    private Long currencyTypeId;
}
