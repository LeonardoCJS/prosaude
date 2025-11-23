package com.example.pulseira.monitoramento.services;

import com.example.pulseira.monitoramento.domains.Usuario;
import com.example.pulseira.monitoramento.dtos.UsuarioRequestDTO;
import com.example.pulseira.monitoramento.dtos.UsuarioResponseDTO;
import com.example.pulseira.monitoramento.gateways.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioResponseDTO save(UsuarioRequestDTO usuarioRequestDTO) {
        if (usuarioRepository.findByUsername(usuarioRequestDTO.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Nome de usuário já está em uso.");
        }

        String encryptedPassword = passwordEncoder.encode(usuarioRequestDTO.getPassword());

        Usuario novoUsuario = Usuario.builder()
                .username(usuarioRequestDTO.getUsername())
                .password(encryptedPassword)
                .build();

        Usuario usuarioSalvo = usuarioRepository.save(novoUsuario);

        return UsuarioResponseDTO.builder()
                .id(usuarioSalvo.getId())
                .username(usuarioSalvo.getUsername())
                .build();
    }
}
