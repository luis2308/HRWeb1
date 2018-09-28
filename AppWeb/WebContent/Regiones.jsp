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
<title>Principal</title> 
</head>
<body>
<center>
<H1>TABLA REGIONES</H1>
<hr color="#FE9A2E" size=5>
<hr color="#1883ba" size=15>
<hr color="#FE9A2E" size=5>
<br>
<h2>Menu Principal</h2>
<form action="<%=request.getContextPath()%>/Region" method="post" >
	<input class="boton_personalizado" type="submit" value="Consultar" title="Consultar Region" alt="Consultar Region" style="width:100px; height:25px">
<input type="hidden" id="consulta" name="opcion" value="consulta">
</form>

<br>

<form action="<%=request.getContextPath()%>/Region" method="post">
	<input class="boton_personalizado" type="submit" value="Actualizar" title="Actualizar Region" alt="Actualizar Region" style="width:100px; height:25px">
<input type="hidden" id="actualiza" name="opcion" value="actualiza">
</form>

<br>

<form action="<%=request.getContextPath()%>/Region" method="post">
	<input class="boton_personalizado" type="submit" value="Alta" title="Alta Region" alt="Alta Region" style="width:100px; height:25px">
<input type="hidden" id="actualiza" name="opcion" value="registra">
</form>

<br>

<form action="<%=request.getContextPath()%>/Region" method="post">
	<input class="boton_personalizado" type="submit" value="Eliminar" title="Eliminar" alt="Eliminar" style="width:100px; height:25px">

<input type="hidden" id="actualiza" name="opcion" value="elimina"></form>
<br>
<form action="<%=request.getContextPath()%>/Region" method="post">
	<input class="boton_personalizado" type="submit" value="Regresar" title="Regresar" alt="Regresar" style="width:100px; height:25px">

<input type="hidden" id="regresa" name="opcion" value="regresa"></form>
</center>
</body>
</html>