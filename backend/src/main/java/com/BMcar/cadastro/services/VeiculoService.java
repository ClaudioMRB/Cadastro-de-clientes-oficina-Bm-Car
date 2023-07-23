package com.BMcar.cadastro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BMcar.cadastro.dto.VeiculoDTO;
import com.BMcar.cadastro.entities.Veiculo;
import com.BMcar.cadastro.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	/*
	 * Camada responsável pelas operações de negócios Um método da cmada Service
	 * deve ter um SIGNIFICADO relacionado ao negócio, podendo executar várias
	 * operações. EX: registrarPedido, verificarEstoque, salvarPedido,
	 * baixarEstoque, enviarEmail...
	 */

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Transactional(readOnly = true)
	public VeiculoDTO findById(Long id) {

		Optional<Veiculo> result = veiculoRepository.findById(id);
		Veiculo veiculo = result.get();
		// converter para DTO
		VeiculoDTO dto = new VeiculoDTO(veiculo);
		return dto;

	}

	@Transactional(readOnly = true)
	public Page<VeiculoDTO> findAll(Pageable pageable) {

		Page<Veiculo> result = veiculoRepository.findAll(pageable);
		return result.map(x -> new VeiculoDTO(x));
	}

	@Transactional
	public VeiculoDTO insert(VeiculoDTO dto) {

		Veiculo entity = new Veiculo();
		// entity.setNome(dto.getNome());
		// entity.setAno(dto.getCor());
		// entity.setCor(dto.getCor());
		// entity.setCc(dto.getCc());
		// entity.setFabricante(dto.getFabricante());
		copyDtoToEntity(dto, entity);
		entity = veiculoRepository.save(entity);

		return new VeiculoDTO(entity);

	}

	@Transactional
	public VeiculoDTO update(Long id, VeiculoDTO dto) {

		Veiculo entity = veiculoRepository.getReferenceById(id);
		// entity.setNome(dto.getNome());
		// entity.setAno(dto.getCor());
		// entity.setCor(dto.getCor());
		// entity.setCc(dto.getCc());
		// entity.setFabricante(dto.getFabricante());
		copyDtoToEntity(dto, entity);
		entity = veiculoRepository.save(entity);

		return new VeiculoDTO(entity);

	}
	
	@Transactional
	public void delete(Long id) {

	veiculoRepository.deleteById(id);

	}

	private void copyDtoToEntity(VeiculoDTO dto, Veiculo entity) {

		entity.setCarro(dto.getCarro());
		entity.setAno(dto.getCor());
		entity.setCor(dto.getCor());
		entity.setCc(dto.getCc());
		entity.setFabricante(dto.getFabricante());
	}

}
