package com.icodeap.ecommerce.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer id;
      String code;
     String name;
     String description;
     String image;
     BigDecimal price;
     LocalDateTime dateCreated;
     LocalDateTime dateUpdated;
    @ManyToOne
     UserEntity userEntity;
}
