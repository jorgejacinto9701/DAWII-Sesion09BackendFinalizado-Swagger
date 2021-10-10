package com.empresa.service;

import java.util.List;

import com.empresa.entity.Docente;
import com.empresa.entity.FiltroDocente;

public interface DocenteService {

	public abstract List<Docente> listaDocente();

	public abstract Docente insertaActualizaDocente(Docente obj);

	public abstract List<Docente> listaDocentePorDni(String dni);
	
	public abstract List<Docente> listaDocentePorNombre(String nombre);
	
	public abstract List<Docente> listaDocentePorDniNombre(String dni,String nombre);
	
	public abstract List<Docente> listaPorFiltro(FiltroDocente filtro );
}
