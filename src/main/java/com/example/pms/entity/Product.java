package com.example.pms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;




@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @DecimalMin(value = "0.00", message = "price can not be lower than 0")
    private Double price;

    @NotBlank
    @Column(name = "productName")
    private String productName;
}
