package com.example.PaymentGatewaySimulation.entity;

import com.example.PaymentGatewaySimulation.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class PaymentMethod {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double balance;
    private Date expiryDate;
    private String cardNumber;
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "paymentMethod")
    private List<Transaction> transactions;

   /* public PaymentMethod() {
    }

    public PaymentMethod(Long id, double balance, Date expiryDate, String cardNumber, Type type, User user, List<Transaction> transactions) {
        this.id = id;
        this.balance = balance;
        this.expiryDate = expiryDate;
        this.cardNumber = cardNumber;
        this.type = type;
        this.user = user;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }*/
}
