package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Alumno;

public interface AlumnoService {

	public abstract Alumno insertaActualiza(Alumno obj);
	public abstract List<Alumno> listaAlumno();
	
	public abstract Optional<Alumno> buscaPorId(int idAlumno);//permitir y devolver de preguntar de forma rapida encontrar un valor
	
	public abstract void eliminaPorId(int idAlumno);
	public abstract List<Alumno> listaAlumnoPorDni(String dni);
	
}
