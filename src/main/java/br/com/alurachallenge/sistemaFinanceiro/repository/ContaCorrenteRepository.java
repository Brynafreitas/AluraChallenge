package br.com.alurachallenge.sistemaFinanceiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alurachallenge.sistemaFinanceiro.model.ContaCorrente;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {
	
	public List<ContaCorrente> findAllByNomeContainingIgnoreCase(String nome);
}
