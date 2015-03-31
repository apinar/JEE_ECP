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
	<c:set var="elegidoTema" scope="request" value="${VotarViewBean.elegidoTema}" />
	<c:set var="vota" scope="request" value="${VotarViewBean}" />
 		<c:choose>
 			<c:when test="${elegidoTema == false}" >

				<form method="post" action="/WebMaven/jsp/votar">
					<p>
					Seleccionar Tema para votar:
					</p>
					<p>
					<select name="tema">
					<c:forEach var="tema" items="${vota.temas}">
						<option value="${tema.id}" selected>${tema.nombre}</option><br>
					</c:forEach>
					</select>
					</p>
					
					<p>
						<input type="hidden" value="true" name="votar" />
						<input type="submit" value="Enviar" />
					</p>
				</form>
			</c:when>
			<c:otherwise>
			
			<form method="post" action="/WebMaven/jsp/votar">
			Tema elegido: <b>${vota.tema.nombre}</b> 
			<br>
			
			Pregunta: <b>${vota.tema.pregunta}</b> 
			
			
			
			<br><br>
			Puntuación:
			<select name="puntuacion">
			<c:forEach var="puntuacion" items="${vota.escala}">
					<option value="${puntuacion}" selected>${puntuacion}</option><br>
			</c:forEach>
			</select>
			<br>
			Nivel de Estudios:
			<select name="estudio">
			<c:forEach var="estudio" items="${vota.estudios}">
						<option value="${estudio}" selected>${estudio}</option><br>
					</c:forEach>
			</select>
			
			<input type="hidden" value="false" name="votar" />
			<input type="hidden" value="${vota.tema.id}" name="tema" />
			<input type="submit" value="Enviar" />
			</form>
			</c:otherwise>
			</c:choose>		

<br>
<a href="/WebMaven/jsp/">INICIO</a>
</body>
</html>