package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Alumno;

public interface AlumnoService {

	//Crud
	public abstract List<Alumno> listaAlumno();
	public abstract List<Alumno> listaAlumnoPorLike(String filtro);
	public abstract Alumno insertaActualizaAlumno(Alumno obj);
	public abstract List<Alumno> listaPorDni(String dni);
	public abstract List<Alumno> listaPorNombre(String nombre);
	public abstract Optional<Alumno> buscaPorId(int idAlumno);
	
	
}
