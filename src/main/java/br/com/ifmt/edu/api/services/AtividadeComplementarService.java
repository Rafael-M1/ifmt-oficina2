package br.com.ifmt.edu.api.services;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifmt.edu.api.model.AtividadeComplementar;
import br.com.ifmt.edu.api.repositories.AtividadeComplementarRepository;

@Service
public class AtividadeComplementarService {

	@Autowired
	private AtividadeComplementarRepository atividadeComplementarRepository;
	
	public String downloadImagem(Long atividadeComplementarId) {
		byte[] imageBytes = atividadeComplementarRepository.findImageByAtividadeComplementarId(atividadeComplementarId);
		String base64String = Base64.getEncoder().encodeToString(imageBytes);
		return "data:image/png;base64," + base64String;
	}

	public AtividadeComplementar buscarPorId(Long id) {
		AtividadeComplementar atividadeComplementar = atividadeComplementarRepository.findById(id).get();
		return atividadeComplementar;
	}

	public List<AtividadeComplementar> buscarTodos() {
		return atividadeComplementarRepository.findAllOrderedById();
	}

	public void atualizar(AtividadeComplementar atividadeComplementar) {
		AtividadeComplementar atividadeComplementarSalvo = atividadeComplementarRepository.findById(atividadeComplementar.getAtividadeComplementarId()).get();
		atividadeComplementarSalvo.setAluno(atividadeComplementar.getAluno());
		atividadeComplementarSalvo.setTipoAtividade(atividadeComplementar.getTipoAtividade());
		atividadeComplementarSalvo.setAnoConclusao(atividadeComplementar.getAnoConclusao());
		atividadeComplementarSalvo.setCargaHoraria(atividadeComplementar.getCargaHoraria());
		atividadeComplementarSalvo.setDescricaoAtividade(atividadeComplementar.getDescricaoAtividade());
		atividadeComplementarSalvo.setInstituicao(atividadeComplementar.getInstituicao());
		atividadeComplementarSalvo.setObservacao(atividadeComplementar.getObservacao());
		if (atividadeComplementar.getArquivo().length > 0) {
			atividadeComplementarSalvo.setArquivo(atividadeComplementar.getArquivo());
		}
		atividadeComplementarRepository.save(atividadeComplementarSalvo);
	}

	public void salvar(AtividadeComplementar atividadeComplementar) {
		atividadeComplementarRepository.save(atividadeComplementar);
	}

	public void deletar(Long id) {
		atividadeComplementarRepository.deleteById(id);
	}
}
