package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
public class Booking {
    private int id;
    private int id_customer;
    private int id_product;
    private int count_product;
    private int id_employee;
    private Date date_of_create;
    private String status;


    public Booking(int id, String name, int price, int id_internet_shop) {
    }
}
