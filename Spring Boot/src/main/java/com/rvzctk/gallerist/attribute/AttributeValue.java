package com.rvzctk.gallerist.attribute;

import com.rvzctk.gallerist.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "attribute_value")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttributeValue extends BaseEntity {

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id", nullable = false)
    private Attribute attribute;
}