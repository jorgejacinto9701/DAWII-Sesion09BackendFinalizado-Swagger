package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {

	

	// Para Consulta
	@Query("select d from Docente d where "
			+ "( :p_dni is '' or d.dni = :p_dni ) and "
			+ "( :p_nom is '' or d.nombre like :p_nom ) and "
			+ "( :p_ubi is 0  or d.ubigeo.idUbigeo = :p_ubi ) ")
	public abstract List<Docente> listaDocentePorDniNombreUbigeo(
								 	@Param("p_dni") String dni, 
								 	@Param("p_nom") String nombre,
								 	@Param("p_ubi") int idUbigeo);
	
	//Para el CRUD
	public List<Docente> findByDni(String dni);
	public List<Docente> findByNombre(String nombre);
	public List<Docente> findByNombreLike(String nombre);

	
	
}


