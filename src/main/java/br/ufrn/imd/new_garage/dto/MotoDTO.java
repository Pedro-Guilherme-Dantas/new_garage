package br.ufrn.imd.new_garage.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.ufrn.imd.new_garage.entities.Moto;

public class MotoDTO {
    private long id;

    @NotNull
    private long clienteId;
    
    @NotBlank
    @Pattern(regexp = "(^\\w{3}\\-\\d{4}$)|(^$)", message = "Placa inválida, ex.: AAA-5555")
    private String placa;
    @NotBlank
    private String modelo;
    @NotBlank
    private String marca;
    @NotBlank
    @Pattern(regexp = "(^[1-2]\\d{3}$)|(^$)", message = "Ano inválido, deve ser entre 1000 e 2999")
    private String ano;
    @NotBlank
    @Pattern(regexp = "(^\\d*$)", message = "Quimlometragem inválida")
    private String quilometragem;
    @NotBlank
    @Pattern(regexp = "(^\\d*$)", message = "Cilindagem inválida")
    private String cilindrada;
    @Size(max = 255, message = "Urls só podem ter até 255 characteres")
    private String urlImg;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getAno() {
        return ano;
    }
    public int getAnoInt() {
        return Integer.parseInt(ano);
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getQuilometragem() {
        return quilometragem;
    }
    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem.replace("k", "").replace("m", "").replace(".", "").strip();
    }
    public String getCilindrada() {
        return cilindrada;
    }
    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada.replace("c", "").replace(".", "").strip();
    }
    public String getUrlImg() {
        return urlImg;
    }
    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
    public long getClienteId() {
        return clienteId;
    }
    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public Moto toMoto() {
        Moto moto = new Moto();
        
        moto.setId(id);
        moto.setPlaca(placa);
        moto.setModelo(modelo);
        moto.setAno(this.getAnoInt());
        moto.setQuilometragem(Integer.parseInt(quilometragem));
        moto.setCilindrada(Double.parseDouble(cilindrada));
        moto.setUrlImg(urlImg);
        moto.setProprietarioById(clienteId);

        return moto;
    }
}
