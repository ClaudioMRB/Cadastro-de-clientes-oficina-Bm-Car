package com.BMcar.cadastro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BMcar.cadastro.dto.ClienteDTO;
import com.BMcar.cadastro.entities.Cliente;
import com.BMcar.cadastro.repositories.ClienteRepository;

@Service
public class ClienteService {

	/*
	 * Camada responsável pelas operações de negócios Um método da cmada Service
	 * deve ter um SIGNIFICADO relacionado ao negócio, podendo executar várias
	 * operações. EX: registrarPedido, verificarEstoque, salvarPedido,
	 * baixarEstoque, enviarEmail...
	 */

	
	@Autowired
	private ClienteRepository clienteRepository;
	private PasswordEncoder encoder;
	
	
	
	
	
	public ClienteService(ClienteRepository clienteRepository, PasswordEncoder encoder) {
		super();
		this.clienteRepository = clienteRepository;
		this.encoder = encoder;
	}

	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {

		Optional<Cliente> result = clienteRepository.findById(id);
		Cliente cliente = result.get();
		// converter para DTO
		ClienteDTO dto = new ClienteDTO(cliente);
		return dto;
	}

	
	@Transactional(readOnly = true)
	public Page<ClienteDTO> findAll(Pageable pageable) {

		Page<Cliente> result = clienteRepository.findAll(pageable);
		return result.map(x -> new ClienteDTO(x));
	}

	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {

		Cliente entity = new Cliente();
		copyDtoToEntity(dto, entity);
		entity = clienteRepository.save(entity);
		
		return new ClienteDTO(entity);

	}
	
	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {

		Cliente entity = clienteRepository.getReferenceById(id);
		// entity.setNome(dto.getNome());
		// entity.setCpf(dto.getCpf());
		copyDtoToEntity(dto, entity);
		entity = clienteRepository.save(entity);

		return new ClienteDTO(entity);

	}

	@Transactional
	public void delete(Long id) {

		clienteRepository.deleteById(id);

	}
	
	@GetMapping
	public ResponseEntity<Boolean> validarSenha(@RequestParam String email, @RequestParam String senha){
		
		/*boolean valid = false;
		Optional<Cliente> optCliente = clienteRepository.findByEmail(email);
		if(optCliente.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(valid);
		}
		valid = encoder.matches(senha, optCliente.get().getSenha());*/
		
		
		Optional<Cliente> optCliente = clienteRepository.findByEmail(email);
		if(optCliente.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}
		
	
		boolean valid = encoder.matches(senha, optCliente.get().getSenha());
		
		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;  //HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		
		return ResponseEntity.status(status).body(valid);
	}

	public ClienteDTO findByEmail(String email) {
		Optional<Cliente> optCliente = clienteRepository.findByEmail(email);
		Cliente cliente = optCliente.get();
		ClienteDTO dto = new ClienteDTO(cliente);
		return dto;
	}
	
	
	
	
	
	 private void copyDtoToEntity(ClienteDTO dto, Cliente entity) {

		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setEmail(dto.getEmail());
		entity.setSenha(dto.getSenha());
		entity.setSenha(encoder.encode(entity.getSenha()));
	}

	

}
