package com.example.PaymentGatewaySimulation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AuditLog {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String action;
    private Date timeStamp;
    @ManyToOne
    private User user;
    @ManyToOne
    private Transaction transaction;

    /*public AuditLog() {
    }

    public AuditLog(Long id, String action, Date timeStamp, Long userId, User user, Transaction transaction) {
        this.id = id;
        this.action = action;
        this.timeStamp = timeStamp;
        this.user = user;

        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}
