package br.ufrn.imd.new_garage.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.new_garage.entities.Venda;
import br.ufrn.imd.new_garage.repositories.VendaRepository;

@RestController
@RequestMapping(value = "/venda")
public class VendaController {
    @Autowired
    public VendaRepository repository;

    @GetMapping("/list")
    public List<Venda> findAll() {
        List<Venda> result = repository.findAll();
        return result;
    }
    @GetMapping(value = "/{id}")
    public Venda findById(@PathVariable Long id) {
        Venda result = repository.findById(id).get();
        return result;
    }
    @PostMapping("/insert")
    public Venda insert(@RequestBody Venda venda) {
        Venda result = repository.save(venda);
        return result;
    } 
}
