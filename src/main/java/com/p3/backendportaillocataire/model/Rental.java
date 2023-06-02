package com.p3.backendportaillocataire.model;

import lombok.*;

import javax.persistence.*;
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
