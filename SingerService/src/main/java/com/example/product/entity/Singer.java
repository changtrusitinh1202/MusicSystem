package com.example.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Singer {

    @GeneratedValue
    @Id
    private long id;

    @Column
    private String name;
    @Column
    private LocalDate date;
    @Column
    private boolean gender;

}
