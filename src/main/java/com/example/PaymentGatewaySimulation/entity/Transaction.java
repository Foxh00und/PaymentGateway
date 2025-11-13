package com.example.PaymentGatewaySimulation.entity;

import com.example.PaymentGatewaySimulation.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private PaymentMethod paymentMethod;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "transaction")
    private List<AuditLog> auditLogs;


    /*public Transaction() {
    }

    public Transaction(Long id, double amount, Date date, Status status, PaymentMethod paymentMethod, User user, List<AuditLog> auditLogs) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.user = user;
        this.auditLogs = auditLogs;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<AuditLog> getAuditLogs() {
        return auditLogs;
    }

    public void setAuditLogs(List<AuditLog> auditLogs) {
        this.auditLogs = auditLogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}
