package com.example.ac2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ac2.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
List<Usuario> findByNomeLike(String nome);
}
