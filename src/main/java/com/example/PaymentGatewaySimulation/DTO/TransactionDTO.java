package com.example.PaymentGatewaySimulation.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Long id;
    @NotNull(message = "Le montant est obligatoire")
    @Min(value = 1, message = "Le montant doit être positif")
    private double amount;
    private Date date;
    @NotBlank(message = "Le statut est obligatoire")
    private String status;
    @NotNull(message = "Le moyen de paiement est obligatoire")
    private Long paymentMethodId;
    @NotNull(message = "L'utilisateur est obligatoire")
    private Long userId;
}