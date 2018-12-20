$(document).ready(function (){
	
	function valida(){
		var retorno = [];
		
		var nome = $('#input-nome').val();
		if (nome == ''){					
			retorno.push('nome');
		}
		
		var documento = $('#input-documento').val();
		if (documento == ''){
			retorno.push('documento');
		}
		
		return retorno;
	}	
	
	$('#button-salvar').click(function (retorno){
		var validacao = valida(); 
		if (validacao.length > 0){
			alert('Os seguintes campos estão vazios: ' + validacao);
			retorno.preventDefault();
		}
	});
});