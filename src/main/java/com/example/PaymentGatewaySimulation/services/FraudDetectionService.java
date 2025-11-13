package com.example.PaymentGatewaySimulation.services;

import com.example.PaymentGatewaySimulation.entity.Transaction;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionService {

    // Simple logique : toute transaction > 5000 est suspecte
    public boolean isFraudulent(Transaction transaction) {
        if (transaction.getAmount() > 5000) {
            return true;
        }
        // Ici tu peux ajouter d’autres règles (IP, localisation, fréquence…)
        return false;
    }
}
