package org.sistemaacademico.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCurso;
    private String descricaoCurso;
    private Integer quantidadePeriodos;

    @ManyToOne
    private Professor coordenador;

    @ManyToOne
    private Professor professor;

    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos;
}
