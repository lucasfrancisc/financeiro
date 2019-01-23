package model.entity;

import javax.persistence.Entity;

@Entity
public class Pessoa extends Base {
	
	private String nome;
	private String documento;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

}
