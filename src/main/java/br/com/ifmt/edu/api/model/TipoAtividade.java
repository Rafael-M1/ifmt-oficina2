package br.com.ifmt.edu.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipo_atividade")
public class TipoAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tipoAtividadeId;
	@Column(length = 50)
	private String descricao;

	public TipoAtividade() {
	}

	public TipoAtividade(Long tipoAtividadeId, String descricao) {
		this.tipoAtividadeId = tipoAtividadeId;
		this.descricao = descricao;
	}

	public Long getTipoAtividadeId() {
		return tipoAtividadeId;
	}

	public void setTipoAtividadeId(Long tipoAtividadeId) {
		this.tipoAtividadeId = tipoAtividadeId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "TipoAtividade [tipoAtividadeId=" + tipoAtividadeId + ", descricao=" + descricao + "]";
	}
}
