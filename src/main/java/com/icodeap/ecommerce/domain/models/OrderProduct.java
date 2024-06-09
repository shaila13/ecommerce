package com.icodeap.ecommerce.domain.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderProduct {
     Product product;
     Integer quantity;
     Order order;

    public BigDecimal getTotalPrice(){
        return this.product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

}
