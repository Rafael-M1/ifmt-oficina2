package br.com.ifmt.edu.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long alunoId;
	@Column(length = 20)
	private String cpf;
	@Column(length = 100)
	private String nome;
	private Integer matricula;
	@Column(length = 200)
	private String email;
	@Column(length = 20)
	private String telefone;

	public Aluno() {
	}

	public Aluno(Long alunoId, String cpf, String nome, Integer matricula, String email, String telefone) {
		this.alunoId = alunoId;
		this.cpf = cpf;
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.telefone = telefone;
	}

	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Aluno [alunoId=" + alunoId + ", cpf=" + cpf + ", nome=" + nome + ", matricula=" + matricula + ", email="
				+ email + ", telefone=" + telefone + "]";
	}

}
