package com.example.plaza_comidas.infrastructure.configuration;

import com.example.plaza_comidas.domain.api.IRolServicePort;
import com.example.plaza_comidas.domain.api.IUsuarioServicePort;
import com.example.plaza_comidas.domain.spi.passwordencoder.IUsuarioPasswordEncoderPort;
import com.example.plaza_comidas.domain.spi.persistence.IRolPersistencePort;
import com.example.plaza_comidas.domain.spi.persistence.IUsuarioPersistencePort;
import com.example.plaza_comidas.domain.usecase.RolUseCase;
import com.example.plaza_comidas.domain.usecase.UsuarioUseCase;
import com.example.plaza_comidas.infrastructure.output.jpa.adapter.RolJpaAdapter;
import com.example.plaza_comidas.infrastructure.output.jpa.adapter.UsuarioJpaAdapter;
import com.example.plaza_comidas.infrastructure.output.jpa.mapper.RolEntityMapper;
import com.example.plaza_comidas.infrastructure.output.jpa.mapper.UsuarioEntityMapper;
import com.example.plaza_comidas.infrastructure.output.jpa.repository.IRolRepository;
import com.example.plaza_comidas.infrastructure.output.jpa.repository.IUsuarioRepository;
import com.example.plaza_comidas.infrastructure.output.passwordencoder.BCrypPasswordEncoderAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper usuarioEntityMapper;
    private final IRolRepository rolRepository;
    private final RolEntityMapper rolEntityMapper;


    @Bean
    public IUsuarioPasswordEncoderPort usuarioPasswordEncoderPort() {
        return new BCrypPasswordEncoderAdapter();
    }

    @Bean
    public IUsuarioPersistencePort usuarioPersistencePort() {
        return new UsuarioJpaAdapter(usuarioRepository, usuarioEntityMapper);
    }

    @Bean
    public IUsuarioServicePort usuarioServicePort() {
        return new UsuarioUseCase(usuarioPersistencePort(), usuarioPasswordEncoderPort());
    }

    @Bean
    public IRolPersistencePort rolPersistencePort() {
        return new RolJpaAdapter(rolRepository, rolEntityMapper);
    }

    @Bean
    public IRolServicePort rolServicePort() {
        return new RolUseCase(rolPersistencePort());
    }
}
