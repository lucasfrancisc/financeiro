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
		<title>Listagem: Centro de Custo</title>
	</head>
	<body>
		<div class="page-header">
		  	<h1>Listagem de Centro de Custo</h1>
		</div>
		<form >	
			<table class="table table-sm">
			    <tr>
        			<th>
        				<input type="text" name="pesquisa" value="${pesquisa}">
						<button class="btn btn-default">Filtro: Descrição</button>
					</th>				
					<th>
						<a class="btn btn-success" href="inclui">Novo
						<span class="glyphicon glyphicon-pluse"></span>
						</a>
					</th>
					<th>
						<a href="/financeiro/conta/menu">Menu
						<span class="glyphicon glyphicon-home"></span>
					  	</a>
					 </th>
				</tr>	
			</table> 			

 			<table class="table table-sm">
    			<tr>
        			<th scope="col">Código</th>
        			<th scope="col">Descrição</th>
        			<th scope="col">Número</th>
        			<th scope="col"></th>
        			<th scope="col"></th>
        			<th scope="col"></th>
   				</tr>		
				<tbody>
					<c:forEach items="${entitys}" var="c">
					<tr>
						<td>${c.id}</td>
						<td>${c.descricao}</td>
						<td>${c.numero}</td>
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