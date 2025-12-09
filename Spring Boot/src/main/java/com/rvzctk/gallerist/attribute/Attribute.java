package com.rvzctk.gallerist.attribute;

import com.rvzctk.gallerist.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "attribute")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attribute extends BaseEntity {

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AttributeValue> values;
}