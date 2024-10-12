package org.sistemaacademico.model.repository;

import org.sistemaacademico.model.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
