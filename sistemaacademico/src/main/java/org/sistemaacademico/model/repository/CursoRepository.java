package org.sistemaacademico.model.repository;

import org.sistemaacademico.model.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
