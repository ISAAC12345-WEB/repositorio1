package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Alumno;
import com.empresa.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{
	
	@Autowired
	private AlumnoRepository repository;
	
	
	@Override
	public Alumno insertaActualiza(Alumno obj) {
		return repository.save(obj);
	}

	@Override
	public List<Alumno> listaAlumno() {
	
		return repository.findAll();
	}

	@Override//busca id de alumno 
	public Optional<Alumno> buscaPorId(int idAlumno) {
		
		return repository.findById(idAlumno);
	}

	@Override
	public void eliminaPorId(int idAlumno) {
		
		repository.deleteById(idAlumno);//no retorna valor
	}

	@Override// alumno por dni
	public List<Alumno> listaAlumnoPorDni(String dni) {
		// TODO Auto-generated method stub
		return repository.findByDni(dni);
	}


}
