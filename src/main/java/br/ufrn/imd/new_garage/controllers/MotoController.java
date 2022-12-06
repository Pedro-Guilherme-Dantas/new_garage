package br.ufrn.imd.new_garage.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.new_garage.dto.MotoDTO;
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

    @GetMapping("{clienteId}/novo")
    public String novo(@PathVariable Long clienteId, MotoDTO motoDTO, Model model) {
        motoDTO.setClienteId(clienteId);
        model.addAttribute("clienteId", clienteId);

        return "moto/novo";
    }

    @PostMapping("{clienteId}/novo")
    public String create(@PathVariable Long clienteId, @Valid MotoDTO motoDTO, BindingResult result) {
        if(result.hasErrors()) {    	
			return "moto/novo";
		}
        // salvando moto
        Moto moto = motoDTO.toMoto();
        moto = repository.save(moto);

        return "redirect:/servico/moto/" + moto.getId() + "/novo";
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
