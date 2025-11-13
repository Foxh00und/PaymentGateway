package com.example.PaymentGatewaySimulation.controllers;

import com.example.PaymentGatewaySimulation.DTO.PaymentMethodDTO;
import com.example.PaymentGatewaySimulation.services.PaymentMethodService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/payment-methods")
@AllArgsConstructor
public class PaymentMethodController {

    private PaymentMethodService paymentMethodService;

    // Ajouter une méthode de paiement
    @PostMapping
    public ResponseEntity<PaymentMethodDTO> addPaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO) {
        PaymentMethodDTO savedPaymentMethod = paymentMethodService.addPaymentMethod(paymentMethodDTO);
        return ResponseEntity.ok(savedPaymentMethod);
    }

    // Récupérer toutes les méthodes de paiement
    @GetMapping
    public ResponseEntity<List<PaymentMethodDTO>> getAllPaymentMethods() {
        List<PaymentMethodDTO> methods = paymentMethodService.getAllPaymentMethods();
        return ResponseEntity.ok(methods);
    }

    // Récupérer une méthode de paiement par ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethodDTO> getPaymentMethodById(@PathVariable Long id) {
        PaymentMethodDTO method = paymentMethodService.getPaymentMethodById(id);
        return ResponseEntity.ok(method);
    }

    // Supprimer une méthode de paiement
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable Long id) {
        paymentMethodService.deletePaymentMethod(id);
        return ResponseEntity.noContent().build();
    }
}