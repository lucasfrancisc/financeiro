package controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class CalculadoraController {

	private final Result result;
	private double resultado;
	
	public CalculadoraController(Result result) {
		this.result = result;		
	}
	
	@Get("/calculadora")
	public void calculadora(){
	
	}	
	
	@Post("/calculadora")
	public void calculadora(double valor1, double valor2, String op){
		
		if(op.equals("+")) {
			resultado = valor1 + valor2;
		}else if(op.equals("-")) {
			resultado = valor1 - valor2;
		} if(op.equals("*")) {
			resultado = valor1 * valor2;
		} if(op.equals("/")) {
			resultado = valor1 / valor2;
		}
		
		result.include("resultado","Resultado: "+resultado);
		resultado = 0;
		
	}	

}
