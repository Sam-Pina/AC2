package com.example.ac2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac2.models.ResultadoUsuario;

public interface ResultadoUsuarioRepository extends JpaRepository<ResultadoUsuario, Long>{
    @Query("select cc from ResultadoUsuario cc left join fetch cc.cursos c where cc.id = :id")
ResultadoUsuario findCategoriaCursoFetchCursos(@Param("id") Long id);
}
