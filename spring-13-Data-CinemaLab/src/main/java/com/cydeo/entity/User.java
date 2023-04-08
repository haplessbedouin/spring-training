package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_account")
public class User extends BaseEntity{
    private String email;
    private String password;
    private String username;
    @OneToOne
    @JoinColumn(name = "account_details_id")
    private Account account;

}
