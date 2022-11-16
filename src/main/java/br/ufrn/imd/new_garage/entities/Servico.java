package br.ufrn.imd.new_garage.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Calendar;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_servicos")
public class Servico {
	static private HashMap<EnumStatusServico, String> tradutorStatusServico = new HashMap<EnumStatusServico, String>();
	{
		tradutorStatusServico.put(EnumStatusServico.FINALIZADO, "Finalizado");
		tradutorStatusServico.put(EnumStatusServico.EM_ANDAMENTO, "Em andamento");
		tradutorStatusServico.put(EnumStatusServico.PENDENTE, "Pendente");
		tradutorStatusServico.put(EnumStatusServico.CANCELADO, "Cancelado");
	}
	
	static private HashMap<EnumTipoServico, String> tradutorTipoServico = new HashMap<EnumTipoServico, String>();
	{
		tradutorTipoServico.put(EnumTipoServico.MANUNTENCAO, "Manuntenção");
		tradutorTipoServico.put(EnumTipoServico.REVISAO, "Revisão");
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;
    private String descricao;
    private Calendar data_inicio;
    private Calendar data_fim;
    
    @Enumerated(EnumType.STRING)
    private EnumStatusServico statusServico;
    
    @Enumerated(EnumType.STRING)
    private EnumTipoServico tipoServico;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "moto_id")
    private Moto moto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

	public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
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
	
	public String getStatusServicoNome() {
		return tradutorStatusServico.get(this.statusServico);
	}
	
	public boolean ehEmAndamento() {
		return this.statusServico == EnumStatusServico.EM_ANDAMENTO;
	}
	
	public boolean ehPendente() {
		return this.statusServico == EnumStatusServico.PENDENTE;
	}
	
	public boolean ehFinalizado() {
		return this.statusServico == EnumStatusServico.FINALIZADO;
	}
	
	public boolean ehCancelado() {
		return this.statusServico == EnumStatusServico.CANCELADO;
	}

	public EnumTipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(EnumTipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}
	
	public String getTipoServicoNome() {
		return tradutorTipoServico.get(this.tipoServico);
	}
}
