<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8"/>
		<link rel="stylesheet" href="/meufinanceiro/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" href="/meufinanceiro/bootstrap/css/bootstrap-min.css">
		<link rel="stylesheet" href="/meufinanceiro/bootstrap/css/bootstrap-theme.min.css">
		<script>src="/meufinanceiro/bootstrap/js/bootstrap.min.js"</script>
		<script>src="/meufinanceiro/jquery/jquery.min.js"</script>
		<script>src="/meufinanceiro/js/conta.js"</script>
		<title>Listagem: Conta</title>
	</head>
	<body>
		<div class="jumbotron">
		  	<h1>Listagem de Conta</h1>
		</div>
		<form >	
			<div>
				<input type="text" name="descricao" value="${descricao}">
				<button class="btn btn-default">Filtro: Descrição</button>
				<a class="btn btn-success" href="inclui">Novo</a>	
			</div> 			

 			<table class="table table-sm">
    			<tr>
        			<th scope="col">Código</th>
        			<th scope="col">Descrição</th>
        			<th scope="col">Tipo</th>
        			<th scope="col">Saldo</th>
        			<th scope="col">Consulta</th>
        			<th scope="col">Altera</th>
        			<th scope="col">Exclui</th>
   				</tr>		
				<tbody>
					<c:forEach items="${listaconta}" var="c">
					<tr>
						<td>${c.id}</td>
						<td>${c.descricao}</td>
						<td>${c.tipo}</td>
						<td>${c.saldo}</td>
					 	<td><a id="button-consulta" href="exibi?id=${c.id}" class="btn btn-sm btn-info">Consulta</a></td>  
						<td><a id="button-altera" href="altera?id=${c.id}" class="btn btn-sm btn-success">Altera</a></td>
						<td><a id="button-exclui" href="exclui?id=${c.id}" class="btn btn-sm btn-danger">Exclui</a></td>
					</tr>
					</c:forEach>
				</tbody> 		
 			</table>			
		</form>
	</body>
</html>