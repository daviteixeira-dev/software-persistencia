package com.daviteixeira.lista9.orm;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "turmas")
public class Turma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String periodo;
    @Column(nullable = false)
    private String disciplina;

    @OneToMany(mappedBy = "turma", fetch = FetchType.LAZY)
    private List<AlunoTurma> turmas_alunos;

    @Deprecated
    public Turma(){}

    public Turma(int id, String periodo, String disciplina, List<AlunoTurma> turmas_alunos) {
        this.id = id;
        this.periodo = periodo;
        this.disciplina = disciplina;
        this.turmas_alunos = turmas_alunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public List<AlunoTurma> getTurmas_alunos() {
        return turmas_alunos;
    }

    public void setTurmas_alunos(List<AlunoTurma> turmas_alunos) {
        this.turmas_alunos = turmas_alunos;
    }

    @Override
    public String toString() {
        return "Turma [id=" + id + ", periodo=" + periodo + ", disciplina=" + disciplina + ", turmas_alunos="
                + turmas_alunos + "]";
    }
}
