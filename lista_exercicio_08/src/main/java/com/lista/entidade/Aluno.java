package com.lista.entidade;

import javax.persistence.*;

@NamedQuery(name="Aluno.findAll", query="select c from alunos as c")
@NamedQuery(name="Aluno.findByIniciadosPorNome", query="select c from alunos as c where c.nome like :nome")

@Entity
@Table(name = "alunos")
public class Aluno {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Integer id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String matricula;

    public Aluno(){}

    public Aluno(String cpf, String nome, String email, String telefone, String matricula) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
                + ", matricula=" + matricula + "]";
    };
}