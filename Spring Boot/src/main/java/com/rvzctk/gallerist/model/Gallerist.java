package com.rvzctk.gallerist.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="gallerist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Gallerist extends BaseEntity{

    @Column(name= "first_name")
    private String firstName;

    @Column(name= "last_name")
    private String lastName;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "gallerist", cascade = CascadeType.ALL)
    private List<Car> cars;

}
