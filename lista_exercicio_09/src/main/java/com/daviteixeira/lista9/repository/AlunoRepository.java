package com.daviteixeira.lista9.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daviteixeira.lista9.orm.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer>{
    
}
