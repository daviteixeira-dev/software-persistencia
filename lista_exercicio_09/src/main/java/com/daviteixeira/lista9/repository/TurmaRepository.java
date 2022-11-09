package com.daviteixeira.lista9.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daviteixeira.lista9.orm.Turma;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Integer>{
    
}
