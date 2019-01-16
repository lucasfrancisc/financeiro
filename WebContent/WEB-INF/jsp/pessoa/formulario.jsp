<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" >
		
		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap-theme.min.css" />
		<script src="/financeiro/jquery/jquery.min.js"></script>
		<script src="/financeiro/bootstrap/js/bootstrap.min.js"></script>
	
		<script src="/financeiro/js/pessoa.js" charset="UTF-8" ></script>
	</head>
	
	<body>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="jumbotron">
		  					<c:if test="${entity.id != null}">
		  						<h1>Exibindo/Alterando Pessoa</h1>
		  					</c:if>
		  					<c:if test="${entity.id == null}">
		  						<h1>Incluindo Pessoa</h1>
		  					</c:if>		  					
		  				</div>
		  			</div>
		  			
		  			<div class="col-lg-12">		  				
						<form id="formulario" action="grava" method="post">
							<div class="panel ${entity.id != null ? 'panel-success' : 'panel-info'}">
  								<div class="panel panel-heading">
  									<h3 class="panel-title">
  										Por favor informe cada um dos campos abaixo
  									</h3>
  								</div>
  								
  								<fieldset ${entity.operacao eq 'EXIBICAO' ? 'disabled' : ''}>
	  								<div class="panel-body">
										<div class="row">										
											<c:if test="${entity.operacao != 'INCLUSAO'}">
												<div class="col-lg-3">
													<div class="form-group">
														<label for="label-id" class="control-label">Código:</label>
														<input id="input-id" class="form-control" type="text" 
														 	name="entity.id" readonly value="${entity.id}">
													</div>
												</div>
											</c:if>
											
											<input type="hidden" name="entity.operacao" value="${entity.operacao}">
											
											<div class="col-lg-3">
												<div class="form-group">
													<label for="label-nome" class="control-label">Nome:</label>
													<input id="input-nome" class="form-control" type="text" 
													 	name="entity.nome" value="${entity.nome}">
												</div>
											</div>
											
											<div class="col-lg-3">
												<div class="form-group">
													<label id="label-documento" class="control-label">Documento:</label>
													<input id="input-documento" class="form-control" type="text" name="entity.documento"
														value="${entity.documento}">
												</div>
											</div>
										</div>
									</div>
								</fieldset>
								
								<div class="panel panel-footer">
									<button id="button-salvar" class="btn btn-lg btn-primary" type="submit">
										Salvar
									</button>
									<button id="button-cancelar" class="btn btn-lg btn-danger">
										Cancelar
									</button>
								</div>
							</div>
						</form>						
					</div>
				</div>
			</div>
		</nav>
	</body>
</html>