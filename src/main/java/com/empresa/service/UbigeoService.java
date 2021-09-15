package com.empresa.service;

import java.util.List;

import com.empresa.entity.Ubigeo;

public interface UbigeoService {

	public abstract List<String> listaDepartamentos();
	public abstract List<String> listaProvincias(String departamento);
	public abstract List<Ubigeo> listaDistritos(String departamento,String provincia);
	
}
