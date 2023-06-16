package br.com.ifmt.edu.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ifmt.edu.api.model.TipoAtividade;

@Repository
public interface TipoAtividadeRepository extends JpaRepository<TipoAtividade, Long> {

	@Query(value = "SELECT u FROM TipoAtividade u ORDER BY tipoAtividadeId ")
	List<TipoAtividade> findAllOrderByTipoAtividadeId();
}
