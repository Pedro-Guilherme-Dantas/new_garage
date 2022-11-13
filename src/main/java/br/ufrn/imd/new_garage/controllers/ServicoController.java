package br.ufrn.imd.new_garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.new_garage.entities.Servico;
import br.ufrn.imd.new_garage.repositories.ServicoRepository;

@RestController
@RequestMapping(value = "/servico")
public class ServicoController {

    @Autowired
    public ServicoRepository repository;

    @GetMapping("/list")
    public List<Servico> findAll() {
        List<Servico> result = repository.findAll();
        return result;
    }
    @GetMapping(value = "/{id}")
    public Servico findById(@PathVariable Long id) {
        Servico result = repository.findById(id).get();
        return result;
    }
    @PostMapping("/insert")
    public Servico insert(@RequestBody Servico servico) {
        Servico result = repository.save(servico);
        return result;
    }
}
