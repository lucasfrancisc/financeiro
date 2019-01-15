<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
  		<meta charset="ISO-8859-1">

    <title>Menu</title>

		<meta name="viewport" content="width=device-width">

	    <script src="/financeiro/jquery/jquery.min.js"></script>
	    <script src="financeiro/bootstrap/js/bootstrap.js"type="text/javascript"></script>
	    <link href="financeiro/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
	
		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/financeiro/bootstrap/css/bootstrap-theme.min.css" />

	
		<script src="/financeiro/bootstrap/js/bootstrap.min.js"></script>
	</head>

<body>
  <nav class="navbar navbar-default navbar-static-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Sistema Financeiro</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
<!--           <li class="active"><a href="#">Home</a></li> -->
<!--           <li><a href="#about">Sobre</a></li> -->
<!--           <li><a href="#contact">Contato</a></li> -->
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              Cadastro de Pessoa<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="/financeiro/pessoa/add">Incluir</a></li>
              <li><a href="/financeiro/pessoa/listagem">Consultar</a></li>
              <li><a href="/financeiro/pessoa/localiza">localizar</a></li>
              <li role="separator" class="divider"></li>
              <li class="dropdown-header">Relatórios</li>
              <li><a href="/financeiro/pessoa/relatorio">Lista Pessoa</a></li>
            </ul>
          </li>
        </ul>
<!--         <form class="navbar-form navbar-right"> -->
<!--           <div class="form-group"> -->
<!--           <input type="text" class="form-control" placeholder="Pesquisar"> -->
<!--           </div> -->
<!--           <button type="submit" class="btn btn-default">Pesquisar</button> -->
<!--         </form> -->
      </div>
    </div>
  </nav>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!--   <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script> -->
<!--   <script src="js/bootstrap.min.js"></script> -->
</body>








</html>	