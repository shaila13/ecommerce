package com.icodeap.ecommerce.domain.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
     Integer id;
     String code;
     String name;
     String description;
     String image;
     BigDecimal price;

     LocalDateTime dateCreated;
     LocalDateTime dateUpdated;

     User user;

    public Product() {
        this.setCode(UUID.randomUUID().toString());
    }
}
