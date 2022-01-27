package br.com.alurachallenge.sistemaFinanceiro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="conta_corrente")
public class ContaCorrente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private float saldo;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String senha;


	public long getId() {
		return id;
	}


	public float getSaldo() {
		return saldo;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}


	public String getNome() {
		return nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
