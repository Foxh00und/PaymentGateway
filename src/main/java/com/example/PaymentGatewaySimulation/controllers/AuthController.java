package com.example.PaymentGatewaySimulation.controllers;

import com.example.PaymentGatewaySimulation.entity.User;
import com.example.PaymentGatewaySimulation.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {


    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestParam String email, @RequestParam String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        Map<String, String> response = new HashMap<>();

        if (passwordEncoder.matches(password, user.getPassword())) {
            response.put("status", "success");
            response.put("message", "Login réussi pour " + user.getUserName());
            // 👉 fake token (tu remplaces plus tard par un vrai JWT)
            response.put("token", "fake-jwt-token-12345");
            response.put("role", String.valueOf(user.getRoles()));
        } else {
            response.put("status", "error");
            response.put("message", "Email ou mot de passe incorrect");
        }

        return ResponseEntity.ok(response);
    }



    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email déjà utilisé");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword())); // hash du mot de passe
        User savedUser = userRepository.save(user);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Utilisateur créé avec succès : " + savedUser.getUserName());
        response.put("role", String.valueOf(savedUser.getRoles()));

        return ResponseEntity.ok(response);
    }
}
