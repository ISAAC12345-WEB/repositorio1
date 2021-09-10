package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;

@RestController
@RequestMapping("/rest/medicamento")
public class MedicamentoController {

	@Autowired
	private MedicamentoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listaMedicamento(){
		List<Medicamento> lista = service.listaMedicamento();
		return ResponseEntity.ok(lista);
	}
	@PostMapping
	@ResponseBody
	public ResponseEntity<Medicamento> registraMedicamento(@RequestBody Medicamento obj){
		Medicamento objSalida = service.insertaActualiza(obj);
		if (objSalida == null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(objSalida);
	}
	@PutMapping
	@ResponseBody
	public ResponseEntity<Medicamento> actualizaMedicamento(@RequestBody Medicamento obj){
		
		if(obj == null) {
			return ResponseEntity.badRequest().build();
		}else {
		Optional<Medicamento> optMedicamento = service.buscaPorId(obj.getIdMedicamento());
			if(optMedicamento.isPresent()) {
			Medicamento objActualizado=service.insertaActualiza(obj);
				return ResponseEntity.ok(objActualizado);
			}else {
				return ResponseEntity.badRequest().build();
			}
		}
		
	}
	
	@GetMapping("/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Medicamento> listaMedicamentoPorId(@PathVariable("paramId")int idMedicamento){
		Optional<Medicamento> optMedicamento = service.buscaPorId(idMedicamento);
		if(optMedicamento.isPresent()) {
			return ResponseEntity.ok(optMedicamento.get());
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	@GetMapping("/id/{paramNombre}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listaMedicamentoPorDni(@PathVariable("nombre")String nombre){
		List<Medicamento> lista = service.listaMedicamentoPorNombre(nombre);	
		if(CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
}
