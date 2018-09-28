<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Registra</title>
</head>
<body>
<header>
	<center>
	<h1> Alta de empleados </h1>
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
		<form action="<%=request.getContextPath()%>/registraEmpleado" method="post">
		 <table>
			<tr>
				<td><label for="Name">Nombre:</label> </td> 
				<td><input type="text" size="30" maxlength="30"  name="nombre" required> </td> 
			</tr>
			<tr>
				<td><label for="Name">Apellido paterno:</label> </td> 
				<td><input type="text" size="30" maxlength="30"  name="ap_paterno" required> </td> 
			</tr>
			<tr>
				<td><label for="Name">Email:</label> </td> 
				<td><input type="email" size="30" maxlength="30"  name="email" required> </td> 
			</tr>
			<tr>
				<td><label for="Name">Numero telefonico:</label> </td> 
				<td><input type="text" size="30" maxlength="30"  name="num_tel" required></td> 
			</tr>
			<tr>
				<td><label for="Name">Fecha de contrato:</label> </td> 
				<td><input type="text" size="30" maxlength="30"  name="fech_ncont" required> </td> 
			</tr>
			<tr>
				<td><label for="Name">ID del Trabajo</label> </td> 
				<td><input type="text" size="30" maxlength="30"  name="id_trab" required> </td> 
			</tr>
			<tr>
				<td><label for="Name">Salario</label> </td> 
				<td><input type="text" size="30" maxlength="30"  name="salario" required> </td> 
			</tr>
			<tr>
				<td><label for="Name">Comision</label> </td> 
				<td><input type="text" size="30" maxlength="30"  name="comision" required> </td> 
			</tr>
			<tr>
				<td><label for="Name">ID del gerente </label> </td> 
				<td><input type="text" size="30" maxlength="30"  name="id_gerente" required> </td> 
			</tr>
			<tr>
				<td><label for="Name">ID del departamento</label> </td> 
				<td><input type="text" size="30" maxlength="30"  name="id_dep" required> </td> 
			</tr>
			</table>
			<input class="boton_personalizado" type="submit" value="Enviar" title="Enviar" alt="Enviar" style="width:100px; height:25px">
			<input type="hidden" id="registra" name="opcion" value="registra">
		</form>
		</center>
	</article>
</section>

</body>
</html>