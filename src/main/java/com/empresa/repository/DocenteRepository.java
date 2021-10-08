package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {

	public List<Docente> findByNombreLike(String filtro);
	
	public List<Docente> findByDni(String filtro);
	
	@Query("Select e from Docente e where e.nombre like :param_nom and e.dni = :param_dni")
	public List<Docente> listaPorNombreDni(@Param("param_nom") String nombre, @Param("param_dni") String dni);
	
	
}


