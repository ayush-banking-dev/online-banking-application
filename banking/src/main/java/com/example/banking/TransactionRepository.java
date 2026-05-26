package com.example.banking;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<com.example.banking.Transaction, Long> {

    // Dono accounts ke liye transactions dhoodhne ke liye
    List<com.example.banking.Transaction> findBySourceAccountIdOrTargetAccountId(Long sourceAccountId, Long targetAccountId);
}