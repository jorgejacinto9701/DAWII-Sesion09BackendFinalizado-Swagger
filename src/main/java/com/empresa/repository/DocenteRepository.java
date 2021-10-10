package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Docente;
import com.empresa.entity.FiltroDocente;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {

	
	//Query apartir del nombre del método
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

	public abstract List<Docente> findByDni(String dni);
	public abstract List<Docente> findByNombreContaining(String dni);
	
	
	//JPQL es un query con las clases y atributos (entidades)
	@Query("select d from Docente d where "
						+ "( :p_dni is '' or d.dni = :p_dni ) and "
						+ "( :p_nom is '' or d.nombre like :p_nom )")
	public abstract List<Docente> listaDocentePorDniNombre(
										 	@Param("p_dni") String dni, 
										 	@Param("p_nom") String nombre);
	
	
	@Query("select d from Docente d where "
			+ "( :p_dni is '' or d.dni = :p_dni ) and "
			+ "( :p_nom is '' or d.nombre like :p_nom ) and "
			+ "( :p_ubi is 0  or d.ubigeo.idUbigeo = :p_ubi ) ")
	public abstract List<Docente> listaDocentePorDniNombreUbigeo(
								 	@Param("p_dni") String dni, 
								 	@Param("p_nom") String nombre,
								 	@Param("p_ubi") int idUbigeo);
	
	
	@Query("select d from Docente d where "
			+ "( :#{#fil.dni} is '' or d.dni = :#{#fil.dni} ) and "
			+ "( :#{#fil.nombre} is '' or d.nombre like :#{#fil.nombre} ) and "
			+ "( :#{#fil.idUbigeo} is 0  or d.ubigeo.idUbigeo = :#{#fil.idUbigeo} ) ")
	public abstract List<Docente> listaPorFiltro(@Param("fil")FiltroDocente filtro);
	
	
	
	
	
}


