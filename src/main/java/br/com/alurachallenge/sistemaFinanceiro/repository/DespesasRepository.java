package br.com.alurachallenge.sistemaFinanceiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alurachallenge.sistemaFinanceiro.model.Despesas;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, Long> {

	public List<Despesas> findAll();
	
	public List<Despesas> findAllByDescricaoContainingIgnoreCase(String descricao);

}
