package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;
import com.empresa.util.Constantes;

@RequestMapping("/rest/crudAlumno")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CrudAlumnoController {

	private Logger log = LoggerFactory.getLogger(CrudAlumnoController.class);
	
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("/listaAlumno")
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaAlumno(){
		log.info("==> listaAlumno ");
		List<Alumno> lista = null;
		try {
			lista = alumnoService.listaAlumno();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaAlumnoPorNombre/{nom}")
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaAlumnoPorNombre(@PathVariable("nom") String nombre){
		log.info("==> listaAlumnoPorNombre ==> nom : " + nombre);
		
		List<Alumno> lista = null;
		try {
			lista = alumnoService.listaPorNombre(nombre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaAlumnoPorDni/{dni}")
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaAlumnoPorDni(@PathVariable("dni") String dni){
		log.info("==> listaAlumnoPorDni ==> dni : " + dni);
		
		List<Alumno> lista = null;
		try {
			lista = alumnoService.listaPorDni(dni);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaAlumnoPorNombreLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaAlumnoPorNombreLike(@PathVariable("nom") String nom){
		log.info("==> listaAlumnoPorNombreLike ==> nom : " + nom);
		
		List<Alumno> lista = null;
		try {
			lista = alumnoService.listaAlumnoPorLike(nom+"%");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaAlumnoPorId/{id}")
	@ResponseBody
	public ResponseEntity<Alumno> listaAlumnoPorId(@PathVariable("id") int idDocente){
		log.info("==> listaAlumnoPorId ==> idDocente : " + idDocente);
		Alumno objAlumno = null;
		try {
			 Optional<Alumno> optAlumno =  alumnoService.buscaPorId(idDocente);
			 if (optAlumno.isEmpty()) {
				 objAlumno = new Alumno(); 
			 }else {
				 objAlumno = optAlumno.get();
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(objAlumno);
	}
	
	@PostMapping("/registraAlumno")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaAlumno(@RequestBody Alumno obj) {
		log.info("==> insertaAlumno ==> ID : " + obj.getIdAlumno());
		log.info("==> insertaAlumno ==> DNI : " + obj.getDni());
		log.info("==> insertaAlumno ==> Nombre : " + obj.getNombre());
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getIdAlumno() == 0) {
				Alumno objSalida = alumnoService.insertaActualizaAlumno(obj);
				if (objSalida == null) {
					salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
				} else {
					salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
				}	
			}else {
				salida.put("mensaje", "El ID del alumno debe ser cero");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizaAlumno")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaAlumno(@RequestBody Alumno obj) {
		log.info("==> actualizaAlumno ==> ID : " + obj.getIdAlumno());
		log.info("==> actualizaAlumno ==> DNI : " + obj.getDni());
		log.info("==> actualizaAlumno ==> Nombre : " + obj.getNombre());
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getIdAlumno() != 0) {
				Alumno objSalida = alumnoService.insertaActualizaAlumno(obj);
				if (objSalida == null) {
					salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
				} else {
					salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
				}	
			}else {
				salida.put("mensaje", "El ID del alumno debe ser diferente cero");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
