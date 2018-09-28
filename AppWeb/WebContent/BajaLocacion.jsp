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
	<h1> Elimina Locacion </h1>
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
<!--en este se crea el hidden que redirecciona a la parte del servlet de eliminar formulario-->
<input type="hidden" name="opcion" value="elimina">
		<table align="center">
			<tr>
				<td>Ingrese el Id:</td>
				<td><input name="location_id" type="text" size="35" maxlength="35">
			</tr>
			</table>
			<br>

  <input  class="boton_personalizado" type="submit" value="Enviar" title="Enviar" alt="Enviar" style="width:100px; height:25px">
</form>
<br>
	</CENTER>

</body>
</html>