package model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import util.enumeration.Operacao;

@MappedSuperclass
public class Base {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Transient
	private Operacao operacao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Operacao getOperacao() {
		return operacao;
	}
//static
	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}
}
