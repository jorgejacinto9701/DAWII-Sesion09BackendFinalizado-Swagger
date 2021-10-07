package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {

	public abstract List<Docente> findByNombreLike(String filtro);
	
}


