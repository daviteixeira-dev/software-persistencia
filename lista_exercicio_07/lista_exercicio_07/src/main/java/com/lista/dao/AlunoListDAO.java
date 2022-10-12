package com.lista.dao;

import java.util.List;
import java.util.ArrayList;

import com.lista.entidade.Aluno;

public class AlunoListDAO implements AlunoDAO {
    
    private List<Aluno> listaDeAlunos;

    public static int proximoId = 1;

    public AlunoListDAO() {
        this.listaDeAlunos = new ArrayList<Aluno>();
    }

    public List<Aluno> todosAlunos() {
		return this.listaDeAlunos;
	}

    private int findIndex(int id) {
		for (int i = 0; i < listaDeAlunos.size(); i++) {
			if (listaDeAlunos.get(i).getId() == id) {
				return i;
			}
		}

		return -1;
	}

    public void inserirAluno(Aluno aluno){
        if(aluno.getId() == 0){
            aluno.setId(proximoId++);
            listaDeAlunos.add(aluno);
        }else{
            int listPosition = findIndex(aluno.getId());
            listaDeAlunos.set(listPosition, aluno);
        }
    }

    public Aluno consultarAluno(int id){
        for (Aluno aluno : this.listaDeAlunos) {
			if (aluno.getId() == id) {
				return aluno;
			}
		}
		return null;
    }

    public void deletarAluno(int id){
        listaDeAlunos.remove(consultarAluno(id));
    }

    public Aluno consultarAlunoPeloCPF(String cpf) {
		for (Aluno alu : this.listaDeAlunos) {
			if (alu.getCpf().equals(cpf)) {
				return alu;
			}
		}
		return null;
	}
}
