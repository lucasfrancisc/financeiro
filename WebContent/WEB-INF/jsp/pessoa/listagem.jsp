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
  <div class="col-md-12">
    <h4>Lista item(ns)</h4>
    <table id="Pessoa" class="table table-bordred table-striped">
	  <thead>
	  <tr>
	    <th>Codigo</th>
	    <th>Nome</th>
	    <th>Documento</th>
	    <th>Açao</th>
	  </tr>  
	  </thead>
	  <tbody>
	    <c:forEach items="${qry}" var="p">
	  	  <tr>
		    <td>${p.id}</td>
		    <td>${p.nome}</td>
		    <td>${p.documento}</td>
		    <td>
		      <a href="exibir?id=${p.id}" class="btn-exibir btn btn-xs btn-primary">
  		        <span class="glyphicon glyphicon-pencil"></span>
		      </a>
		    </td>
		    <td>
		      <a href="excluir?id=${p.id}" class="btn-excluir btn btn-xs btn-danger">
		        <span class="glyphicon glyphicon-trash"> </span>
		      </a>
		    </td>
<!-- 		    <td> -->
<%-- 		      <a href="alterar?id=${p.id}" class="btn-alterar btn btn-xs btn-danger"> --%>
<!-- 		        <span class="glyphicon glyphicon-trash"> </span> -->
<!-- 		      </a> -->
<!-- 		    </td>		     -->
	      </tr>
	    </c:forEach>
	  </tbody>
    </table>
  </div>
</body>
<script src="/meufinanceiro/js/centroCusto/pessoa-listagem.js"></script>
</html>