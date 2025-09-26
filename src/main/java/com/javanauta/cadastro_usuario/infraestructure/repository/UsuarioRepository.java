package com.javanauta.cadastro_usuario.infraestructure.repository;

import com.javanauta.cadastro_usuario.infraestructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//public interface UsuarioRepository extends JpaRepository<Nome da Tabela Entity, Tipo do ID da Entity> {
//}

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    @Transactional //garante a atomicidade de um conjunto de operações no banco.
    void deleteByEmail(String email);
}


