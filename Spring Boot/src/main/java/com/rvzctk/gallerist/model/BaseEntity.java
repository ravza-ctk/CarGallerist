package com.rvzctk.gallerist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;

//bu sınıfı extend eden bütün tablolara yansıması için
@MappedSuperclass
@Data
@EntityListeners(com.rvzctk.gallerist.trigger.BaseEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="create_time")
    @DateTimeFormat(iso=ISO.DATE_TIME)
    private Date createdDate;
    private Date updatedDate;
    private String createdBy;
    private String updatedBy;
    private String deletedBy;



}
