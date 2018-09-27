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
	<h1> Alta de Locacion </h1>
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
		<form action="<%=request.getContextPath()%>/funcionLocacion" method="post">
<input type="hidden" name="opcion" value="registra">
<table>
			<tr>
				<td colspan="2"><%=request.getAttribute("MSG")%></td>
			</tr>
			<tr>
				<td>Direccion:</td>
				<td><input type="text" name="direccion"></td>
			</tr>
			<tr>
				<td> Codigo:</td>
				<td><input type="text" name="codigo"></td>
			</tr>
			<tr>
				<td>Ciudad:</td>
				<td><input type="text" name="ciudad"></td>
			</tr>
			<tr>
				<td>Estado:</td>
				<td><input type="text" name="estado"></td>
			</tr>

			<tr>
				<td>Pais:</td>
				<td><input type="text" name="pais"></td>
			</tr>
			
		<br>
			<tr>
				<td class="boton_personalizado" align="right"><input type="submit" value="Guardar"></td>
			</tr>
		</table>
 
</form> 

<br>
</center>
</body>
</html>