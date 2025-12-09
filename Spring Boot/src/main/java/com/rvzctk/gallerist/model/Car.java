package com.rvzctk.gallerist.model;

import com.rvzctk.gallerist.attribute.AttributeValue;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity{

    @Column(name="plaka")
    private String plaka;

    @Column(name="brand")
    private String brand;

    @Column(name="model")
    private String model;

    @Column(name="production_year")
    private Integer productionYear;

    @Column(name="price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "currency_type_id")
    private AttributeValue currencyType;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private AttributeValue carStatusType;

    @Column(name="damage_price")
    private BigDecimal damagePrice;



    @ManyToOne
    @JoinColumn(name = "gallerist_id")
    private Gallerist gallerist;



}
