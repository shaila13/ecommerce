package com.icodeap.ecommerce.infrastructure.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "ordersproducts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderProductEntity {
    @EmbeddedId
    OrderProductPK pk;
    Integer quantity;
}
