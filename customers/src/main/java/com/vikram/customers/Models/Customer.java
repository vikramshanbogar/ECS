package com.vikram.customers.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    @Column(name = "f_name")
    String f_name;

    public Customer(String f_name, String l_name, Long address_id) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.addressId = address_id;
    }

    @Column(name = "l_name")
    String l_name;
    @Column(name = "address_id")
    Long addressId;

    public Customer() {

    }
}
