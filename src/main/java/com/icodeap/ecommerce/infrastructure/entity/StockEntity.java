package com.icodeap.ecommerce.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock")
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer id;
     LocalDateTime dateCreated;
     Integer unitIn;
     Integer unitOut;
     String description;
     Integer balance;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
     ProductEntity productEntity;
}
