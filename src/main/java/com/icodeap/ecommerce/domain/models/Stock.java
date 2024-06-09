package com.icodeap.ecommerce.domain.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stock {
     Integer id;
     LocalDateTime dateCreated;
     Integer unitIn;
     Integer unitOut;
     String description;
     Integer balance;
     Product product;
}
