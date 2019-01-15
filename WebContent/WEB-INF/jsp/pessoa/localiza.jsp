<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Filtrando Minha Tabela</h2>

  <input class="form-control" id="myInput" type="text" placeholder="Search...">
  <br>
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>Codigo</th>
        <th>Nome</th>
        <th>Documento</th>
      </tr>
    </thead>
    <tbody id="myTable">
      <tr>
	    <c:forEach items="${pesquisa}" var="p">
	  	  <tr>
		    <td>${p.id}</td>
		    <td>${p.nome}</td>
		    <td>${p.documento}</td>
		    <td>
	      </tr>
	    </c:forEach>
     </tr>
    </tbody>
  </table>
</div>


<script>
 $(document).ready(function(){
   $("#myInput").on("keyup", function() {
     var value = $(this).val().toLowerCase();
     $("#myTable tr").filter(function() {
       $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
     });
   });
 });
</script> 

</body>
</html>