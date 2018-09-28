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
	<h1> Alta de Departamento </h1>
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
		<form action="<%=request.getContextPath()%>/funcionPais" method="post">
		<input type="hidden" name="accion" value="alta">
		 <table>
			<tr>
				<td><label for="Name">ID Pais :</label> </td>
				<td><input type="text" size="30" maxlength="30"  name="id_pais" required> </td> 
			</tr>
			<tr>
				<td><label for="Name">Nombre del Pais :</label> </td> 
				<td><input type="text" size="30" maxlength="30"  name="nombre" required> </td> 
			</tr>
			<tr>
				<td><label for="Name">Region:</label> </td> 
				<td><input type="text" size="30" maxlength="30"  name="region" required> </td> 
			</tr>
			</table>
			<input class="boton_personalizado" type="submit" value="Enviar" title="Enviar" alt="Enviar" style="width:100px; height:25px">
		</form>
	</article>
</section>
<footer> </footer>

</body>
</html>