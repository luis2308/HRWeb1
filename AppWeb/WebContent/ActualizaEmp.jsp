<%@ page import = "java.util.LinkedList"%>
<%@ page import="mx.indexpro.hr.webapp.vo.EmpleadoVO" %>
<%@ page import= "mx.indexpro.hr.webapp.dao.DAOInsertar" %>
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
<title>Actualizar</title>

</head>
<body>

<center>
<h1> Actualizar empleados </h1>
<hr color="#FE9A2E" size=5>
		<hr color="#1883ba" size=15>
		<hr color="#FE9A2E" size=5>
<a href="/HRWebPrueba2">Menu</a>
<form action="<%=request.getContextPath()%>/registraEmpleado" method="post">

<table>
	<tr>
		<td><label for="Name">ID del Empleado:</label> <br> </td> 
		<td><input type="text" size="30" maxlength="30"  name="id_emp" > </td>
	</tr>
</table>
	 <input class="boton_personalizado" type="submit" value="Buscar" title="Buscar" alt="Buscar" style="width:100px; height:25px">
<input type="hidden" name="opcion" value="busca">
</form>

		
<%LinkedList<EmpleadoVO> lista = (LinkedList<EmpleadoVO>)request.getAttribute("listaEmpleado"); %>		

<form action="<%=request.getContextPath()%>/registraEmpleado" method="post">
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
	<tr>
		<td><label for="Name">Fecha:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="fech_ncont" value=<%=lista.get(i).getFechaContratacion() %>></td> 
	</tr>
	<tr>
		<td><label for="Name">Puesto_Id:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="id_trab" value=<%=lista.get(i).getIdPuesto() %>></td> 
	</tr>
	<tr>
		<td><label for="Name">Salario:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="salario" value=<%=lista.get(i).getSalario() %>></td> 
	</tr>
	<tr>
		<td><label for="Name">Comision:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="comision" value=<%=lista.get(i).getComision() %>></td> 
	</tr>
	<tr>
		<td><label for="Name">Superior:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="id_gerente" value=<%=lista.get(i).getIdSuperior() %>></td> 
	</tr>
	<tr>
		<td><label for="Name">Departamento:</label> </td> 
		<td><input type="text" size="30" maxlength="30"  name="id_dep" value=<%=lista.get(i).getIdDepartamento() %>></td> 
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