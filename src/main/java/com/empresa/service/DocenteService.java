package com.empresa.service;

import java.util.List;

import com.empresa.entity.Docente;

public interface DocenteService {

	//Para la consulta
	public abstract List<Docente> listaDocentePorNombreDniUbigeo(String dni, String nombre, int idUbigeo,int estado);

	//Para el Crud
	public abstract Docente insertaActualizaDocente(Docente docente);
	public abstract List<Docente> listaDocentePorNombreLike(String nombre);
	
	
}
