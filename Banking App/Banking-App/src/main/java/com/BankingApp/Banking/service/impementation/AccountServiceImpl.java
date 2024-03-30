package com.BankingApp.Banking.service.impementation;

import com.BankingApp.Banking.Mapper.AccountMapper;
import com.BankingApp.Banking.dto.AccountDto;
import com.BankingApp.Banking.entity.Account;
import com.BankingApp.Banking.repository.AccountsRepository;
import com.BankingApp.Banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountsRepository accountsRepository;

    public AccountServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
      Account savedAccount =  accountsRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountsRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(long id, double amount) {

        Account account = accountsRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Account does not exist"));


        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountsRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountsRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Account does not exist"));

        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient fund");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);

        Account savedAccount = accountsRepository.save(account);
        return  AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountsRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountsRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Account does not exist"));
        accountsRepository.deleteById(id);



    }
}
