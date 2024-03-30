package com.BankingApp.Banking.repository;

import com.BankingApp.Banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Account, Long> {
}
