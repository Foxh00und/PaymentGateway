package com.example.PaymentGatewaySimulation.DTO;

import jakarta.validation.constraints.Future;
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
public class PaymentMethodDTO {
    private Long id;
    @NotBlank(message = "Le type de carte est obligatoire")
    private String type;
    @Min(value = 0, message = "Le solde ne peut pas être négatif")
    private double balance;
    @NotBlank(message = "Le Nombre de la carte est obligatoire")
    private String maskedCardNumber;
    @NotNull(message = "La date d'expiration est obligatoire")
    @Future(message = "La date d'expiration doit être dans le futur")
    private Date expiryDate;
    @NotNull(message = "L'utilisateur associé est obligatoire")
    private Long userId;
}