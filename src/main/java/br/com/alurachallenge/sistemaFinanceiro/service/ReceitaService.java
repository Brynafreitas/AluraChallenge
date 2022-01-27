package br.com.alurachallenge.sistemaFinanceiro.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.alurachallenge.sistemaFinanceiro.model.Receitas;
import br.com.alurachallenge.sistemaFinanceiro.repository.ReceitasRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitasRepository receitasRepository;

	public boolean checarDuplicidade(String descricao) {
		Optional<Receitas> receita = receitasRepository.findByDescricao(descricao);

		if (receita.isPresent()) {
			LocalDateTime dataAgora = LocalDateTime.now();
			dataAgora.getMonth();
			receita.get().getData().getMonth();
			if (dataAgora.getMonth().equals(receita.get().getData().getMonth())) {
				return false;
			} else {
				return true;
			}
		}

		return true;
	}

}
