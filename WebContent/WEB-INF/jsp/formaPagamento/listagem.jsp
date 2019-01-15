<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
 		<link rel="stylesheet" href="/meufinanceiro/bootstrap/css/bootstrap.min.css" /> 
 		<link rel="stylesheet" href="/meufinanceiro/bootstrap/css/bootstrap-theme.min.css" />	 
		<script src="/meufinanceiro/bootstrap/js/bootstrap.min.js"></script>	
		<title>Cadastro de Forma de Pagamento</title>
	</head>
	<body>
		<H2>Listagem - Forma de Pagamento</H2>
		<c:forEach items="${formas}" var="forma">
			ID: 	  ${forma.id} <br>
			Decrição: ${forma.descricao} <br>
			Tipo: 	  ${forma.tipo} <br>
			<hr><br>
		</c:forEach>
	</body>
</html>