package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Docente;
import com.empresa.repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService {

	@Autowired
	private DocenteRepository repository;

	
	@Override
	public List<Docente> listaDocentePorNombreDniUbigeo(String dni, String nombre, int idUbigeo, int estado) {
		return repository.listaDocentePorNombreDniUbigeo(dni, nombre, idUbigeo, estado);
	}



	@Override
	public List<Docente> listaPorDni(String dni) {
		return repository.findByDni(dni);
	}


	@Override
	public List<Docente> listaPorNombre(String nombre) {
		return repository.findByNombre(nombre);
	}


	@Override
	public List<Docente> listaPorNombreLike(String nombre) {
		return repository.findByNombreLike(nombre);
	}


	@Override
	public Docente insertaActualizaDocente(Docente obj) {
		return repository.save(obj);
	}


	@Override
	public List<Docente> listaTodos() {
		return repository.findAll();
	}






}
