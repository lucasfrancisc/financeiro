<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
 		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap.min.css" /> 
 		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap-theme.min.css" />	 
		<script src="/financeiro/bootstrap/js/bootstrap.min.js"></script>	
		<title>Financeiro</title>
	</head>
	<body>
<!-- 		<form action="/financeiro/menu" method="post"> ${pageContext.request.contextPath}  -->
			<nav class="navbar navbar-default">
				<div class="container-fluid">					
					<div class="page-header">
						<h2>Financeiro <span class="glyphicon glyphicon-piggy-bank"> </span> </h2>			  										
					</div> <hr>		
					<ul class="nav nav-pills">
					  <li role="presentation" class="active">
					  	<a href="/financeiro">
						  	Home 
						  	<span class="glyphicon glyphicon-home">
						  	</span>
					  	</a>
					  </li>
					<li role="presentation"><a
						href="/financeiro/pessoa/add">Pessoa 
						<span class="glyphicon glyphicon-user"></span>
						</a>
					</li>										 
					<li role="presentation"><a
						href="/financeiro/formaPagamento/add">Forma de pagamento 
						<span class="glyphicon glyphicon-credit-card"></span>
						</a>
					</li>
					<li role="presentation"><a href="/financeiro/conta">Conta
							<span class="glyphicon glyphicon-usd"></span>
						</a>
					</li>
					<li role="presentation"><a
						href="/financeiro/centroCusto/add">Centro de custo 
						<span class="glyphicon glyphicon-record"></span>
						</a>
					</li>					
					<li role="presentation"><a href="/financeiro/calculadora">Calculadora
							<span class="glyphicon glyphicon-plus"></span>
					</a></li>
				</ul> <br>	 																													  		 
				</div>  		 
			</nav>
<!-- 		</form>		 		 					 -->
	</body>	
</html>