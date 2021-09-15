package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;
import com.empresa.util.Constantes;

@RestController
@RequestMapping("/rest/alumno")
@CrossOrigin(origins = "http://localhost:4200")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaAlumno() {
		List<Alumno> lista = alumnoService.listaAlumno();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaAlumno(@RequestBody Alumno obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Alumno objSalida = alumnoService.insertaActualizaAlumno(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
