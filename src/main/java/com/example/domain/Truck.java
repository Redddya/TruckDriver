package com.example.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "truck_id")
    int id;
    @Version
    int version;
    String model;
    @Column(name = "model_year")
    String modelYear;
    @ManyToOne
    @JoinColumn(name = "FK_Truck_Driver")
    Driver driver;
}
