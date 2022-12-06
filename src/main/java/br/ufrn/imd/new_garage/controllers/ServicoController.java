package br.ufrn.imd.new_garage.controllers;

import java.util.Calendar;
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
import br.ufrn.imd.new_garage.entities.Cliente;
import br.ufrn.imd.new_garage.entities.EnumStatusServico;
import br.ufrn.imd.new_garage.entities.Moto;
import br.ufrn.imd.new_garage.entities.Servico;
import br.ufrn.imd.new_garage.repositories.ClienteRepository;
import br.ufrn.imd.new_garage.repositories.MotoRepository;
import br.ufrn.imd.new_garage.repositories.ServicoRepository;

@Controller
@RequestMapping(value = "/servico")
public class ServicoController {

    @Autowired
    public ServicoRepository repository;
    
    @Autowired
    public MotoRepository motoRepository;

    @Autowired
    public ClienteRepository clienteRepository;

    @GetMapping
    public String findAll(Model model) {
        List<Servico> result = repository.findAll();
        model.addAttribute("servicos", result);
        return "home";
    }

    @GetMapping(value = "/finalizados")
    public String findFinish(Model model) {
        List<Servico> result = repository.findByStatusServico(EnumStatusServico.FINALIZADO);
        model.addAttribute("servicos", result);
        return "home";
    }

    @GetMapping(value = "/em_andamento")
    public String findInProgress(Model model) {
        List<Servico> result = repository.findByStatusServico(EnumStatusServico.EM_ANDAMENTO);
        model.addAttribute("servicos", result);
        return "home";
    }

    @GetMapping(value = "/pendentes")
    public String findPending(Model model) {
        List<Servico> result = repository.findByStatusServico(EnumStatusServico.PENDENTE);
        model.addAttribute("servicos", result);
        return "home";
    }

    @GetMapping(value = "/cancelados")
    public String findCanceled(Model model) {
        List<Servico> result = repository.findByStatusServico(EnumStatusServico.CANCELADO);
        model.addAttribute("servicos", result);
        return "home";
    }

    @GetMapping("/novo")
    public String novoCliente(Model model) {
    	List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
    	
    	return "servico/adicionar/cliente";
    }

    @GetMapping("/cliente/{clienteId}/moto")
    public String novoMoto(@PathVariable Long clienteId, Model model) {
    	List<Moto> motos = motoRepository.findAllByClienteId(clienteId);

        model.addAttribute("motos", motos);
    	
    	return "servico/adicionar/moto";
    }
    
    @GetMapping("/moto/{motoId}/novo")
    public String novo(@PathVariable Long motoId, ServicoDTO servicoDTO) {
        servicoDTO.setMotoId(motoId);

    	return "servico/novo";
    }

    @PostMapping("/moto/{motoId}/novo")
    public String create(@Valid ServicoDTO servicoDTO, BindingResult result, Model model) {
    	// Validando preenchimento do formulário
        if(result.hasErrors()) {
        	setMotos(model);
        	
			return "servico/novo";
		}
        // adicionando id da moto
		Servico servico = servicoDTO.toServico();
		repository.save(servico);

        System.out.println("valor: " + servicoDTO.getValor());

		return "redirect:/servico";
    }

    
    /**
    @GetMapping("/novo")
    public String novo(ServicoDTO servicoDTO, Model model) {
    	setMotos(model);
    	
    	return "servico/novo";
    }
    */
    
    @GetMapping(value = "/{id}")
    public Servico findById(@PathVariable Long id) {
        Servico result = repository.findById(id).get();
        return result;
    }
    
    @GetMapping("/{id}/pendente")
    public String setServicoPendente(@PathVariable Long id) {
        Servico servico = repository.findById(id).orElse(null);
        if(servico != null) {
    		servico.setStatusServico(EnumStatusServico.PENDENTE);
    		servico.setData_fim(null);
    		
        	repository.save(servico);
        }
        return "redirect:/servico/";
    }
    
    @GetMapping("/{id}/em-andamento")
    public String setServicoEmAndamento(@PathVariable Long id) {
        Servico servico = repository.findById(id).orElse(null);
        if(servico != null) {
    		servico.setStatusServico(EnumStatusServico.EM_ANDAMENTO);
    		servico.setData_fim(null);
    		
        	repository.save(servico);
        }
        return "redirect:/servico/";
    }
    
    @GetMapping("/{id}/finalizado")
    public String setServicoFinalizado(@PathVariable Long id) {
    	Calendar calendar = Calendar.getInstance();
        Servico servico = repository.findById(id).orElse(null);
        
        if(servico != null) {
    		servico.setStatusServico(EnumStatusServico.FINALIZADO);
    		servico.setData_fim(calendar);
        	
    		repository.save(servico);
        }
        return "redirect:/servico/";
    }
    
    @GetMapping("/{id}/cancelado")
    public String setServicoCancelado(@PathVariable Long id) {
    	Calendar calendar = Calendar.getInstance();
        Servico servico = repository.findById(id).orElse(null);
        if(servico != null) {
    		servico.setStatusServico(EnumStatusServico.CANCELADO);
    		servico.setData_fim(calendar);
    		
        	repository.save(servico);
        }
        return "redirect:/servico/";
    }
    
    private void setMotos(Model model) {
    	List<Moto> motos = motoRepository.findAll();
    	model.addAttribute("motos", motos);
    }
}
