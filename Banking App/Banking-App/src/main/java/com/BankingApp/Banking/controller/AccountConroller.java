package com.BankingApp.Banking.controller;

import com.BankingApp.Banking.dto.AccountDto;
import com.BankingApp.Banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountConroller {
    private AccountService accountService;

    public AccountConroller(AccountService accountService) {
        this.accountService = accountService;
    }

    //add account rest Api
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //get account REST API
    @GetMapping("/{id}")
    public  ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable long id,
                                              @RequestBody Map<String, Double > request){
        double amount = request.get("amount");
        AccountDto accountDto =accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);

    }

    //Withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }
    //get all acounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);

    }
    //Delete account REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountById( @PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted successfully!");
    }
}
