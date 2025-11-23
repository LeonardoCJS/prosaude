package com.example.pulseira.monitoramento.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {

    @NotBlank(message = "O nome de usuário não pode ser vazio")
    private String username;

    @NotBlank(message = "A senha não pode ser vazia")
    private String password;
}
