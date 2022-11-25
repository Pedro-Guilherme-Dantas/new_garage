package br.ufrn.imd.new_garage.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.ufrn.imd.new_garage.entities.Cliente;

public class ClienteDTO {
    private Long id;

    @NotBlank
    @Pattern(regexp = "(^\\d{3}\\.\\d{3}.\\d{3}-\\d{2}$)|(^$)")
    private String cpf;
    
    @NotBlank
    private String nome;
    @NotBlank
    
    @Pattern(regexp = "(^\\(\\w{2}\\)\\w{4,5}-\\w{4}$)|(^$)")
    private String telefone;
    
    @Pattern(regexp = "(^[a-z0-9_\\.-]+@[a-z0-9-]+\\.[a-z]{1,4}$)|(\\s*)")
    private String email;
    
    private String estado;
    
    @NotBlank
    private String bairro;
    
    private String cidade;
    
    @NotBlank
    private String rua;
    
    @NotBlank
    private String numero;
    @Pattern(regexp = "(^\\d{2}\\.\\d{3}-\\d{3}$)|(^$)")
    private String cep;
    
    private String complemento;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone.strip().replace(" ", "");
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cliente toCliente(){
        Cliente cliente = new Cliente();

        cliente.setId(this.id);
        cliente.setCpf(this.cpf);
        cliente.setNome(this.nome);
        cliente.setTelefone(this.telefone);
        cliente.setEmail(this.email);
        cliente.setEstado(this.estado);
        cliente.setBairro(this.bairro);
        cliente.setCidade(this.cidade);
        cliente.setRua(this.rua);
        cliente.setNumero(this.numero);
        cliente.setCep(this.cep);
        cliente.setComplemento(this.complemento);

        return cliente;
    }

    public static ClienteDTO parseClienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.id = cliente.getId();
        clienteDTO.cpf = cliente.getCpf();
        clienteDTO.nome = cliente.getNome();
        clienteDTO.telefone = cliente.getTelefone();
        clienteDTO.email = cliente.getEmail();
        clienteDTO.estado = cliente.getEstado();
        clienteDTO.bairro = cliente.getBairro();
        clienteDTO.cidade = cliente.getCidade();
        clienteDTO.rua = cliente.getRua();
        clienteDTO.numero = cliente.getNumero();
        clienteDTO.cep = cliente.getCep();
        clienteDTO.complemento = cliente.getComplemento();

        return clienteDTO;
    }
}