package com.BankingApp.Banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "accounts")
@Entity

public class Account {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@Column(name ="name")
    private String clientName;
    private double balance;
}
