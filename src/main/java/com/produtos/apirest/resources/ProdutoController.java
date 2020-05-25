package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produtos;
import com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produtos> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produtos listaProdutoUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
		
	}
	
	@PostMapping("/produto")
	public Produtos salvaProduto(@RequestBody Produtos produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	public void deletaProduto(@RequestBody Produtos produto) {
		produtoRepository.delete(produto);
	}

	@PutMapping("/produto")
	public Produtos atualizaProduto(@RequestBody Produtos produto) {
		return produtoRepository.save(produto);
	}
}
