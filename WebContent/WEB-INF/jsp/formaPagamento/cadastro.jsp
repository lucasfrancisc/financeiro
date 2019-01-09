<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
 		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap.min.css" /> 
 		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap-theme.min.css" />	 
		<script src="/financeiro/bootstrap/js/bootstrap.min.js"></script>	
		<title>Cadastro de Forma de Pagamento</title>
	</head>
	<body>
		<form action="grava" method="post"> <!-- ${pageContext.request.contextPath}  -->
			<nav class="navbar navbar-default">
				<div class="container-fluid">					
					<div class="page-header">
						<h2>Cadastro de Forma de Pagamento <span class="glyphicon glyphicon-credit-card"> </span> </h2>			  										
					</div> <hr>
					<ul class="nav nav-pills">
					  <li role="presentation" class="active">
					  	<a href="/financeiro/menu">
						  	Home 
						  	<span class="glyphicon glyphicon-home">
						  	</span>
					  	</a>
					  </li>
					<li role="presentation"><a
						href="/financeiro/formaPagamento">Forma de pagamento 
						<span class="glyphicon glyphicon-credit-card"></span>
						</a>
					</li>
					<li role="presentation"><a href="/financeiro/conta">Conta
							<span class="glyphicon glyphicon-usd"></span>
					</a></li>
					<li role="presentation"><a href="/financeiro/calculadora">Calculadora
							<span class="glyphicon glyphicon-plus"></span>
					</a></li>
				</ul> <br>						
		
					<div class="panel-body">
						<div class="row">
							<c:if test="${entity.operacao != 'CREATE'}">	
								<div class="col-lg-3">						
									<label>Código:</label> <br>
									<input type="text" maxlength="6" class="form-control" maxlength="50" name="entity.id" value="${entity.id}"> <br>	
								</div>
							</c:if>	
						</div>							
						
											
						<div class="row">
							<div class="col-lg-6">						
								<label>Descrição:</label> <br>
								<input type="text" maxlength="50" class="form-control" maxlength="50" name="entity.descricao"> <br>	
							</div>
						</div>					
	        
						<div class="row">				        
							<div class="col-lg-3">						        
								<label id="label-tipo" class="control-label">Tipo:</label> <br>	        
								<select name="entity.tipo" class="form-control">
								  <option value="dinheiro">Dinheiro</option>
								  <option value="cartaoC">Cartão Crédito</option>
								  <option value="cartaoD">Cartão Débito</option>
								</select> <br>
							</div>
	        			</div>				
			  		 	<p> ${mensagem} </p>
					</div>				  		 											
					
					<div class="panel panel-footer">
				  		<button type="submit" class="btn btn-success">Salvar</button>		
				  		<button type="reset" class="btn btn-danger">Limpar</button>
				  		<button type="button" onclick="location.href='/financeiro/formaPagamento/lista'" class="btn btn-default">Listagem</button>
					</div>																			  		 
				</div>  		 
			</nav>
		</form>		 		 					
	</body>	
</html>