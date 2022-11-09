package com.daviteixeira.lista9.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alunos_turmas")
public class AlunoTurma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float nota_final;
    private int qtd_faltas;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = true)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "turma_id", nullable = true)
    private Turma turma;

    @Deprecated
    public AlunoTurma(){}

    public AlunoTurma(float nota_final, int qtd_faltas, Aluno aluno) {
        this.nota_final = nota_final;
        this.qtd_faltas = qtd_faltas;
        this.aluno = aluno;
    }

    public int getId() {
        return id;
    }

    public float getNota_final() {
        return nota_final;
    }

    public void setNota_final(float nota_final) {
        this.nota_final = nota_final;
    }

    public int getQtd_faltas() {
        return qtd_faltas;
    }

    public void setQtd_faltas(int qtd_faltas) {
        this.qtd_faltas = qtd_faltas;
    }

    public Aluno getAluno(){
        return aluno;
    }

    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "AlunoTurma [id=" + id + ", nota_final=" + nota_final + ", qtd_faltas=" + qtd_faltas + ", aluno=" + aluno
                + "]";
    }
}
