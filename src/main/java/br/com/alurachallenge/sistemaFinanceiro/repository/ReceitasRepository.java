package br.com.alurachallenge.sistemaFinanceiro.repository;

import java.util.List;
import java.util.Optional;
		
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alurachallenge.sistemaFinanceiro.model.Receitas;

@Repository
public interface ReceitasRepository extends JpaRepository<Receitas, Long> {

	public List<Receitas> findAll();

	public Optional<Receitas> findByDescricao(String descricao);

	public List<Receitas> findAllByDescricaoContainingIgnoreCase(String descricao);

}
