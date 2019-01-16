<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap-min.css">
		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap-theme.min.css">
		<script>src="/financeiro/bootstrap/js/bootstrap.min.js"</script>
		<script>src="/financeiro/jquery/jquery.min.js"</script>
		<title>Adiciona: Forma de Pagamento</title>
	</head>
	<body>		 
		<div class="jumbotron">
			<c:if test="${entity.operacao == 'INCLUSAO'}">
				<h1>Incluindo Forma de Pagamento</h1>
			</c:if>
			<c:if test="${entity.operacao == 'EXIBICAO'}">
				<h1>Exibindo Forma de Pagamento</h1>
			</c:if>
			<c:if test="${entity.operacao == 'ALTERACAO'}">
				<h1>Alterando Forma de Pagamento</h1>
			</c:if>
		</div>
		<form id="formulario" action="grava" method="post">
			<input type = "hidden" readonly name="entity.operacao" value="${entity.operacao}"/> 
			<fieldset ${entity.operacao eq 'EXIBICAO' ? 'disabled' : ''}>
				<c:if test="${entity.operacao != 'INCLUSAO'}">
    				<div class="form-group">
						<label for="label-id" class="control-id">C�digo:</label>
        				<input id="input-id" class="form-control" type="text" name="entity.id" readonly value="${entity.id}"/> 
    				</div> 
    			</c:if>
    			<div class="form-group">
					<label for="label-descricao" class="control-label">Descri��o:</label>
        			<input id="input-descricao" class="form-control" type="text" name="entity.descricao" value="${entity.descricao}"/>
    			</div> 
					<div class="form-group">
						<label id="label-tipo" class="control-label">Tipo:</label>
						<label class="radio-inline">
							<input id="input-tipo" class="list-group" type="radio" name="entity.tipo" value="DINHEIRO" checked="${entity.tipo}"> Dinheiro
						</label>
						<label class="radio-inline">
							<input id="input-tipo" class="list-group" type="radio" name="entity.tipo" value="CARTAO CREDITO" checked="${entity.tipo}"> Cart�o de Cr�dito 
						</label>
						<label class="radio-inline">		
							<input id="input-tipo" class="list-group" type="radio" name="entity.tipo" value="CARTAO DEBITO" checked="${entity.tipo}"> Cart�o de D�bito
						</label>
    				</div>
			</fieldset>
			<div class="panel panel-footer">
				<c:if test="${entity.operacao == 'INCLUSAO' or entity.operacao == 'ALTERACAO'}">
					<button id="button-grava"   class="button-grava btn btn-sm btn-primary" type="submit">Grava</button>
				</c:if>
				<c:if test="${entity.operacao == 'EXIBICAO'}">
					<td><a id="button-exclui" class="btn btn-sm btn-danger"  href="exclui?id=${entity.id}">Exclui</a></td>
					<td><a id="button-altera" class="btn btn-sm btn-success" href="altera?id=${entity.id}">Altera</a></td>			
				</c:if>			
				<a id="button-lista" class="button-lista btn btn-sm btn-warning" href="lista">Fecha</a>	
			</div>
		</form>
	</body>
</html>