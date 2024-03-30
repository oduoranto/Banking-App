package com.BankingApp.Banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private long id;
    private String clientName;
    private double balance;

}
