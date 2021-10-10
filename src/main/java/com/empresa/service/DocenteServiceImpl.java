package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Docente;
import com.empresa.entity.FiltroDocente;
import com.empresa.repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService {

	@Autowired
	private DocenteRepository repository;

	@Override
	public List<Docente> listaDocente() {
		return repository.findAll();
	}

	@Override
	public Docente insertaActualizaDocente(Docente obj) {
		return repository.save(obj);
	}

	@Override
	public List<Docente> listaDocentePorDni(String dni) {
		return repository.findByDni(dni);
	}

	@Override
	public List<Docente> listaDocentePorNombre(String nombre) {
		return repository.findByNombreContaining(nombre);
	}

	@Override
	public List<Docente> listaDocentePorDniNombre(String dni, String nombre) {
		return repository.listaPorDniNombre(dni, nombre);
	}

	@Override
	public List<Docente> listaPorFiltro(FiltroDocente obj) {
		return repository.listaPorFiltro(obj);
	}

}
