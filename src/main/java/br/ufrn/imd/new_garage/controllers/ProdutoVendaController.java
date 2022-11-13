package br.ufrn.imd.new_garage.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.new_garage.entities.ProdutoVenda;
import br.ufrn.imd.new_garage.repositories.ProdutoVendaRepository;

@RestController
@RequestMapping(value = "/produto_venda")
public class ProdutoVendaController {
    @Autowired
    public ProdutoVendaRepository repository;

    @GetMapping("/list")
    public List<ProdutoVenda> findAll() {
        List<ProdutoVenda> result = repository.findAll();
        return result;
    }
    @GetMapping(value = "/{id}")
    public ProdutoVenda findById(@PathVariable Long id) {
        ProdutoVenda result = repository.findById(id).get();
        return result;
    }
    @PostMapping("/insert")
    public ProdutoVenda insert(@RequestBody ProdutoVenda produto_venda) {
        ProdutoVenda result = repository.save(produto_venda);
        return result;
    } 
}
