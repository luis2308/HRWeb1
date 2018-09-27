<%@ page import = "java.util.LinkedList"%>
<%@ page import="mx.indexpro.hr.webapp.vo.EmpleadoVO" %>
<%@ page import= "mx.indexpro.hr.webapp.dao.DAOInsertar" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%LinkedList<EmpleadoVO> lista = (LinkedList<EmpleadoVO>)request.getAttribute("listaEmpleado"); %>
		
		

<form action="<%=request.getContextPath()%>/registraEmpleado" method="post">
<table>
<% 
for (int i=0;i<lista.size();i++)
{
		
		
		
%>
	<tr>
		<td><label for="Name">ID del Empleado:</label> <br> </td> 
		<td><input type="text" size="30" maxlength="30"  name="id_empleado" value=<%=lista.get(i).getIdEmpleado() %> readonly="readonly"> </td>
	</tr>
	<tr>
		<td><label for="Name">Nombre:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="nombre" value=<%=lista.get(i).getNombre() %>> </td> 
	</tr>
	<tr>
		<td><label for="Name">Apellido paterno:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="ap_paterno" value=<%=lista.get(i).getApellido() %>> </td> 
	</tr>
	<tr>
		<td><label for="Name">Email:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="email" value=<%=lista.get(i).getEmail() %>> </td> 
	</tr>
	<tr>
		<td><label for="Name">Numero telefonico:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="num_tel" value=<%=lista.get(i).getTelefono() %>></td> 
	</tr>
	<%
	}
%>
</table>

	<br>
	<input type="submit" value="Actualizar" title="Actualizar" alt="Actualizar" style="width:100px; height:25px">
</body>
</html>