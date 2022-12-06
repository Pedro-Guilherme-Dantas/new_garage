package br.ufrn.imd.new_garage.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.new_garage.entities.Moto;
import br.ufrn.imd.new_garage.repositories.MotoRepository;

@Controller
@RequestMapping(value = "/moto")
public class MotoController {
    @Autowired
    public MotoRepository repository;

    @GetMapping()
    public String index(Model model) {
        List<Moto> motos = repository.findAll();
        model.addAttribute("motos", motos);
        
        return "moto/motos";
    }
    @GetMapping(value = "/{id}")
    public Moto findById(@PathVariable Long id) {
        Moto result = repository.findById(id).get();
        return result;
    }
    @PostMapping("/insert")
    public Moto insert(@RequestBody Moto moto) {
        Moto result = repository.save(moto);
        return result;
    }
}
