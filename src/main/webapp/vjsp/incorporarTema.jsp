<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incorporar Tema</title>
</head>
<body>
<h2>
    Incorporar Tema:
</h2>
<c:set var="nuevoTema" scope="request" value="${IncorporarViewBean}" />

	<form method="post" action="/WebMaven/jsp/incorporarTema">
		<p>
			Tema: <input name="tema" type="text" value="${nuevoTema.nombre}" />
		</p>
		<p>
			Pregunta: <input name="pregunta" type="text" value="${nuevoTema.pregunta}" />
		</p>

		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>

<a href="/WebMaven/jsp/">INICIO</a>

</body>
</html>