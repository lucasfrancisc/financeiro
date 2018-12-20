package model.entity;

import javax.persistence.Entity;

@Entity
public class FormaPagamento extends Base{
	private String descricao;
	private String tipo;	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
