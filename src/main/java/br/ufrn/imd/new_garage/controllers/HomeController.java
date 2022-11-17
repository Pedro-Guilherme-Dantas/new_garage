package br.ufrn.imd.new_garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufrn.imd.new_garage.entities.EnumStatusServico;
import br.ufrn.imd.new_garage.entities.Servico;
import br.ufrn.imd.new_garage.repositories.ServicoRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
    public ServicoRepository repository;
	
	@GetMapping
	public String homePage(Model model) {
		List<Servico> servicos = repository.findByStatusServico(EnumStatusServico.PENDENTE);
		servicos.addAll(repository.findByStatusServico(EnumStatusServico.EM_ANDAMENTO));
		
		model.addAttribute("servicos", servicos);
		return "home";
	}
}
