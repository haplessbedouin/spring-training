package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    @ManyToMany(mappedBy = "items")
    private List<Cart> carts;

    public Item(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
