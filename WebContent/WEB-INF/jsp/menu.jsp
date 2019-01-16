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
		<div class="jumbotron">
			<h1>Financeiro - Projeto JAVA</h1>
		</div>			
		<nav class="navbar navbar-default">
 			<div class="container-fluid">
    			<div class="navbar-header">
        			<a class="btn btn-success btn-lg btn-block" href="/financeiro/conta/lista">Conta</a>
   			 	</div>
			</div>	
 			<div class="container-fluid">
    			<div class="navbar-header">
        			<a class="btn btn-success btn-lg btn-block" href="/financeiro/formaPagamento/lista">Forma Pagamento</a>
   			 	</div>
			</div>				
 			<div class="container-fluid">
    			<div class="navbar-header">
        			<a class="btn btn-success btn-lg btn-block" href="/financeiro/pessoa/lista">Pessoa</a>
   			 	</div>
			</div>	
 			<div class="container-fluid">
    			<div class="navbar-header">
        			<a class="btn btn-success btn-lg btn-block" href="/financeiro/centroCusto/lista">Centro de Custo</a>
   			 	</div>
			</div>	
 			<div class="container-fluid">
    			<div class="navbar-header">
        			<a class="btn btn-success btn-lg btn-block" href="/financeiro/titulo/lista">Título</a>
   			 	</div>
			</div>							
		</nav>
	</body>
</html>

<%--

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
		<nav class="navbar navbar-default">
 			<div class="container-fluid">
    			<div class="navbar-header">
      				<a class="navbar-brand" href="/financeiro/conta/lista">Conta
        			<img alt="Brand" src="...">
      				</a>
   			 	</div>
			</div>
		</nav>
	</body>
</html>

--%>