package org.sistemaacademico.service;

import org.sistemaacademico.exception.RegraNegocioException;
import org.sistemaacademico.model.entity.Aluno;
import org.sistemaacademico.model.entity.Curso;
import org.sistemaacademico.model.entity.Professor;
import org.sistemaacademico.model.repository.ProfessorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfessorService {

    private ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<Professor> getProfessores() {
        return repository.findAll();
    }

    public Optional<Professor> getProfessorById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Professor salvar(Professor professor) {
        validar(professor);
        return repository.save(professor);
    }

    @Transactional
    public void excluir(Professor professor) {
        Objects.requireNonNull(professor.getId());
        repository.delete(professor);
    }

    public void validar(Professor professor) {
        if (professor.getNome() == null || professor.getNome().trim().equals("")) {
            throw new RegraNegocioException("Nome inválido");
        }
        if (professor.getSobrenome() == null || professor.getSobrenome().trim().equals("")) {
            throw new RegraNegocioException("Sobrenome inválido");
        }
        if (professor.getCpf() == null || professor.getCpf().trim().equals("")) {
            throw new RegraNegocioException("CPF inválido");
        }
        if (professor.getEmail() == null || professor.getEmail().trim().equals("")) {
            throw new RegraNegocioException("Email inválido");
        }
        if (professor.getTelefone() == null) {
            throw new RegraNegocioException("Telefone inválido.");
        }
    }
}
