<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Consultando registro(s)</title>
  
  <link rel="stylesheet" href="/meufinanceiro/bootstrap/css/bootstrap.min.css" />
  <link rel="stylesheet" href="/meufinanceiro/bootstrap/css/bootstrap-theme.min.css" />
  
  <script src="/meufinanceiro/jquery/jquery.min.js"></script>
  <script src="/meufinanceiro/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
  <form>
	<input type="text" name="pesquisa" value="${pesquisa}">
	<button>Pesquisar</button>
  </form>
  <div class="col-md-12">
    <h4>Lista item(ns)</h4>
    <table id="CentroCusto" class="table table-bordred table-striped">
	  <thead>
	    <th>Código</th>
	    <th>Descrição</th>
	    <th>Número</th>
	  </thead>
	  <tbody>
	    <c:forEach items="${centroCusto}" var="t">
	  	  <tr>
		    <td>${t.id}</td>
		    <td>${t.descricao}</td>
		    <td>${t.numero}</td>
		    <td>
		      <a href="exibir?id=${t.id}" class="btn-exibir btn btn-xs btn-primary">
  		        <span class="glyphicon glyphicon-pencil"></span>
		      </a>
		    </td>
		    <td>
		      <a href="excluir?id=${t.id}" class="btn-excluir btn btn-xs btn-danger">
		        <span class="glyphicon glyphicon-trash">
		      </a>
		    </td>
	      </tr>
	    </c:forEach>
	  </tbody>
    </table>
  </div>
</body>
<script src="/meufinanceiro/js/centroCusto/centroCusto-listagem.js"></script>
</html>