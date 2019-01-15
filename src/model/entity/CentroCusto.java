package model.entity;

import javax.persistence.Entity;

@Entity
public class CentroCusto extends Base{
	
  private String descricao;
  
  private String numero;
  
  public String getDescricao() {
	return descricao;
  }

  public void setDescricao(String descricao) {
	this.descricao = descricao;
  }
  
  public String getNumero() {
	return numero;
  }

  public void setNumero(String numero) {
	this.numero = numero;
  }
}
