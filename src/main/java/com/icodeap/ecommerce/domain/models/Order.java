package com.icodeap.ecommerce.domain.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
     Integer id;
     LocalDateTime dateCreated;
     List<OrderProduct> orderProducts;
     User user;

    public void addOrdersProduct(List<OrderProduct> orderProducts){
        this.setOrderProducts(orderProducts);
    }
    public BigDecimal getTotalOrderPrice(){
        return getOrderProducts().stream()
                .map(p->p.getTotalPrice()
        ).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
