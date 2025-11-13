package com.example.PaymentGatewaySimulation.mappers;

import com.example.PaymentGatewaySimulation.DTO.UserDTO;
import com.example.PaymentGatewaySimulation.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Entity -> DTO (Enum Roles -> String automatiquement converti)
    UserDTO toUserDTO(User user); // MapStruct ignore automatiquement paymentMethods car il n'existe pas dans UserDTO

    // DTO -> Entity (String -> Enum Roles automatiquement converti)
    @Mapping(target = "password", ignore = true) // On ne veut pas mapper le password depuis le DTO
    @Mapping(target = "paymentMethods", ignore = true) // Ignorer les relations complexes
    User toUserEntity(UserDTO userDTO);
}