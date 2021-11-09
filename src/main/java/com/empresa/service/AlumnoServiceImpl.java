package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Alumno;
import com.empresa.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;

	@Override
	public List<Alumno> listaAlumno() {
		return repository.findAll();
	}

	@Override
	public Alumno insertaActualizaAlumno(Alumno obj) {
		return repository.save(obj);
	}

	@Override
	public List<Alumno> listaPorDni(String dni) {
		return repository.findByDni(dni);
	}

	@Override
	public List<Alumno> listaPorNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	public Optional<Alumno> buscaPorId(int idAlumno) {
		return repository.findById(idAlumno);
	}

	@Override
	public List<Alumno> listaAlumnoPorLike(String filtro) {
		return repository.findByNombreLike(filtro);
	}

}
