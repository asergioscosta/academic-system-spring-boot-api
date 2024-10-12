package org.sistemaacademico.service;

import org.sistemaacademico.exception.RegraNegocioException;
import org.sistemaacademico.exception.SenhaInvalidaException;
import org.sistemaacademico.model.entity.Usuario;
import org.sistemaacademico.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService {


    @Autowired
    public UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> getUsuarios() {
        return repository.findAll();
    }

    @Transactional
    public Usuario salvar(Usuario usuario){
        validar(usuario);
        return repository.save(usuario);
    }

    @Transactional
    public void excluir(Usuario usuario) {
        Objects.requireNonNull(usuario.getId());
        repository.delete(usuario);
    }

    public void validar(Usuario usuario) {
        if (usuario.getLogin() == null || usuario.getLogin().trim().equals("")) {
            throw new RegraNegocioException("Login inválido");
        }
        if (usuario.getCpf() == null || usuario.getCpf().trim().equals("")) {
            throw new RegraNegocioException("CPF inválido");
        }
    }

}
