<%@ page import = "java.util.LinkedList"%> 
<%@ page language="java" %>
<%@ page import="mx.indexpro.hr.webapp.vo.DepartamentoVO" %>
<%@ page import= "mx.indexpro.hr.webapp.dao.DAODepartamento" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
  .boton_personalizado{
    text-decoration: none;
    padding: 10px;
    line-height:3px;
    font-weight: 400;
    font-size: 15px;
    color: #ffffff;
    background-color: #1883ba;
    border-radius: 6px;
    border: 2px solid #FE9A2E;
  }
  .boton_personalizado:hover{
    color: #000000;
    background-color: #ffffff;
  }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header>
	<center>
	<h1> Actualiza Departamanto </h1>
	</center>
</header>
<nav></nav>
<section>
	<article>
		<hr color="#FE9A2E" size=5>
		<hr color="#1883ba" size=15>
		<hr color="#FE9A2E" size=5>
		<center>
		<a href="/HRWebPrueba2">Menu</a>
		<form action="<%=request.getContextPath()%>/funcionDepartamento" method="post">
<input type="hidden" name="accion" value="busca">
<table>
	<tr>
		<td><label for="Name">ID del Departamento:</label> <br> </td> 
		<td><input  type="text" size="30" maxlength="30"  name="id_dep" > </td>
	</tr>
</table>
	 <input class="boton_personalizado" type="submit" value="Buscar" title="Buscar" alt="Buscar" style="width:100px; height:25px">
</form>
<%LinkedList<DepartamentoVO> lista = (LinkedList<DepartamentoVO>)request.getAttribute("listaDepartamento"); %>

<% 
int cont=0;
for (int i=0;i<lista.size();i++){
cont++;
}
		
%>
<%
if (cont==1){
for (int i=0;i<lista.size();i++)
{%>
<form action="<%=request.getContextPath()%>/funcionDepartamento" method="post">
<input type="hidden" name="accion" value="actualiza">
<table>

			<tr>
				<td><label for="Name">ID:</label> </td>
				<td><input type="text" size="30" maxlength="30"  name="id_dep" value="<%=lista.get(i).getIdDepartamento()%>"> </td> 
			</tr>
			<tr>
				<td><label for="Name">Nombre del Departamento:</label> </td>
				<td><input type="text" size="30" maxlength="30"  name="nom_dep" value="<%=lista.get(i).getNombreDepartamento()%>"> </td> 
			</tr>
			<tr>
				<td><label for="Name">ID Gerente:</label> </td> 
				<td><input type="text" size="30" maxlength="30"  name="id_gerente" value="<%=lista.get(i).getIdGerente()%>"> </td> 
			</tr>
			<tr>
				<td><label for="Name">ID Ubicacion:</label> </td> 
				<td><input type="text" size="30" maxlength="30"  name="id_ubicacion" value="<%=lista.get(i).getIdUbicacion() %>"> </td> 
			</tr>
			</table>
			<input class="boton_personalizado" type="submit" value="Enviar" title="Enviar" alt="Enviar" style="width:100px; height:25px">
	 <%	
} 
}
%>
</form>
</body>

</body>
</html>