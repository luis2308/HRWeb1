<%@ page import = "java.util.LinkedList"%> 
<%@ page language="java" %>
<%@ page import="mx.indexpro.hr.webapp.vo.DepartamentoVO" %>
<%@ page import= "mx.indexpro.hr.webapp.dao.DAODepartamento" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
		<center><h2>Consulta de Departamento</h2></center>
<hr color="#FE9A2E" size=5>
		<hr color="#1883ba" size=15>
		<hr color="#FE9A2E" size=5>
<br>
	</header>
	<nav></nav>
	<section>
		<article>
			<%LinkedList<DepartamentoVO> lista = (LinkedList<DepartamentoVO>)request.getAttribute("listaDepartamento"); %>
			<table>
				<tr>
					<td>ID</td>
					<td>NOMBRE DEPARTAMENTO</td>
					<td>ID GERENTE</td>
					<td>ID UBICACION</td>
				</tr>
				<%
for (int i=0;i<lista.size();i++)
{%>
				<tr>
					<td><%=lista.get(i).getIdDepartamento() %></td>
					<td><%=lista.get(i).getNombreDepartamento() %></td>
					<td><%=lista.get(i).getIdGerente() %></td>
					<td><%=lista.get(i).getIdUbicacion() %></td>
				</tr>
				<%	
} 
%>
			</table>
		</article>
	</section>

	<footer> </footer>


</body>
</html>