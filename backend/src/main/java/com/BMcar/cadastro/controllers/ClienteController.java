package com.BMcar.cadastro.controllers;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.BMcar.cadastro.dto.ClienteDTO;
import com.BMcar.cadastro.services.ClienteService;


@RestController
@RequestMapping(value = "/cliente")
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:3000"})
public class ClienteController {
	
	
	
	@Autowired
	private ClienteService clienteService;


	@GetMapping(value = "{id}")
 	public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
		
		ClienteDTO dto = clienteService.findById(id);
		//return dto;
		
		return ResponseEntity.ok(dto);
		
		
	}
	
	@GetMapping("/todosClientes")
	public ResponseEntity<Page<ClienteDTO>> findAll(Pageable pageable) {
	
		Page<ClienteDTO> dto = clienteService.findAll(pageable);
		return ResponseEntity.ok(dto);
		
	}
	
	@GetMapping("/validar")
	public ResponseEntity<Boolean> validarSenha(@RequestHeader("Authorization") String authorization) {
	// Decodifica as informações de login e senha
	String base64Credentials = authorization.substring("Basic".length()).trim();
	byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
	String credentials = new String(credDecoded, StandardCharsets.UTF_8);
	final String[] values = credentials.split(":", 2);
	String email = values[0];
	String senha = values[1];

	return clienteService.validarSenha(email, senha);
	}

	@GetMapping("/buscarPorEmail")
public ResponseEntity<ClienteDTO> findByEmail(@RequestParam String email) {
    ClienteDTO cliente = clienteService.findByEmail(email);
    if (cliente != null) {
        return ResponseEntity.ok(cliente);
    } else {
        return ResponseEntity.notFound().build();
    }
}


	@PostMapping()
	public ResponseEntity<ClienteDTO> insert(@RequestBody ClienteDTO dto) {
	
		dto = clienteService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);		
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO dto) {
		
		dto = clienteService.update(id, dto);
		//return dto;
		
		return ResponseEntity.ok(dto);
		
		
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		clienteService.delete(id);
		//return dto;
		
		return ResponseEntity.noContent().build();
		
		
	}
}
