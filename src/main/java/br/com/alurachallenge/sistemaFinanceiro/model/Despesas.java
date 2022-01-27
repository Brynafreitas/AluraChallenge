package br.com.alurachallenge.sistemaFinanceiro.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "despesas")
public class Despesas{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String descricao;

	@NotNull
	private double valor;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@NotNull
	private int contaId;

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

	public Date getData() {
		return data;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getContaId() {
		return contaId;
	}

	public void setContaId(int contaId) {
		this.contaId = contaId;
	}

}
