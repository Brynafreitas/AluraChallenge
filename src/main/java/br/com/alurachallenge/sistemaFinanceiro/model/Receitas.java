package br.com.alurachallenge.sistemaFinanceiro.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "receitas")
public class Receitas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // parametro que transforma em chave primaria
	private long id;

	@NotNull
	private double valor;

	@NotNull
	private LocalDateTime data = LocalDateTime.now();

	@NotNull
	private String descricao;

	@NotNull
	private int ContaId;

	public long getId() {
		return id;
	}

	public double getValor() {
		return valor;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getContaId() {
		return ContaId;
	}

	public void setContaId(int contaId) {
		ContaId = contaId;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public LocalDateTime getData() {
		return data;
	}

}
