package br.com.ifmt.edu.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ifmt.edu.api.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	@Query(value = "SELECT u FROM Aluno u ORDER BY alunoId")
	List<Aluno> findAllOrderedByAlunoId();

}
