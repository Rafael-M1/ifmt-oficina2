package br.com.ifmt.edu.api.model.dto;

import java.util.Arrays;

public class AtividadeComplementarDTO {
	private Long atividadeComplementarId;
	private Long alunoId;
	private Long tipoAtividadeId;
	private String descricaoAtividade;
	private Integer cargaHoraria;
	private String instituicao;
	private Integer anoConclusao;
	private byte[] arquivo;
	private String observacao;

	public AtividadeComplementarDTO() {
	}

	public AtividadeComplementarDTO(Long atividadeComplementarId, Long alunoId, Long tipoAtividadeId,
			String descricaoAtividade, Integer cargaHoraria, String instituicao, Integer anoConclusao, byte[] arquivo,
			String observacao) {
		this.atividadeComplementarId = atividadeComplementarId;
		this.alunoId = alunoId;
		this.tipoAtividadeId = tipoAtividadeId;
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

	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public Long getTipoAtividadeId() {
		return tipoAtividadeId;
	}

	public void setTipoAtividadeId(Long tipoAtividadeId) {
		this.tipoAtividadeId = tipoAtividadeId;
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
		return "AtividadeComplementarDTO [atividadeComplementarId=" + atividadeComplementarId + ", alunoId=" + alunoId
				+ ", tipoAtividadeId=" + tipoAtividadeId + ", descricaoAtividade=" + descricaoAtividade
				+ ", cargaHoraria=" + cargaHoraria + ", instituicao=" + instituicao + ", anoConclusao=" + anoConclusao
				+ ", arquivo=" + Arrays.toString(arquivo) + ", observacao=" + observacao + "]";
	}
}
