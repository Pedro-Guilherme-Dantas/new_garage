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
import org.springframework.web.bind.annotation.RequestMapping;

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
    	setMotos(model);
    	
    	return "servico/novo";
    }
    
    @PostMapping("/novo")
    public String insert(@Valid ServicoDTO servicoDTO, BindingResult result, Model model) {
    	// Validando preenchimento do formulário
        if(result.hasErrors()) {
        	setMotos(model);
        	
			return "servico/novo";
		}
		// salvando novo servico
		Servico servico = servicoDTO.toServico();
		System.out.println(servico);
		repository.save(servico);

		return "redirect:/servico/novo";
    }
    
    @GetMapping(value = "/{id}")
    public Servico findById(@PathVariable Long id) {
        Servico result = repository.findById(id).get();
        return result;
    }
    
    private void setMotos(Model model) {
    	List<Moto> motos = motoRepository.findAll();
    	model.addAttribute("motos", motos);
    }
}
