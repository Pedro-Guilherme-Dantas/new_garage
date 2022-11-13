package br.ufrn.imd.new_garage.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.new_garage.entities.ProdutoServico;
import br.ufrn.imd.new_garage.repositories.ProdutoServicoRepository;

@RestController
@RequestMapping(value = "/produto_servico")
public class ProdutoServicoController {
    @Autowired
    public ProdutoServicoRepository repository;

    @GetMapping("/list")
    public List<ProdutoServico> findAll() {
        List<ProdutoServico> result = repository.findAll();
        return result;
    }
    @GetMapping(value = "/{id}")
    public ProdutoServico findById(@PathVariable Long id) {
        ProdutoServico result = repository.findById(id).get();
        return result;
    }
    @PostMapping("/insert")
    public ProdutoServico insert(@RequestBody ProdutoServico produto_servico) {
        ProdutoServico result = repository.save(produto_servico);
        return result;
    } 
}
