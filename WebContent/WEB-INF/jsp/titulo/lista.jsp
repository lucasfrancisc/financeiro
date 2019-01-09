<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<script src="/financeiro/jquery/jquery.min.js"></script>
	</head>
	<body>
		
		<form>
			<input type="text" name="pesquisa" value="${pesquisa}">
			<button>Pesquisar</button>
		</form>
		
		<table id="lucas">
			<thead>
				<th>Código</th>
				<th>Descrição</th>
				<th>Ação</th>
			</thead>
			<tbody>
				<c:forEach items="${entitys}" var="t">
					<tr>
						<td>${t.id}</td>
						<td>${t.descricao}</td>
						<td><a href="exibi?id=${t.id}">Exibir</a></td>
						<td><a href="exclui" class="btn-excluir btn btn-sm btn-danger" titulo-id="${t.descricao}">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
	<script src="/financeiro/js/titulo-listagem.js"></script>
</html>