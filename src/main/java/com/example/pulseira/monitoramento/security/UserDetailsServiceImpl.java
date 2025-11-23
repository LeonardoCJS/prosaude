package com.example.pulseira.monitoramento.security;

import com.example.pulseira.monitoramento.domains.Usuario;
// Corrigido: O ideal é que o repositório esteja em seu próprio pacote.
import com.example.pulseira.monitoramento.gateways.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList; // Usado para criar uma lista de authorities vazia

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o nome: " + username));

        // Para simplificar, estamos usando uma lista de authorities vazia.
        // Em um sistema real, você carregaria as roles/permissions do usuário.
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
