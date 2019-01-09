<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  
  <link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap.min.css" />
  <link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap-theme.min.css" />
  <script src="/financeiro/jquery/jquery.min.js"></script>
  <script src="/financeiro/bootstrap/js/bootstrap.min.js"></script>
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
		  <form id="formulario" action="grava" method="post">
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
					  <label for="label-id" class="control-label">C�digo:</label>
					  <input id="input-id" class="form-control" type="text" 
						     name="entity.id" value="${entity.id}">
					</div>
				  </div>
				  
				  <div class="col-lg-3">
					<div class="form-group">
					  <label for="label-descricao" class="control-label">Descri��o:</label>
					  <input id="input-descricao" class="form-control" type="text" 
							 name="entity.descricao" value="${entity.descricao}">
					</div>
				  </div>
				  
				  <div class="col-lg-3">
					<div class="form-group">
					  <label for="label-descricao" class="control-label">N�mero:</label>
					  <input id="input-descricao" class="form-control" type="text" 
							 name="entity.numero" value="${entity.numero}">
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