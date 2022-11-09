package com.daviteixeira.lista9.orm;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false, unique = true)
    private int matricula;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private List<AlunoTurma> alunos_turmas;

    @Deprecated
    public Aluno(){}

    public Aluno(String cpf, int matricula, String nome, String email, String telefone) {
        this.cpf = cpf;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<AlunoTurma> getAlunoTurma(){
        return alunos_turmas;
    }

    public void setAlunoTurma(List<AlunoTurma> alunoTurmas){
        this.alunos_turmas = alunoTurmas;
    }

    @PreRemove
    public void atualizaAlunoTurmaOnRemove(){
        System.out.println("***** atualizaAlunoTurmaOnRemove *****");
        for(AlunoTurma alunoTurma : this.getAlunoTurma()){
            alunoTurma.setAluno(null);
        }
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", cpf=" + cpf + ", matricula=" + matricula + ", nome=" + nome + ", email=" + email
                + ", telefone=" + telefone + "]";
    }

}
