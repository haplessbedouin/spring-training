package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String email;
    private String name;
    @Column(name = "sur_name")
    private String surname;
    private String userName;
//    @OneToMany(mappedBy = "customer") Just like the merchant ownership belongs to the many side (Payment)
//    private List<Payment> payment;

    public Customer(String address, String email, String name, String surname, String userName) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.userName = userName;
    }
}
