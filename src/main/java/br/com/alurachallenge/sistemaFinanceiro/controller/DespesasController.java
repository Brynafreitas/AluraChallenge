package br.com.alurachallenge.sistemaFinanceiro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.alurachallenge.sistemaFinanceiro.model.Despesas;
import br.com.alurachallenge.sistemaFinanceiro.repository.DespesasRepository;

@RestController
@RequestMapping("/despesas")
@CrossOrigin("*")
public class DespesasController {

	@Autowired
	private DespesasRepository despesasRepository;

	@GetMapping
	public ResponseEntity<List<Despesas>> GetAll() {
		return ResponseEntity.ok(despesasRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Despesas> GetById(@PathVariable long id) {
		return despesasRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Despesas>> GetByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(despesasRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@PostMapping
	public ResponseEntity<Despesas> post(@RequestBody Despesas despesas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(despesasRepository.save(despesas));

	}

	@PutMapping("/{id}")
	public ResponseEntity<Despesas> update(@PathVariable("id") long id, @RequestBody Despesas despesas) {
		return despesasRepository.findById(id).map(record -> {
			record.setContaId(despesas.getContaId());
			record.setData(despesas.getData());
			record.setDescricao(despesas.getDescricao());
			record.setValor(despesas.getValor());
			Despesas updated = despesasRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		Optional<Despesas> despesas = despesasRepository.findById(id);
		if(despesas.isPresent()) {
			despesasRepository.deleteById(id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Despesa não encontrada", null);
		}
		
	}
}