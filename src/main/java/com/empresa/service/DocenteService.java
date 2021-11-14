package com.empresa.service;

import java.util.List;

import com.empresa.entity.Docente;

public interface DocenteService {

	//Para Consulta
	public abstract List<Docente> listaDocentePorDniNombreUbigeo(String dni, String nombre, int idUbigeo);

	//Para Crud
	public abstract List<Docente> listaPorDni(String dni);
	public abstract List<Docente> listaPorNombre(String nombre);
	public abstract List<Docente> listaPorNombreLike(String nombre);
	public abstract List<Docente> listaTodos();
	public abstract Docente insertaActualizaDocente(Docente obj);
	
}
