package com.empresa.service;

import java.util.List;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {

	public Medicamento insertaActualiza(Medicamento obj);
	public List<Medicamento> listaMedicamento();
}
