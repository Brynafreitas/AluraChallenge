package br.com.alurachallenge.sistemaFinanceiro.controller;


import java.util.List;
import java.util.Optional;

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
import br.com.alurachallenge.sistemaFinanceiro.model.Receitas;
import br.com.alurachallenge.sistemaFinanceiro.repository.ReceitasRepository;
import br.com.alurachallenge.sistemaFinanceiro.service.ReceitaService;

@RestController
@RequestMapping("/receitas")
@CrossOrigin("*")
public class ReceitasController {

	
	private ReceitasRepository receitasRepository;
	private ReceitaService receitaService;
	
	ReceitasController(ReceitasRepository receitasRepository, ReceitaService receitaService){
		this.receitasRepository =  receitasRepository;
		this.receitaService = receitaService;
	}
	
	@GetMapping
	public ResponseEntity<List<Receitas>> GetAll() {
		return ResponseEntity.ok(receitasRepository.findAll());
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Receitas> GetById(@PathVariable long id) {
		return receitasRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Receitas>> GetByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(receitasRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@PostMapping
	public ResponseEntity<Receitas> post(@RequestBody Receitas receitas) {
		if(receitaService.checarDuplicidade(String descricao)
		return ResponseEntity.status(HttpStatus.CREATED).body(receitasRepository.save(receitas));

	}

	@PutMapping("receitas/{id}")
//	public ResponseEntity<Receitas> update(@PathVariable("id") long id, @RequestBody Receitas receitas) {
//		return receitasRepository.findById(id).map(record -> {
//			record.setContaId(receitas.getContaId());
//			record.setData(receitas.getData());
//			record.setDescricao(receitas.getDescricao());
//			record.setValor(receitas.getValor());
//			Receitas updated = receitasRepository.save(record);
//			return ResponseEntity.ok().body(updated);
//		}).orElse(ResponseEntity.notFound().build());
//	} tentei resumir o put por id
	public ResponseEntity<Receitas> update(@PathVariable Long id, @RequestBody Receitas receita) {
        return ResponseEntity.ok().body(receitasRepository.save(receita));
    }
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		Optional<Receitas> receitas = receitasRepository.findById(id);
		if(receitas.isPresent()) {
			receitasRepository.deleteById(id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Despesa não encontrada", null);
		}
		
	}
	
	
}
