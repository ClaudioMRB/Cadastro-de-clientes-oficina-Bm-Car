package com.BMcar.cadastro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BMcar.cadastro.dto.OrcamentosDTO;
import com.BMcar.cadastro.entities.Orcamentos;
import com.BMcar.cadastro.repositories.OrcamentosRepository;

@Service
public class OrcamentosService {

	/*
	 * Camada responsável pelas operações de negócios Um método da cmada Service
	 * deve ter um SIGNIFICADO relacionado ao negócio, podendo executar várias
	 * operações. EX: registrarPedido, verificarEstoque, salvarPedido,
	 * baixarEstoque, enviarEmail...
	 */
	
	@Autowired
	private OrcamentosRepository orcamentoRepository;

	@Transactional(readOnly = true)
	public OrcamentosDTO findById(Long id) {

		Optional<Orcamentos> result = orcamentoRepository.findById(id);
		Orcamentos orcamento = result.get();
		// converter para DTO
		OrcamentosDTO dto = new OrcamentosDTO(orcamento);
		return dto;

	}

	@Transactional(readOnly = true)
	public Page<OrcamentosDTO> findAll(Pageable pageable) {

		Page<Orcamentos> result = orcamentoRepository.findAll(pageable);
		return result.map(x -> new OrcamentosDTO(x));
	}

	@Transactional
	public OrcamentosDTO insert(OrcamentosDTO dto) {

		Orcamentos entity = new Orcamentos();

		copyDtoToEntity(dto, entity);
		entity = orcamentoRepository.save(entity);

		return new OrcamentosDTO(entity);

	}

	@Transactional
	public OrcamentosDTO update(Long id, OrcamentosDTO dto) {

		Orcamentos entity = orcamentoRepository.getReferenceById(id);

		// entity.setRua(dto.getRua());
		// entity.setNumero(dto.getNumero());
		// entity.setBairro(dto.getBairro());
		// entity.setCidade(dto.getCidade());
		// entity.setUf(dto.getUf());
		// entity.setPais(dto.getPais());
		copyDtoToEntity(dto, entity);
		entity = orcamentoRepository.save(entity);

		return new OrcamentosDTO(entity);

	}
	
	@Transactional
	public void delete(Long id) {

		orcamentoRepository.deleteById(id);

	}

	private void copyDtoToEntity(OrcamentosDTO dto, Orcamentos entity) {

		entity.setDefeitoRelatado(dto.getDefeitoRelatado());
		entity.setDiagnosticoTecnico(dto.getDiagnosticoTecnico());
		entity.setImage01(dto.getImage01());
		entity.setImage02(dto.getImage02());
		
	}
	
	
}
