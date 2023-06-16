package br.com.ifmt.edu.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifmt.edu.api.model.Aluno;
import br.com.ifmt.edu.api.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public Aluno salvar(Aluno aluno) {
		return repository.save(aluno);
	}

	public List<Aluno> buscarTodos() {
		return repository.findAllOrderedByAlunoId();
	}
	
	public Aluno buscarPorId(Long alunoId) {
		return repository.findById(alunoId).get();
	}
	
	public Aluno atualizar(Aluno aluno) {
		Aluno alunoSalvo = repository.findById(aluno.getAlunoId()).get();
		alunoSalvo.setNome(aluno.getNome());
		alunoSalvo.setEmail(aluno.getEmail());
		alunoSalvo.setCpf(aluno.getCpf());
		alunoSalvo.setMatricula(aluno.getMatricula());
		alunoSalvo.setTelefone(aluno.getTelefone());
		repository.save(alunoSalvo);
		return alunoSalvo;
	}
	
	public void deletar(Long alunoId) {
		repository.deleteById(alunoId);
	}
}
