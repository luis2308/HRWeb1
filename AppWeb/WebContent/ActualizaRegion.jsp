<%@ page import = "java.util.LinkedList"%>
<%@ page import="mx.indexpro.hr.webapp.vo.RegionVO" %>
<%@ page import= "mx.indexpro.hr.webapp.dao.DAORegion" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><style type="text/css">
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

<center>
<h1> Actualizar Region </h1>
<hr color="#FE9A2E" size=5>
		<hr color="#1883ba" size=15>
		<hr color="#FE9A2E" size=5>
<a href="/HRWebPrueba2">Menu</a>
<form action="<%=request.getContextPath()%>/funcionRegion" method="post">

<table>
	<tr>
		<td><label for="Name">ID Region:</label> <br> </td> 
		<td><input type="text" size="30" maxlength="30"  name="id_region" > </td>
	</tr>
</table>
	 <input class="boton_personalizado" type="submit" value="Buscar" title="Buscar" alt="Buscar" style="width:100px; height:25px">
<input type="hidden" name="opcion" value="busca">
</form>

		
<%LinkedList<RegionVO> lista = (LinkedList<RegionVO>)request.getAttribute("lista"); %>		

<form action="<%=request.getContextPath()%>/funcionRegion" method="post">
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
		<td><label for="Name">ID Region:</label> <br> </td> 
		<td><input type="text" size="30" maxlength="30"  name="id_region" value=<%=lista.get(i).getId_Regions() %> readonly="readonly"> </td>
	</tr>
	<tr>
		<td><label for="Name">Nombre Region:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="nom_region" value=<%=lista.get(i).getNombre_Region() %>> </td> 
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