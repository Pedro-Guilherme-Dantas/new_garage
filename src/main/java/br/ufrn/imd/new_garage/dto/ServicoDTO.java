package br.ufrn.imd.new_garage.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

import java.util.Calendar;

import br.ufrn.imd.new_garage.entities.Cliente;
import br.ufrn.imd.new_garage.entities.EnumStatusServico;
import br.ufrn.imd.new_garage.entities.EnumTipoServico;
import br.ufrn.imd.new_garage.entities.Moto;
import br.ufrn.imd.new_garage.entities.Servico;

public class ServicoDTO {
	@Min(value=0)
	private double valor;
    
	@NotBlank
	@Size(min=6, max=255)
	private String descricao;
    
    @NotNull
    private EnumTipoServico tipoServico;
    
    @NotNull
    private long motoId;
    private Moto moto = new Moto();
    
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
	public EnumTipoServico getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(EnumTipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}
	public long getMotoId() {
		return motoId;
	}
	public void setMotoId(long motoId) {
		this.motoId = motoId;
	}
	public Moto getMoto() {
		return moto;
	}
	public void setMoto(Moto moto) {
		this.moto = moto;
	}
	public void setMotoById(long id) {
		this.moto.setId(id);
	}
	
	public Servico toServico() {
		moto.setId(motoId);
		
		Servico servico = new Servico();
		servico.setValor(valor);
		servico.setData_inicio(Calendar.getInstance());
		servico.setDescricao(descricao);
		servico.setTipoServico(tipoServico);
		servico.setStatusServico(EnumStatusServico.PENDENTE);
		servico.setMoto(moto);
		
		return servico;
	}
}
