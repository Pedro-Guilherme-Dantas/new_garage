package br.ufrn.imd.new_garage.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.new_garage.entities.Marca;
import br.ufrn.imd.new_garage.repositories.MarcaRepository;

@RestController
@RequestMapping(value = "/marca")
public class MarcaController {
    @Autowired
    public MarcaRepository repository;

    @GetMapping("/list")
    public List<Marca> findAll() {
        List<Marca> result = repository.findAll();
        return result;
    }
    @GetMapping(value = "/{id}")
    public Marca findById(@PathVariable Long id) {
        Marca result = repository.findById(id).get();
        return result;
    }
    @PostMapping("/insert")
    public Marca insert(@RequestBody Marca marca) {
        Marca result = repository.save(marca);
        return result;
    }   
}
