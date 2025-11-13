package com.example.PaymentGatewaySimulation.services;

import com.example.PaymentGatewaySimulation.DTO.TransactionDTO;
import com.example.PaymentGatewaySimulation.entity.Transaction;
import com.example.PaymentGatewaySimulation.mappers.TransactionMapper;
import com.example.PaymentGatewaySimulation.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TransactionService {

    private TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    // Ajouter une transaction
    public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = transactionMapper.toTransactionEntity(transactionDTO);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return transactionMapper.toTransactionDTO(savedTransaction);
    }

    // Récupérer toutes les transactions
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream().map(transactionMapper::toTransactionDTO).collect(Collectors.toList());
    }

    // Récupérer une transaction par ID
    public TransactionDTO getTransactionById(Long id) {
        return transactionRepository.findById(id).map(transactionMapper::toTransactionDTO).orElseThrow(() -> new RuntimeException("Transaction non trouvée"));
    }

    // Supprimer une transaction
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}