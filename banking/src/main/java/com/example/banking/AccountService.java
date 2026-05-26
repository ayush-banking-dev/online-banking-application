package com.example.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found!"));
    }

    public Account transferFunds(Long fromId, Long toId, double amount) {
        Account fromAccount = getAccount(fromId);
        Account toAccount = getAccount(toId);
        // amount validation
        if (amount <= 0) {
            throw new RuntimeException("Amount must be greater than zero!");
        }
        // 1. Balance check karo
        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance!.");
        }

        // 2. Paise kaato aur dusre account me jodo
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        // 3. Dono accounts ko database me save karo
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // 4. Transaction ki history bnakar database me save karo
        com.example.banking.Transaction transaction = new com.example.banking.Transaction(
                fromId,
                toId,
                amount,
                java.time.LocalDateTime.now(),
                "TRANSFER"
        );
        transactionRepository.save(transaction);

        return fromAccount;
    }

    // 5. Passbook/statement nikalne ke liye method
    public List<com.example.banking.Transaction> getTransactionHistory(Long accountId) {
        return transactionRepository.findBySourceAccountIdOrTargetAccountId(accountId, accountId);
    }
}