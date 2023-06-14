package com.BMcar.cadastro.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.BMcar.cadastro.dto.TecnicosDTO;
import com.BMcar.cadastro.services.TecnicosService;

@RestController
@RequestMapping(value = "/tecnicos")
@CrossOrigin(origins = {"http://127.0.0.1:5500"})
public class TecnicosController {

	@Autowired
	private TecnicosService tecnicoService;


	@GetMapping(value = "{id}")
 	public ResponseEntity<TecnicosDTO> findById(@PathVariable Long id) {
		
		TecnicosDTO dto = tecnicoService.findById(id);
		//return dto;
		
		return ResponseEntity.ok(dto);
		
		
	}
	
	@GetMapping("/todosTecnicos")
	public ResponseEntity<Page<TecnicosDTO>> findAll(Pageable pageable) {
	
		Page<TecnicosDTO> dto = tecnicoService.findAll(pageable);
		return ResponseEntity.ok(dto);
		
	}
	
	
	


	@PostMapping()
	public ResponseEntity<TecnicosDTO> insert(@RequestBody TecnicosDTO dto) {
	
		dto = tecnicoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);		
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<TecnicosDTO> update(@PathVariable Long id, @RequestBody TecnicosDTO dto) {
		
		dto = tecnicoService.update(id, dto);
		//return dto;
		
		return ResponseEntity.ok(dto);
		
		
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		tecnicoService.delete(id);
		//return dto;
		
		return ResponseEntity.noContent().build();
		
		
	}

	
}
