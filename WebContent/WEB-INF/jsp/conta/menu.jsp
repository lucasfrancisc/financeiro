<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8"/>
		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap-min.css">
		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap-theme.min.css">
		<script>src="/financeiro/bootstrap/js/bootstrap.min.js"</script>
		<script>src="/financeiro/jquery/jquery.min.js"</script>
		<title>Menu: Financeiro</title>
	</head>
	<body>  
 
		<div class="container">
		<div class="row">
		<div class="span12">
		<div class="page-header">
			<h2>Financeiro - Projeto Treinamento JAVA  <small>Cadastros</small></h2>
		</div>
       
       <div class="well">
			<div class="btn-group">
				<a class="btn btn-success" href="/financeiro/pessoa/lista">Pessoa</a>
				<a class="btn btn-success" href="/financeiro/conta/lista">Conta</a>
				<a class="btn btn-success" href="/financeiro/formaPagamento/lista">Forma Pagamento</a>
				<a class="btn btn-success" href="/financeiro/centroCusto/lista">Centro de Custo</a>
				<a class="btn btn-success" href="/financeiro/titulo/lista">Título</a>
			</div>          
		</div>
		</div>
		</div>
		</div>
 	</body>  
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js" type="text/javascript"></script>
</html>