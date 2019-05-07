<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Probando JSTL</title>
</head>
<body>

	<h2>Estudiante registrado</h2>
	
	Nombre del estudiante: 	<c:out value="${estudiante.getNombre()}"></c:out> <br>
	
	ID del estudiante: <c:out value="${estudiante.getId()}" > </c:out> <br>
	
	<c:set var="edad" value="${estudiante.getEdad() }" ></c:set>
	
	Edad del estudiante: <c:out value="${edad}"> </c:out><br>
	
	<c:if test="${edad>=18}"> 
	
		<p>Es mayor de edad </p>
	
	</c:if>
	
	<br>
	<c:import url="fecha.jsp"></c:import>


</body>
</html>