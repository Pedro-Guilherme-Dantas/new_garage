package br.ufrn.imd.new_garage.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.new_garage.entities.Produto;
import br.ufrn.imd.new_garage.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    @Autowired
    public ProdutoRepository repository;

    @GetMapping("/list")
    public List<Produto> findAll() {
        List<Produto> result = repository.findAll();
        return result;
    }
    @GetMapping(value = "/{id}")
    public Produto findById(@PathVariable Long id) {
        Produto result = repository.findById(id).get();
        return result;
    }
    @PostMapping("/insert")
    public Produto insert(@RequestBody Produto produto) {
        Produto result = repository.save(produto);
        return result;
    } 
}
