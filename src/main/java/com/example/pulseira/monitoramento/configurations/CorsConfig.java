package com.example.pulseira.monitoramento.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //Marca a classe como um arquivo de configuração do Spring

//Marca a classe como um arquivo de configuração do Spring
public class CorsConfig implements WebMvcConfigurer {

    //Metodo que configura as regras de CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // <- funciona com credentials
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);

    }
}