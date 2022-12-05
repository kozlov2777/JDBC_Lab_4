package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternetShop {
    private int id;
    private String name;
    private int id_product;
    private String director;
    private String contact;
}
