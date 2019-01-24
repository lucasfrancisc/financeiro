<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem - Forma de Pagamento</title>
		<script src="/financeiro/jquery/jquery.min.js"></script>
	</head>
	<body>
		
		<form>
			<input type="text" name="pesquisa" value="${pesquisa}">
			<button>Pesquisar</button>
		</form>
		
		<table id="lista">
			<thead>
				<th>Código</th>
				<th>Descrição</th>
				<th>Tipo</th>
			</thead>
			<tbody>
				<c:forEach items="${entitys}" var="t">
					<tr>
						<td>${t.id}</td>
						<td>${t.descricao}</td>
						<td><a href="exibir?id=${t.id}">Exibir</a></td>
						<td><a href="excluir" class="btn-excluir btn btn-sm btn-danger" formaPagamento-id="${t.descricao}">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
	<script src="/financeiro/js/titulo-listagem.js"></script>
</html>