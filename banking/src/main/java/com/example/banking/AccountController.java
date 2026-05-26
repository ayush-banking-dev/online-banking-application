package com.example.banking;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccount(id));
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody Map<String, Object> request) {
        Long fromId = Long.valueOf(request.get("fromId").toString());
        Long toId = Long.valueOf(request.get("toId").toString());
        double amount = Double.parseDouble(request.get("amount").toString());

        accountService.transferFunds(fromId, toId, amount);
        return ResponseEntity.ok("Transfer successful!");
    }

    @GetMapping("/{id}/history")
    public ResponseEntity<List<com.example.banking.Transaction>> getHistory(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getTransactionHistory(id));
    }
}