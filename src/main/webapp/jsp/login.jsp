<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 
<head>
    <meta charset="UTF-8">
    <meta name="author">
    <title>Login</title>
    <link rel="stylesheet" href="../css/login.css">
 
    <!--Fuente de Google Font que utiliza el proyecto-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <!--Font Awesome-->
    <script src="https://kit.fontawesome.com/efd4e72963.js" crossorigin="anonymous"></script>
</head>
 
<body>
    <div>
        <img src="../img/image 1.png" id="robotImg">
        <h1>Grupo Gonzalico, La Rubia & co</h1>
    </div>
    <div id="Columna"></div>
    <form action="../login" method="post" id="login">
        <label for="user"> <i class="fa-solid fa-user"></i> Usuario</label>
        <input type="email" name="user" placeholder="Correo electrónico">
        <br>
        <label for="passwd"> <i class="fa-solid fa-key"></i> Contraseña</label>
        <input type="password" name="passwd" placeholder="Contraseña">
        <button type="submit" id="submitLog">Iniciar Sesión</button>
 
        <div id="AccesoReg">
            <a href="registro.jsp">Acceder al registro de Usuarios</a>
        </div>
    </form>
</body>
 
</html>