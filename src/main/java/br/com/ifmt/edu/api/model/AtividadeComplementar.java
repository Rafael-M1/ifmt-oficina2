package br.com.ifmt.edu.api.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_atividade_complementar")
public class AtividadeComplementar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long atividadeComplementarId;
	@OneToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	@OneToOne
	@JoinColumn(name = "tipo_atividade_id")
	private TipoAtividade tipoAtividade;
	@Column(length = 200)
	private String descricaoAtividade;
	private Integer cargaHoraria;
	@Column(length = 100)
	private String instituicao;
	private Integer anoConclusao;
	@Column(length = 10000)
	private byte[] arquivo;
	@Column(length = 500)
	private String observacao;

	public AtividadeComplementar() {
	}

	public AtividadeComplementar(Long atividadeComplementarId, Aluno alunoId, TipoAtividade tipoAtividadeId,
			String descricaoAtividade, Integer cargaHoraria, String instituicao, Integer anoConclusao, byte[] arquivo,
			String observacao) {
		this.atividadeComplementarId = atividadeComplementarId;
		this.aluno = alunoId;
		this.tipoAtividade = tipoAtividadeId;
		this.descricaoAtividade = descricaoAtividade;
		this.cargaHoraria = cargaHoraria;
		this.instituicao = instituicao;
		this.anoConclusao = anoConclusao;
		this.arquivo = arquivo;
		this.observacao = observacao;
	}

	public Long getAtividadeComplementarId() {
		return atividadeComplementarId;
	}

	public void setAtividadeComplementarId(Long atividadeComplementarId) {
		this.atividadeComplementarId = atividadeComplementarId;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno alunoId) {
		this.aluno = alunoId;
	}

	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Integer getAnoConclusao() {
		return anoConclusao;
	}

	public void setAnoConclusao(Integer anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "AtividadeComplementar [atividadeComplementarId=" + atividadeComplementarId + ", aluno=" + aluno
				+ ", tipoAtividade=" + tipoAtividade + ", descricaoAtividade=" + descricaoAtividade + ", cargaHoraria="
				+ cargaHoraria + ", instituicao=" + instituicao + ", anoConclusao=" + anoConclusao 
				+ ", observacao=" + observacao 
				+ ", arquivo=" + Arrays.toString(arquivo) 
				+ "]";
	}
}
