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

import br.ufrn.imd.new_garage.dto.ServicoDTO;
import br.ufrn.imd.new_garage.entities.Moto;
import br.ufrn.imd.new_garage.entities.Servico;
import br.ufrn.imd.new_garage.repositories.MotoRepository;
import br.ufrn.imd.new_garage.repositories.ServicoRepository;

@Controller
@RequestMapping(value = "/servico")
public class ServicoController {

    @Autowired
    public ServicoRepository repository;
    
    @Autowired
    public MotoRepository motoRepository;

    @GetMapping
    public String findAll(Model model) {
        List<Servico> result = repository.findAll();
        model.addAttribute("servicos", result);
        return "home";
    }
    
    @GetMapping("/novo")
    public String novoServico(ServicoDTO servicoDTO, Model model) {
    	List<Moto> motos = motoRepository.findAll();
    	model.addAttribute("motos", motos);
    	
    	return "servico/novo";
    }
    
    public String create() {
    	return "todo";
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
