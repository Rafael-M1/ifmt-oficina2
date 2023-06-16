package br.com.ifmt.edu.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifmt.edu.api.model.TipoAtividade;
import br.com.ifmt.edu.api.repositories.TipoAtividadeRepository;

@Service
public class TipoAtividadeService {

	@Autowired
	private TipoAtividadeRepository repository;
	
	public TipoAtividade salvar(TipoAtividade tipoAtividade) {
		return repository.save(tipoAtividade);
	}
	
	public TipoAtividade buscarPorId(Long tipoAtividadeId) {
		return repository.findById(tipoAtividadeId).get();
	}
	
	public List<TipoAtividade> buscarTodos() {
		return repository.findAllOrderByTipoAtividadeId();
	}
	
	public TipoAtividade atualizar(TipoAtividade tipoAtividade) {
		TipoAtividade tipoAtividadeSalvo = repository.findById(tipoAtividade.getTipoAtividadeId()).get();
		tipoAtividadeSalvo.setDescricao(tipoAtividade.getDescricao());
		repository.save(tipoAtividadeSalvo);
		return tipoAtividadeSalvo;
	}
	
	public void deletar(Long tipoAtividadeId) {
		repository.deleteById(tipoAtividadeId);
	}
}
