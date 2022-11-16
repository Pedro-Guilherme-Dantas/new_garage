package br.ufrn.imd.new_garage.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

import java.util.Calendar;
import java.util.Optional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import br.ufrn.imd.new_garage.entities.Cliente;
import br.ufrn.imd.new_garage.entities.EnumStatusServico;
import br.ufrn.imd.new_garage.entities.EnumTipoServico;
import br.ufrn.imd.new_garage.entities.Moto;
import br.ufrn.imd.new_garage.entities.Servico;
import br.ufrn.imd.new_garage.repositories.ClienteRepository;
import br.ufrn.imd.new_garage.repositories.MotoRepository;

public class ServicoDTO {
	private long id;
	
	@NotBlank
	@Min(value=0)
	private double valor;
    
	@NotBlank
	@Size(min=6)
	private String descricao;
    private Calendar data_inicio;
    private Calendar data_fim;
    private EnumStatusServico statusServico;
    
    @NotNull
    private EnumTipoServico tipoServico;
    
    @NotBlank
    private long clienteId;
    
    @NotBlank
    private long motoId;
    
    @Autowired
    public MotoRepository motoRepository;
    
    @Autowired
    public ClienteRepository clienteRepository;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Calendar data_inicio) {
		this.data_inicio = data_inicio;
	}
	public Calendar getData_fim() {
		return data_fim;
	}
	public void setData_fim(Calendar data_fim) {
		this.data_fim = data_fim;
	}
	public EnumStatusServico getStatusServico() {
		return statusServico;
	}
	public void setStatusServico(EnumStatusServico statusServico) {
		this.statusServico = statusServico;
	}
	public EnumTipoServico getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(EnumTipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}
	public long getClienteId() {
		return clienteId;
	}
	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}
	public long getMotoId() {
		return motoId;
	}
	public void setMotoId(long motoId) {
		this.motoId = motoId;
	}
	
	public Servico toServico() {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		Optional<Moto> moto = motoRepository.findById(motoId);

		Servico servico = new Servico();
		servico.setId(id);
		servico.setValor(valor);
		servico.setData_inicio(data_inicio);
		servico.setDescricao(descricao);
		servico.setTipoServico(tipoServico);
		servico.setStatusServico(EnumStatusServico.PENDENTE);
		servico.setCliente(cliente.orElse(null));
		servico.setMoto(moto.orElse(null));
		
		return servico;
	}
}
