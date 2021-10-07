package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {

	public abstract List<Docente> findByNombreLike(String filtro);
	
	@Query("select e from Docente e where e.nombre =:param_nom and e.dni =:param_dni")
	public abstract List<Docente> listaPorNombreDni(@Param("param_nom") String nombre,@Param("param_dni") String dni);

}


