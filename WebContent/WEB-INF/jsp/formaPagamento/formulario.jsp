<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
 		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap.min.css" /> 
 		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap-theme.min.css" />	 
		<script src="/financeiro/bootstrap/js/bootstrap.min.js"></script>
		
		<script src="/financeiro/js/formaPagamento.js" charset="UTF-8" ></script>	
		<title>Forma de Pagamento</title>
	</head>
	<body>
		<form action="/financeiro/formaPagamento" method="post"> <!-- ${pageContext.request.contextPath}  -->
			<nav class="navbar navbar-default">
				<div class="container-fluid">					
					<div class="page-header">
						<h2>Forma de Pagamento <span class="glyphicon glyphicon-credit-card"> </span> </h2>			  										
					</div>
					
   	 			<jsp:include page="../menu/menu.jsp" />  
					
						
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
						</div>
											
						<div class="row">
							<div class="col-lg-6">						
								<label>Descrição:</label> <br>
								<input type="text" maxlength="50" class="form-control" maxlength="50"
									name="entity.descricao" value="${entity.descricao}"> <br>	
							</div>
						</div>					
	        
						<div class="row">				        
							<div class="col-lg-3">						        
								<label id="label-tipo" class="control-label">Tipo:</label> <br>	        
								<select name="entity.tipo" class="form-control">
								  <option value="dinheiro">Dinheiro</option>
								  <option value="cartaoC">Cartão Crédito</option>
								  <option value="cartaoD">Cartão Débito</option>
								</select> <br>
							</div>
	        			</div>				
			  		 	<p> ${mensagem} </p>
					</div>				  		 											
					
					<div class="panel panel-footer">
				  		<button type="submit" class="btn btn-success">Salvar</button>		
				  		<button type="reset" class="btn btn-danger">Limpar</button>
				  		<button type="button" onclick="location.href='/financeiro/formaPagamento/listagem'" class="btn btn-default">Listagem</button>
					</div>																			  		 
				</div>  		 
			</nav>
		</form>		 		 					
	</body>	
</html>