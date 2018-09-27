<%@ page import = "java.util.LinkedList"%>
<%@ page import="mx.indexpro.hr.webapp.vo.LocacionVO" %>
<%@ page import= "mx.indexpro.hr.webapp.dao.DAOLocaciones" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Consulta a base de datos</h1></center>
<hr color="#FE9A2E" size=5>
		<hr color="#1883ba" size=15>
		<hr color="#FE9A2E" size=5>
<br>
<%LinkedList<LocacionVO> lista = (LinkedList<LocacionVO>)request.getAttribute("lista");%>
<table>
	<tr>
		<td>ID_LOCACION</td>
		<td>DIRECCION</td>
		<td> CODIGO POSTAL</td>
		<td>COIDAD</td>
		<td>ESTADO</td>
		<td>PAIS</td>
		
		
		
		
	</tr>
	<%
for (int i=0;i<lista.size();i++)
{%>
<tr>
    
	<td><%=lista.get(i).getIdLocacion()%></td>
	<td><%=lista.get(i).getDireccion() %></td>
	<td><%=lista.get(i).getCodigo() %></td>
	<td><%=lista.get(i).getCiudad() %></td>
	<td><%=lista.get(i).getEstado() %></td>
	<td><%=lista.get(i).getPais() %></td>
	
	</tr>
<%	
} 
%>
</table>
</body>
</html>