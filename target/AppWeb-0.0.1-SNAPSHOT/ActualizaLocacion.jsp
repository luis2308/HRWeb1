<%@ page import = "java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@ page import="mx.indexpro.hr.webapp.vo.LocacionVO" %>
<%@ page import= "mx.indexpro.hr.webapp.dao.DAOLocaciones" %>
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
	<h1> Actualiza Locacion </h1>
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
		<center>
<h1> Busca por ID </h1>
<!-- ANTES SE IBA CON EL SERVLET DE updateServlet -->
<form action="<%=request.getContextPath()%>/funcionLocacion" method="post">

<table>
	<tr>
		<td><label for="Name">ID Locacion:</label> <br> </td> 
		<td><input type="text" size="30" maxlength="30"  name="id_locacion" > </td>
	</tr>
</table>
	 <input class="boton_personalizado" type="submit" value="Buscar" title="Buscar" alt="Buscar" style="width:100px; height:25px">
<input type="hidden" name="opcion" value="busca">
</form>

		
<%LinkedList<LocacionVO> lista = (LinkedList<LocacionVO>)request.getAttribute("lista"); %>		

<form action="<%=request.getContextPath()%>/funcionLocacion" method="post">
<table>
<% 
int cont=0;
for (int i=0;i<lista.size();i++){
cont++;
}
if(cont==1){
for (int i=0;i<lista.size();i++)
{	
%>
	<tr>
		<td><label for="Name">ID Locacion:</label> <br> </td> 
		<td><input type="text" size="30" maxlength="30"  name="id_locacion" value=<%=lista.get(i).getIdLocacion() %> readonly="readonly"> </td>
	</tr>
	<tr>
		<td><label for="Name">Direccion:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="direccion" value=<%=lista.get(i).getDireccion() %>> </td> 
	</tr>
	<tr>
		<td><label for="Name">Codigo Postal:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="codigo" value=<%=lista.get(i).getCodigo()%>> </td> 
	</tr>
	<tr>
		<td><label for="Name">Ciudad:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="ciudad" value=<%=lista.get(i).getCiudad() %>> </td> 
	</tr>
	<tr>
		<td><label for="Name">Estado:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="ciudad" value=<%=lista.get(i).getEstado() %>> </td> 
	</tr>
	<tr>
		<td><label for="Name">Id Pais:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="pais" value=<%=lista.get(i).getPais() %>> </td> 
	</tr>
<%
	}
%>
</table>

	<br>
	<input class="boton_personalizado" type="submit" value="Actualizar" title="Actualizar" alt="Actualizar" style="width:100px; height:25px">
	<input type="hidden" name="opcion" value="actualizar">
	<%
	}
%>
</center>

</body>
</html>