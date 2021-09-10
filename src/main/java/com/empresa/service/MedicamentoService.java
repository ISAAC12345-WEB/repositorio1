package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {

	public abstract Medicamento insertaActualiza(Medicamento obj);
	public abstract List<Medicamento> listaMedicamento();
	
	public abstract Optional<Medicamento> buscaPorId(int idMedicamento);
	public abstract List<Medicamento> listaMedicamentoPorNombre(String nombre);
	public abstract Optional<Medicamento> listaMedicamentoPorStock(int idMedicamento);
}
