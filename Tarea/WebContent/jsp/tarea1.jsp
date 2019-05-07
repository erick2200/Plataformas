<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tarea1</title>
</head>
<body>

	<h1>Bienvenido a mi tarea</h1> 

	<%--estos son comentarios --%>
	
	<%--Los siguientes seran scriptlet  JSP --%>
	
	<% out.print("Hola al mundo del JSP");  %>
	
	<br>
	
	<%-- Estas son expresiones --%>
	
	<p>La fecha es : <%= new java.util.Date() %>  </p>
	
	<%-- Ejemplo de declaraciones --%>
	
	<%! public static int contenedor = 7;	%>
	
	<% out.print("El valor almacenado dentro de contenedor es " + contenedor); %>  <br> <br>
	
	<%--version del navegador --%>
	
	<% out.print(request.getHeader("USER-AGENT")); %>
	
	

	

</body>
</html>