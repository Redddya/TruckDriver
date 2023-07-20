package com.example.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "driver_id")
    int id;
    @Version
    int version;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    int age;
    @Enumerated(EnumType.STRING)
    Qualification qualification;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "driver")
    List<Truck> trucks;
}
