package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "cart")
    private Payment payment;
    @ManyToMany
    @JoinTable(name = "cart item rel", joinColumns = @JoinColumn(name = "c id"),inverseJoinColumns = @JoinColumn(name = "i id"))
    private List<Item> items;

}
