package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Docente;
import com.empresa.entity.FiltroDocente;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {

	//Query por el nombre del método
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
		
	public List<Docente> findByDni(String dni);
	public List<Docente> findByNombreContaining(String nombre);
	
	//JPQL es un select con Clases y atributos
	@Query("select d from Docente d where  (:p_dni is '' or  d.dni = :p_dni) and (:p_nombre is '' or d.nombre like :p_nombre)")
	public List<Docente> listaPorDniNombre(@Param("p_dni") String dni,@Param("p_nombre") String nombre);
	
	@Query("select d from Docente d where  "
					+ "	( :#{#fil.dni} is ''   or d.dni = :#{#fil.dni} ) and "
					+ "( :#{#fil.nombre} is ''  or d.nombre like :#{#fil.nombre} ) and"
					+ "( :#{#fil.idUbigeo} is 0 or d.ubigeo.idUbigeo = :#{#fil.idUbigeo} ) ")
	public List<Docente> listaPorFiltro(@Param("fil") FiltroDocente filtro );
	
	
}


