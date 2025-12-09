package com.rvzctk.gallerist.dto;

import java.math.BigDecimal;

import com.rvzctk.gallerist.attribute.AttributeValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCar extends DtoBase{

    private String plaka;

    private String brand;

    private String model;

    private Integer productionYear;

    private BigDecimal price;

    private Long currencyTypeId;

    private BigDecimal damagePrice;

    private Long carStatusTypeId;
}
