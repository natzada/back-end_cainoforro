package com.ex.natzada.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.natzada.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByEmailAndSenha(String email, String senha);

}
