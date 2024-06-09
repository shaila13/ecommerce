package com.icodeap.ecommerce.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer id;
     LocalDateTime dateCreated;
    @ManyToOne
     UserEntity user;

}
