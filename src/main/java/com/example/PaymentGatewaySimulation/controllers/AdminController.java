package com.example.PaymentGatewaySimulation.controllers;

import com.example.PaymentGatewaySimulation.entity.AuditLog;
import com.example.PaymentGatewaySimulation.entity.Transaction;
import com.example.PaymentGatewaySimulation.repositories.AuditLogRepository;
import com.example.PaymentGatewaySimulation.repositories.TransactionRepository;
import com.example.PaymentGatewaySimulation.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {


    private AuditLogRepository auditLogRepository;
    private TransactionRepository transactionRepository;
    private UserRepository userRepository;

    // Consulter tous les logs
    @GetMapping("/logs")
    public List<AuditLog> getAllLogs() {
        return auditLogRepository.findAll();
    }

    // Consulter toutes les transactions
    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Supprimer un utilisateur
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "Utilisateur avec id " + id + " supprimé ✅";
    }
}