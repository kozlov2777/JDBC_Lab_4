package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int id;
    private String name;
    private int price;
    private int id_internet_shop;

    public Product(String name, int price, int id_internet_shop) {
        this.name = name;
        this.price = price;
        this.id_internet_shop = id_internet_shop;
    }
}
