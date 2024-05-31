<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	HttpSession sesion = request.getSession();
%>
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Registro</title>
			<link rel="stylesheet" href="../css/registro.css">
			<meta name="author" content="María Perez Vaca e Iván Naranjo Marín">
 
			<!--Fuente de Google Font que utiliza el proyecto-->
			<link rel="preconnect" href="https://fonts.googleapis.com">
			<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
			 <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
			<!--Font Awesome-->
			<script src="https://kit.fontawesome.com/efd4e72963.js" crossorigin="anonymous"></script>
			<!--JavaScript-->
			<script type="text/javascript" src="../Script/ValidacionesRegistro.js"></script>
			
			<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		</head>
		<body>
			<h1>Registrarse</h1>
			<form action="../registro" method="POST" id="frm">
				<label>Nombre</label> <input type="text" name="nombre" id="nombre" required>
				<div class="errorNombre"></div>
				<label>Apellidos</label> <input type="text" name="apellidos" id="apellido" required>
				<div class="errorApellidos"></div>
				<label>Email</label> <input type="email" name="user" id="user-email" required>
				<div class="errorEmail"></div>
				<label>Fecha de nacimiento</label> <input type="date" name="nacimiento" id="fecha_nacimiento" required>
				<div class="FecNacimiento"></div>
				<label>DNIE</label> <input type="text" name="dni" id="dni" required>
				<div class="errorDNI"></div>
				
				<label for="centro">Centro de estudios</label>
				<select id="centro" name="centro" onchange="cargarSegundoDesplegable()">
					<option value="">Selecciona una opci�n</option>
				</select>
				
				<label for="curso">Curso</label>
				<select id="curso" name="curso">
					<option value="">Selecciona una opci�n</option>
				</select>
 
 
				<label for="contrasena">Contrase�a:</label>
				<input type="password" name="contrasena" id="contrasena" value="" placeholder="Ingrese su contraseña..." required>
				
				<label for="recontrasena">Repetir Contrase�a:</label>
				<input type="password" name="recontrasena" id="recontrasena" value="" placeholder="Confirme su contraseña..." required>
				
				<input id="boton" type="button" value="Registrar" onclick="validar()">
				<div class="errorContrasena"></div>
			</form>
			
			<div id="mensaje"></div>
			
			<script src="../Script/registro.js"></script>
		</body>
</html>