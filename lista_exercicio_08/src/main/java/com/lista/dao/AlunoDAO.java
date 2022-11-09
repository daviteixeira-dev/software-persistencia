package com.lista.dao;

import java.util.List;

import com.lista.entidade.Aluno;

public interface AlunoDAO {
    
    public void inserirAluno(Aluno aluno);
    
    public List<Aluno> todosAlunos();
    
    public void deletarAluno(int id);

    public void updateAluno(Aluno aluno);

    //public Aluno consultarAluno(int id);

    //public Aluno consultarAlunoPeloCPF(String cpf);

}