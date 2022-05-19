package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {

	

	// Para Consulta
	@Query("select x from Docente x where (?1 is '' or x.nombre like ?1) and (?2 is '' or x.dni = ?2) and (?3 is -1 or x.ubigeo.idUbigeo = ?3) and x.estado = ?4")       
	public List<Docente> listaDocentePorNombreDniUbigeo(String nombre, String dni, int idUbigeo, int estado);
	
	//Para el CRUD
	public List<Docente> findByDni(String dni);
	public List<Docente> findByNombre(String nombre);
	public List<Docente> findByNombreLike(String nombre);

	
	
}


