package com.BankingApp.Banking.Mapper;
import com.BankingApp.Banking.dto.AccountDto;
import com.BankingApp.Banking.entity.Account;

public class AccountMapper {

        public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getClientName(),
                accountDto.getBalance()
        );
        return account;

    }
    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getClientName(),
                account.getBalance()
        );
        return accountDto;
    }
}
