package com.lista.dao;

import java.util.List;

import com.lista.entidade.Aluno;

public interface AlunoDAO {
    
    public void inserirAluno(Aluno aluno);

    public void deletarAluno(int id);

    public Aluno consultarAluno(int id);

    public List<Aluno> todosAlunos();

    public Aluno consultarAlunoPeloCPF(String cpf);
}
