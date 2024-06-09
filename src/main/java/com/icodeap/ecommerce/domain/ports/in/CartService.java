package com.icodeap.ecommerce.domain.ports.in;

import com.icodeap.ecommerce.domain.models.ItemCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartService {

    private List<ItemCart> itemCarts;
    private HashMap<Integer, ItemCart> itemCartHashMap;

    public CartService() {
        this.itemCartHashMap = new HashMap<>();
        this.itemCarts = new ArrayList<>();
    }

    public void addItemCart(Integer quantity, Integer idProduct, String nameProduct, BigDecimal price){
        ItemCart itemCart = new ItemCart(idProduct, nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getIdProduct(), itemCart);
        fillList();
    }

    public  BigDecimal getTotalCart(){
                return itemCarts.stream()
                .map(ItemCart::getTotalPriceItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public void removeItemCart(Integer idProduct){
        itemCartHashMap.remove(idProduct);
        fillList();
    }

    public void removeAllItemsCart(){
        itemCartHashMap.clear();
        itemCarts.clear();
    }

    private void fillList(){
        itemCarts.clear();
        itemCartHashMap.forEach((integer, itemCart)-> itemCarts.add(itemCart));
    }
    //para mirar por consola
    public List<ItemCart> getItemCarts(){
        return itemCarts;
    }

}
