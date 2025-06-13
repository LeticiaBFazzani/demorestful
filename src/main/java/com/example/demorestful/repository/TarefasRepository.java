package com.example.demorestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demorestful.model.Tarefas;

@Repository
public interface TarefasRepository  extends JpaRepository <Tarefas, Long>{

}
