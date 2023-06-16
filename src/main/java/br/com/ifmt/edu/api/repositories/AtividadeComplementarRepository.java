package br.com.ifmt.edu.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ifmt.edu.api.model.AtividadeComplementar;

@Repository
public interface AtividadeComplementarRepository extends JpaRepository<AtividadeComplementar, Long> {
	@Query("SELECT u.arquivo FROM AtividadeComplementar u WHERE u.atividadeComplementarId = :atividadeComplementarId ")
	byte[] findImageByAtividadeComplementarId(Long atividadeComplementarId);

	@Query("SELECT u FROM AtividadeComplementar u ORDER BY u.atividadeComplementarId ")
	List<AtividadeComplementar> findAllOrderedById();
}
