package com.BMcar.cadastro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BMcar.cadastro.dto.TecnicosDTO;
import com.BMcar.cadastro.entities.Tecnicos;
import com.BMcar.cadastro.repositories.TecnicosRepository;

@Service
public class TecnicosService {

	/*
	 * Camada responsável pelas operações de negócios Um método da cmada Service
	 * deve ter um SIGNIFICADO relacionado ao negócio, podendo executar várias
	 * operações. EX: registrarPedido, verificarEstoque, salvarPedido,
	 * baixarEstoque, enviarEmail...
	 */
	
	@Autowired
	private TecnicosRepository tecnicoRepository;

	@Transactional(readOnly = true)
	public TecnicosDTO findById(Long id) {

		Optional<Tecnicos> result = tecnicoRepository.findById(id);
		Tecnicos tecnico = result.get();
		// converter para DTO
		TecnicosDTO dto = new TecnicosDTO(tecnico);
		return dto;

	}

	@Transactional(readOnly = true)
	public Page<TecnicosDTO> findAll(Pageable pageable) {

		Page<Tecnicos> result = tecnicoRepository.findAll(pageable);
		return result.map(x -> new TecnicosDTO(x));
	}

	@Transactional
	public TecnicosDTO insert(TecnicosDTO dto) {

		Tecnicos entity = new Tecnicos();

		
		copyDtoToEntity(dto, entity);
		entity = tecnicoRepository.save(entity);

		return new TecnicosDTO(entity);

	}

	@Transactional
	public TecnicosDTO update(Long id, TecnicosDTO dto) {

		Tecnicos entity = tecnicoRepository.getReferenceById(id);

		
		copyDtoToEntity(dto, entity);
		entity = tecnicoRepository.save(entity);

		return new TecnicosDTO(entity);

	}
	
	@Transactional
	public void delete(Long id) {

		tecnicoRepository.deleteById(id);

	}

	private void copyDtoToEntity(TecnicosDTO dto, Tecnicos entity) {

		entity.setNome(dto.getNome());
	}
}
