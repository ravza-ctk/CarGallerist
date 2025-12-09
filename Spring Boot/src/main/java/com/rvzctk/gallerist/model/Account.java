package com.rvzctk.gallerist.model;

import com.rvzctk.gallerist.attribute.AttributeValue;
import jakarta.persistence.*;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Account extends BaseEntity{

    @Column(name="account_no")
    private String accountNo;

    @Column(name="iban")
    private String iban;

    @Column(name="amount")
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_type_id", nullable = false)
    private AttributeValue currencyType;

}
