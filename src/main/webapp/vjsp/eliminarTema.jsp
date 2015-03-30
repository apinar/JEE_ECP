<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
 <c:set var="eliminaTema" scope="request" value="${EliminarViewBean}" />

	<form method="post" action="/WebMaven/jsp/incorporarTema">
		<p>
			Seleccionar Tema a borrar:
			<c:forEach var="tema" items="${eliminaTema.temas}">
				${tema.nombre}
			</c:forEach>
		</p>
		

		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>

<a href="/WebMaven/jsp/">INICIO</a>
 
</body>
</html>