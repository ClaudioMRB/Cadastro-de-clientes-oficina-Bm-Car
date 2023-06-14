package com.BMcar.cadastro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BMcar.cadastro.dto.EnderecoDTO;
import com.BMcar.cadastro.entities.Endereco;
import com.BMcar.cadastro.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	/*
	 * Camada responsável pelas operações de negócios Um método da cmada Service
	 * deve ter um SIGNIFICADO relacionado ao negócio, podendo executar várias
	 * operações. EX: registrarPedido, verificarEstoque, salvarPedido,
	 * baixarEstoque, enviarEmail...
	 */

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Transactional(readOnly = true)
	public EnderecoDTO findById(Long id) {

		Optional<Endereco> result = enderecoRepository.findById(id);
		Endereco endereco = result.get();
		// converter para DTO
		EnderecoDTO dto = new EnderecoDTO(endereco);
		return dto;

	}

	@Transactional(readOnly = true)
	public Page<EnderecoDTO> findAll(Pageable pageable) {

		Page<Endereco> result = enderecoRepository.findAll(pageable);
		return result.map(x -> new EnderecoDTO(x));
	}

	@Transactional
	public EnderecoDTO insert(EnderecoDTO dto) {

		Endereco entity = new Endereco();

		// entity.setRua(dto.getRua());
		/// entity.setNumero(dto.getNumero());
		// entity.setBairro(dto.getBairro());
		// entity.setCidade(dto.getCidade());
		// entity.setUf(dto.getUf());
		// entity.setPais(dto.getPais());
		copyDtoToEntity(dto, entity);
		entity = enderecoRepository.save(entity);

		return new EnderecoDTO(entity);

	}

	@Transactional
	public EnderecoDTO update(Long id, EnderecoDTO dto) {

		Endereco entity = enderecoRepository.getReferenceById(id);

		// entity.setRua(dto.getRua());
		// entity.setNumero(dto.getNumero());
		// entity.setBairro(dto.getBairro());
		// entity.setCidade(dto.getCidade());
		// entity.setUf(dto.getUf());
		// entity.setPais(dto.getPais());
		copyDtoToEntity(dto, entity);
		entity = enderecoRepository.save(entity);

		return new EnderecoDTO(entity);

	}
	
	@Transactional
	public void delete(Long id) {

		enderecoRepository.deleteById(id);

	}

	private void copyDtoToEntity(EnderecoDTO dto, Endereco entity) {

		entity.setRua(dto.getRua());
		entity.setNumero(dto.getNumero());
		entity.setBairro(dto.getBairro());
		entity.setCidade(dto.getCidade());
		entity.setUf(dto.getUf());
		entity.setPais(dto.getPais());
	}

}
