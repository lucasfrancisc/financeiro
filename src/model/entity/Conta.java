package model.entity;

import javax.persistence.Entity;

@Entity
public class Conta extends Base{
	
	private String tipo;
	private String descricao;
	private Double saldo;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String pdescricao) {
		this.descricao = pdescricao;
	}	

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double psaldo) {
		this.saldo = psaldo;
	}	
	
}