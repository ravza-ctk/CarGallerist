package com.rvzctk.gallerist.dto;

import java.math.BigDecimal;


import com.rvzctk.gallerist.attribute.AttributeValue;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCarIU {

    @NotNull
    private String plaka;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private Integer productionYear;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Long currencyTypeId;

    @NotNull
    private BigDecimal damagePrice;

    @NotNull
    private Long carStatusTypeId;

    @NotNull
    private Long galleristId;


}
