package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Docente;
import com.empresa.service.DocenteService;
import com.empresa.util.Constantes;

@RequestMapping("/rest/crudDocente")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CrudDocenteController {

	private Logger log = LoggerFactory.getLogger(CrudDocenteController.class);

	@Autowired
	private DocenteService docenteService;

	@GetMapping("/listaDocentePorNombreLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Docente>> listaDocentePorNombreLike(@PathVariable("nom") String nom) {
		log.info("==> listaDocentePorNombreLike ==> nom : " + nom);

		List<Docente> lista = null;
		try {
			lista = docenteService.listaPorNombreLike(nom + "%");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}

	@PostMapping("/registraDocente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaDocente(@RequestBody Docente obj) {
		log.info("==> insertaDocente ==> ID : " + obj.getIdDocente());
		log.info("==> insertaDocente ==> DNI : " + obj.getDni());
		log.info("==> insertaDocente ==> Nombre : " + obj.getNombre());
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getIdDocente() != 0) {
				salida.put("mensaje", "El ID del Docente debe ser cero");
				return ResponseEntity.ok(salida);
			}

			List<Docente> lista = null;

			lista = docenteService.listaPorDni(obj.getDni());
			if (!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "El DNI ya existe : " + obj.getDni());
				return ResponseEntity.ok(salida);
			}
			lista = docenteService.listaPorNombre(obj.getNombre());
			if (!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "El Nombre ya existe : " + obj.getNombre());
				return ResponseEntity.ok(salida);
			}

			Docente objSalida = docenteService.insertaActualizaDocente(obj);
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

	@PutMapping("/actualizaDocente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaDocente(@RequestBody Docente obj) {
		log.info("==> actualizaDocente ==> ID : " + obj.getIdDocente());
		log.info("==> actualizaDocente ==> DNI : " + obj.getDni());
		log.info("==> actualizaDocente ==> Nombre : " + obj.getNombre());
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getIdDocente() == 0) {
				salida.put("mensaje", "El ID del Docente debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			Docente objSalida = docenteService.insertaActualizaDocente(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizaEstadoDocente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaEstadoDocente(@RequestBody Docente obj) {
		log.info("==> actualizaEstadoDocente ==> ID : " + obj.getIdDocente());
		log.info("==> actualizaEstadoDocente ==> Estado : " + obj.getEstado());
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getIdDocente() == 0) {
				salida.put("mensaje", "El ID del Docente debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			
			Optional<Docente> optDocente =  docenteService.buscaPorId(obj.getIdDocente());
			if (optDocente.isEmpty()) {
				salida.put("mensaje", "No existe el docente con ID : " + obj.getIdDocente());
				return ResponseEntity.ok(salida);
			}
			
			Docente objActualiza = optDocente.get();
			objActualiza.setEstado(obj.getEstado());
			
			Docente objSalida = docenteService.insertaActualizaDocente(objActualiza);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
