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

import com.BMcar.cadastro.dto.EnderecoDTO;
import com.BMcar.cadastro.services.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping(value = "{id}")
	public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id) {

		EnderecoDTO dto = enderecoService.findById(id);
		// return dto;

		return ResponseEntity.ok(dto);

	}

	@GetMapping
	public ResponseEntity<Page<EnderecoDTO>> findAll(Pageable pageable) {

		Page<EnderecoDTO> dto = enderecoService.findAll(pageable);
		return ResponseEntity.ok(dto);

	}

	@PostMapping
	public ResponseEntity<EnderecoDTO> insert(@RequestBody EnderecoDTO dto) {

		dto = enderecoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<EnderecoDTO> update(@PathVariable Long id, @RequestBody EnderecoDTO dto) {

		dto = enderecoService.update(id, dto);
		// return dto;

		return ResponseEntity.ok(dto);

	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		enderecoService.delete(id);
		//return dto;
		
		return ResponseEntity.noContent().build();
		
		
	}

}
