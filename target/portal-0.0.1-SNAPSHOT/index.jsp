<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.portal.catalogo.Usuario"%>
<!DOCTYPE html>
<%
 
 
if(request.getSession().getAttribute("usuario") == null && !request.getSession().getAttribute("tipo").equals("accenture")){
	
	response.sendRedirect("/portal/jsp/login.jsp");
}
Usuario usr = (Usuario) request.getSession().getAttribute("usuario");
%>
<html>
 
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>ProyectoFP</title>
 
<link rel="stylesheet" href="css/index.css">
<!--Fuente de Google Font que utiliza el proyecto-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"
	rel="stylesheet">
<!--Font Awesome-->
<script src="https://kit.fontawesome.com/efd4e72963.js"
	crossorigin="anonymous"></script>
</head>
 
<body>
 
	<div class="total">
		<header
			<%int idCentro = usr.getIdCentro();     
				switch (idCentro) {         
				case 1: %>class="alixar"<% break;         
				case 2: %>class="salesianas"<% break;         
				case 3: %>class="sotero"<% break;         
				case 4: %>class="machado"<% break;
				default: %>class="accenture"<% break;} %> >
 
 
 
			<div>
				<% if(!usr.getTipo().equals("accenture")){
					switch (usr.getIdCentro()){
						case 1:%>
					  <img alt="IES Alixar" src="img/alixar.png" width="65px">
 
				<%;
							break;
							
						case 2:%>
					<img alt="Salesianas Nervion Maria Auxiliadora" src="img/salesianas.png" width="55px">
				<%;
							break;
							
						case 3:%>
					<img alt="IES Sotero Hernández" src="img/sotero.png" width="55px">
					
				<%;
							break;
							
						case 4:%>
					<img alt="IES Hermanos Machado" src="img/machado.png" width="60px">
				<%;
							break;
							
						default:%>
					<i class="fa-solid fa-school" style="margin-bottom: 7px;"></i>
				<%;
							break;
					}
 
				}  %>
 
 
 
 
 
				<div class="cabecera">
					<% if (usr.getTipo().equals("accenture")) { %>
					<img alt="accenture" src="img/accenture.png" width="100px">
					<% } else { %>
					<%= usr.getNombreCentro() %>
					<% } %>
 
 
				</div>
			</div>
			<div>
 
				<div class="cabecera"><%= usr.getNombre()+" "+usr.getApellidos() %></div>
				<i class="fa-solid fa-user-pen" style="margin-bottom: 6px;"></i>
			</div>
 
 
 
		</header>
 
		<sidebar
			<%
				switch (usr.getIdCentro()) {         
				case 1: %>class="sidebar-alixar"<% break;         
				case 2: %>class="sidebar-salesianas"<% break;         
				case 3: %>class="sidebar-sotero"<% break;         
				case 4: %>class="sidebar-machado"<% break;
				default: %>class="sidebar-accenture"<% break;} %>>
				
		<div>
			<i class="fa-solid fa-house casa-icon"></i> <a
				href="iFramesIndex/indexCentro.html" target="MAIN">CENTRO</a>
		</div>
 
		<div>
			<i class="fa-solid fa-book cuadrado-icon"></i> <a
				href="iFramesIndex/indexModulo.html" target="MAIN">MÓDULO</a>
		</div>
 
		<div>
			<i class="fa-solid fa-chalkboard-user fa-xs"></i> <a
				href="iFramesIndex/indexTutoria.html" target="MAIN">TUTORÍAS</a>
		</div>
 
		<div>
			<i class="fa-solid fa-file-lines cuadrado-icon"></i> <a
				href="iFramesIndex/indexCalificaciones.html" target="MAIN">CALIFICACIONES</a>
		</div>
 
		</sidebar>
 
		<main>
			<iframe src="" frameborder="0" name="MAIN"></iframe>
		</main>
 
 
		<footer>
 
			<p>Maria Del Mar Sierra Gutierrez 2024</p>
 
		</footer>
 
	</div>
</body>
</html>