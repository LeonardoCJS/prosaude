package com.example.pulseira.monitoramento.gateways;

import com.example.pulseira.monitoramento.dtos.LoginRequestDTO;
import com.example.pulseira.monitoramento.dtos.LoginResponseDTO;
import com.example.pulseira.monitoramento.dtos.UsuarioRequestDTO;
import com.example.pulseira.monitoramento.dtos.UsuarioResponseDTO;
import com.example.pulseira.monitoramento.security.JwtUtil;
import com.example.pulseira.monitoramento.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO loginRequest) {
        // Autentica o usuário com o Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        // Carrega os detalhes do usuário para gerar o token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

        // Gera o token JWT
        final String token = jwtUtil.generateToken(userDetails.getUsername());

        // Retorna o token dentro de um objeto JSON
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponseDTO> register(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioResponseDTO novoUsuario = usuarioService.save(usuarioRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
}

