<%@ page import = "java.util.LinkedList"%> 
<%@ page language="java" %>
<%@ page import="mx.indexpro.hr.webapp.vo.RegionVO" %>
<%@ page import= "mx.indexpro.hr.webapp.dao.DAORegion" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h2>Consulta de Regiones</h2></center>
<hr color="#FE9A2E" size=5>
		<hr color="#1883ba" size=15>
		<hr color="#FE9A2E" size=5>
<br>
<%LinkedList<RegionVO> lista = (LinkedList<RegionVO>)request.getAttribute("lista"); %>
<table>
	<tr>
		<td>ID</td>
		<td>NOMBRE</td>
		
		
		
	</tr>
<%
for (int i=0;i<lista.size();i++)
{%>
	<tr>
	<td><%=lista.get(i).getId_Regions() %></td>
	<td><%=lista.get(i).getNombre_Region() %></td>
	</tr>
<%	
} 
%>
</table>
</body>
</html>