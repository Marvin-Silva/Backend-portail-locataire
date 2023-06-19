package com.p3.backendportaillocataire.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Builder;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name = "rentals")
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int surface;
    private int price;
    private String picture;
    private String description;
    private int owner_id;
    private Date created_at;
    private Date updated_at;
}
