<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  
  <link rel="stylesheet" href="/meufinanceiro/bootstrap/css/bootstrap.min.css" />
  <link rel="stylesheet" href="/meufinanceiro/bootstrap/css/bootstrap-theme.min.css" />
  <script src="/meufinanceiro/jquery/jquery.min.js"></script>
  <script src="/meufinanceiro/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
  <nav class="navbar navbar-default">
	<div class="container-fluid">
	  <div class="row">
		<div class="col-lg-12">
		  <div class="jumbotron">
		  	<h1>Incluindo Centro Custo</h1>
		  </div>
		</div>

		<div class="col-lg-12">
		  <form id="formulario" action="save" method="post">
			<div class="panel panel-info">
  			  <div class="panel panel-heading">
  				<h3 class="panel-title">
  				  Por favor informe cada um dos campos abaixo
  				</h3>
  			  </div>

  			  <div class="panel-body">
				<div class="row">
				  <div class="col-lg-3">
					<div class="form-group">
					  <label for="label-id" class="control-label">Código:</label>
					  <input id="input-id" class="form-control" type="text" 
						     name="centroCusto.id" value="${centroCusto.id}">
					</div>
				  </div>
				  
				  <div class="col-lg-3">
					<div class="form-group">
					  <label for="label-descricao" class="control-label">Descrição:</label>
					  <input id="input-descricao" class="form-control" type="text" 
							 name="centroCusto.descricao" value="${centroCusto.descricao}">
					</div>
				  </div>
				  
				  <div class="col-lg-3">
					<div class="form-group">
					  <label for="label-descricao" class="control-label">Número:</label>
					  <input id="input-descricao" class="form-control" type="text" 
							 name="centroCusto.numero" value="${centroCusto.numero}">
					</div>
				  </div>
				  
				  <div class="panel panel-footer">
					<button id="button-salvar" class="btn btn-lg btn-primary" type="submit">
					  Salvar
					</button>
				    <button id="button-cancelar" class="btn btn-lg btn-danger">
					  Cancelar
					</button>
				  </div>	
			    </div>
		      </div>
		    </div>  
		 </form>						
	   </div>
	  </div>
	</div>
  </nav>
</body>
</html>