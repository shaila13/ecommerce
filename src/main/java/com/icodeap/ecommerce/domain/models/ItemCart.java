package com.icodeap.ecommerce.domain.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemCart {
     Integer idProduct;
     String nameProduct;
     Integer quantity;
     BigDecimal price;

    public BigDecimal getTotalPriceItem(){
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
