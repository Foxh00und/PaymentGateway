package com.example.PaymentGatewaySimulation.services;

import com.example.PaymentGatewaySimulation.DTO.UserDTO;
import com.example.PaymentGatewaySimulation.entity.User;
import com.example.PaymentGatewaySimulation.mappers.UserMapper;
import com.example.PaymentGatewaySimulation.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder; // ➤ Injection de PasswordEncoder

    // Ajouter un utilisateur avec encodage du mot de passe
    public UserDTO addUser(UserDTO userDTO) {
        User user = userMapper.toUserEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // ➤ Encodage
        return userMapper.toUserDTO(userRepository.save(user));
    }

    // Récupérer tous les utilisateurs
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    // Récupérer un utilisateur par ID
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toUserDTO)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    // Mettre à jour un utilisateur
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        existingUser.setUserName(userDTO.getUserName());
        existingUser.setEmail(userDTO.getEmail());
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }

        return userMapper.toUserDTO(userRepository.save(existingUser));
    }

    // Supprimer un utilisateur
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
