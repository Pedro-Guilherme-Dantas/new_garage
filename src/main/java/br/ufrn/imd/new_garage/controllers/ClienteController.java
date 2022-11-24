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

import br.ufrn.imd.new_garage.dto.ClienteDTO;
import br.ufrn.imd.new_garage.entities.Cliente;
import br.ufrn.imd.new_garage.repositories.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    public ClienteRepository clienteRepository;

    @GetMapping
    public String index(Model model) {
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);

        return "cliente/clientes";
    }

    @GetMapping("/novo")
    public String novo(ClienteDTO clienteDTO) {
        return "cliente/novo";
    }

    @GetMapping("/list")
    public List<Cliente> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }
    @GetMapping(value = "/{id}")
    public Cliente findById(@PathVariable Long id) {
        Cliente clientes = clienteRepository.findById(id).get();
        return clientes;
    }
    @PostMapping("/insert")
    public Cliente insert(@RequestBody Cliente cliente) {
        Cliente result = clienteRepository.save(cliente);
        return result;
    }   
}
