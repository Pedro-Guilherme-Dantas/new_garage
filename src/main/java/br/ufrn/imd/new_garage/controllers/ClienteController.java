package br.ufrn.imd.new_garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.new_garage.entities.Cliente;
import br.ufrn.imd.new_garage.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    @Autowired
    public ClienteRepository repository;

    @GetMapping("/list")
    public List<Cliente> findAll() {
        List<Cliente> result = repository.findAll();
        return result;
    }
    @GetMapping(value = "/{id}")
    public Cliente findById(@PathVariable Long id) {
        Cliente result = repository.findById(id).get();
        return result;
    }
    @PostMapping("/insert")
    public Cliente insert(@RequestBody Cliente cliente) {
        Cliente result = repository.save(cliente);
        return result;
    }   
}
