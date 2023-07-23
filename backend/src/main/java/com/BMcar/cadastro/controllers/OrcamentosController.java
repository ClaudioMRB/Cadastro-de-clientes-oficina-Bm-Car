package com.BMcar.cadastro.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.BMcar.cadastro.dto.OrcamentosDTO;
import com.BMcar.cadastro.services.OrcamentosService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping(value = "/orcamentos")
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:3000"})
public class OrcamentosController {
	
	@Autowired
	private OrcamentosService orcamentoService;


	@GetMapping(value = "{id}")
 	public ResponseEntity<OrcamentosDTO> findById(@PathVariable Long id) {
		
		OrcamentosDTO dto = orcamentoService.findById(id);
		//return dto;
		
		return ResponseEntity.ok(dto);
		
		
	}
	
	@GetMapping("/todosOrcamentos")
	public ResponseEntity<Page<OrcamentosDTO>> findAll(Pageable pageable) {
	
		Page<OrcamentosDTO> dto = orcamentoService.findAll(pageable);
		return ResponseEntity.ok(dto);
		
	}
	
	
	


	@PostMapping()
	public ResponseEntity<OrcamentosDTO> insert(@RequestBody OrcamentosDTO dto) {
	
		dto = orcamentoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);		
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<OrcamentosDTO> update(@PathVariable Long id, @RequestBody OrcamentosDTO dto) {
		
		dto = orcamentoService.update(id, dto);
		//return dto;
		
		return ResponseEntity.ok(dto);
		
		
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		orcamentoService.delete(id);
		//return dto;
		
		return ResponseEntity.noContent().build();
		
		
	}

}
