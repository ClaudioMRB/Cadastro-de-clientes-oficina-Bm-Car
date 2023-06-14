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

import com.BMcar.cadastro.dto.VeiculoDTO;

import com.BMcar.cadastro.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculo")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping(value = "{id}")
	public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {

		VeiculoDTO dto = veiculoService.findById(id);
		//return dto;

		return ResponseEntity.ok(dto);
		
	}
	
	@GetMapping
	public ResponseEntity<Page<VeiculoDTO>> findAll(Pageable pageable) {
	
		Page<VeiculoDTO> dto = veiculoService.findAll(pageable);
		return ResponseEntity.ok(dto);
		
	}
	
	@PostMapping
	public ResponseEntity<VeiculoDTO> insert(@RequestBody VeiculoDTO dto) {
	
		dto = veiculoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);		
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @RequestBody VeiculoDTO dto) {

		dto = veiculoService.update(id, dto);
		//return dto;

		return ResponseEntity.ok(dto);
		
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		veiculoService.delete(id);
		//return dto;
		
		return ResponseEntity.noContent().build();
		
		
	}

}
