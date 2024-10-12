package org.sistemaacademico.service;

import org.sistemaacademico.exception.RegraNegocioException;
import org.sistemaacademico.model.entity.Curso;
import org.sistemaacademico.model.repository.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CursoService {

    private CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> getCursos() {
        return repository.findAll();
    }

    public Optional<Curso> getCursoById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Curso salvar(Curso curso) {
        validar(curso);
        return repository.save(curso);
    }

    @Transactional
    public void excluir(Curso curso) {
        Objects.requireNonNull(curso.getId());
        repository.delete(curso);
    }

    public void validar(Curso curso) {
        if (curso.getNomeCurso() == null || curso.getNomeCurso().trim().equals("")) {
            throw new RegraNegocioException("Nome inválido");
        }

        if (curso.getDescricaoCurso() == null || curso.getDescricaoCurso().trim().equals("")) {
            throw new RegraNegocioException("Descrição inválida");
        }

        if (curso.getQuantidadePeriodos() == null || curso.getQuantidadePeriodos() < 0 || curso.getQuantidadePeriodos() > 10) {
            throw new RegraNegocioException("Quantidade de Períodos inválido");
        }
    }
}
