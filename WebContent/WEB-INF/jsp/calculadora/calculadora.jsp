<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
 		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap.min.css" /> 
 		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap-theme.min.css" />	 
		<script src="/financeiro/bootstrap/js/bootstrap.min.js"></script>	
		<title>Meu Financeiro</title>
	</head>
	<body>
		<form action="/financeiro/calculadora" method="post"> <!-- ${pageContext.request.contextPath}  -->
			<nav class="navbar navbar-default">
				<div class="container-fluid">					
					<div class="page-header">
						<h2>Calculadora <span class="glyphicon glyphicon-plus"> </span> </h2>			  										
					</div> <hr>		
					<ul class="nav nav-pills">
					  <li role="presentation" class="active"><a href="/financeiro/menu">Home <span class="glyphicon glyphicon-home" </span></a></li>
					  <li role="presentation"><a href="/financeiro/formaPagamento">Forma de pagamento <span class="glyphicon glyphicon-credit-card"</span> </a></li>
					  <li role="presentation"><a href="/financeiro/conta">Conta <span class="glyphicon glyphicon-usd"</span> </a></li>
					  <li role="presentation"><a href="/financeiro/calculadora">Calculadora <span class="glyphicon glyphicon-plus"</span> </a></li>
					</ul>  		 																													  		 
				</div>
				<br>
				<div class="panel-body">					
					<div class="row">
						<div class="col-lg-3">						
							<label>Valor 01:</label> <br>
							<input type="number" class="form-control" maxlength="50" name="valor1"> <br>
							<label>Valor 02:</label> <br>
							<input type="number" class="form-control" maxlength="50" name="valor2"> <br>									
						</div>
					</div>
					
					<div class="row">				        
						<div class="col-lg-3">						        
							<label id="label-op" class="control-label">Operação:</label> <br>	        
							<select name="op" class="form-control">
							  <option value="+">Soma (+)</option>
							  <option value="-">Subtração (-)</option>
							  <option value="*">Multiplicação (*)</option>
							  <option value="/">Divisão (/)</option>
							</select> <br>
						</div>
        			</div>
        			<br>
			  		<p>${resultado}</p>        			
        			
					<div class="panel panel-footer">
				  		<button type="submit" class="btn btn-success">Calcular</button>		
				  		<button type="reset" class="btn btn-danger">Limpar</button>
					</div>	        									
				</div>					
				  		 
			</nav>
		</form>		 		 					
	</body>	
</html>