<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>      
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver Votaciones</title>
</head>
<body>
<c:set var="verVotaciones" scope="request" value="${VerViewBean}" />
<h2>
    Resumen de Votaciones:
</h2>
<br>

<table>
	<tr> 
	<th align="center">TEMA</th>
	<th align="center">VOTOS</th>
	</tr>
    <c:forEach var="i" begin="0" end="${fn:length(verVotaciones.temas) - 1}" >
    <tr>
      <td align="center">
    	${verVotaciones.temas[i].nombre}  
      </td>
      <td align="center">
    	${verVotaciones.votos[i]} 
      </td>
    </tr>
    </c:forEach>
   </table>
<br>
<br>
<br>
<br>

<table>
	<tr> 
	<th align="center">TEMA</th>
	<th align="center">MEDIA<br>PRIMARIA</th>
	<th align="center">MEDIA<br>SECUNDARIA</th>
	<th align="center">MEDIA<br>SUPERIOR</th>
	</tr>
    <c:forEach var="i" begin="0" end="${fn:length(verVotaciones.temas) - 1}" >
    	<tr>
      <td align="center">
    	${verVotaciones.temas[i].nombre}  
      </td>
      
      <c:forEach var="j" begin="0" end="${fn:length(verVotaciones.medias[i]) - 1}" >
      
       <td align="center">
       
       		<c:choose>
      			<c:when test="${verVotaciones.medias[i][j]==-1}">-
      			</c:when>
      			<c:otherwise>
      				${verVotaciones.medias[i][j]}
	            </c:otherwise>
			</c:choose>
       </td>
     </c:forEach>
     </tr>
    </c:forEach>
</table>

<br><br>
<a href="/WebMaven/jsp/">INICIO</a>
</body>
</html>