package com.example.PaymentGatewaySimulation.services;

import com.example.PaymentGatewaySimulation.DTO.PaymentMethodDTO;
import com.example.PaymentGatewaySimulation.entity.PaymentMethod;
import com.example.PaymentGatewaySimulation.mappers.PaymentMethodMapper;
import com.example.PaymentGatewaySimulation.repositories.PaymentMethodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentMethodService {

    private PaymentMethodRepository paymentMethodRepository;
    private PaymentMethodMapper paymentMethodMapper;

    // Ajouter une méthode de paiement
    public PaymentMethodDTO addPaymentMethod(PaymentMethodDTO paymentMethodDTO) {
        PaymentMethod paymentMethod = paymentMethodMapper.toPaymentEntity(paymentMethodDTO);
        PaymentMethod savedPaymentMethod = paymentMethodRepository.save(paymentMethod);
        return paymentMethodMapper.toPaymentDTO(savedPaymentMethod);
    }

    // Récupérer toutes les méthodes de paiement
    public List<PaymentMethodDTO> getAllPaymentMethods() {
        return paymentMethodRepository.findAll().stream().map(paymentMethodMapper::toPaymentDTO).collect(Collectors.toList());
    }

    // Récupérer une méthode de paiement par ID
    public PaymentMethodDTO getPaymentMethodById(Long id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment method not found with id: " + id));
        return paymentMethodMapper.toPaymentDTO(paymentMethod);
    }

    // Supprimer une méthode de paiement
    public void deletePaymentMethod(Long id) {
        if (!paymentMethodRepository.existsById(id)) {
            throw new RuntimeException("Payment method not found with id: " + id);
        }
        paymentMethodRepository.deleteById(id);
    }
}

