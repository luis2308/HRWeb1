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
<center>
<H1>TABLA PAISES</H1>
<hr color="#FE9A2E" size=5>
<hr color="#1883ba" size=15>
<hr color="#FE9A2E" size=5>
<br>
<h2>Menu Principal</h2>
<form action="<%=request.getContextPath()%>/pais "method="post">
	<input class="boton_personalizado" type="submit" title="Consultar Paises" alt="Consultar Paises" value="Consulta" style="width:100px; height:25px" >
	<input type="hidden" id="consulta" name="opcion" value="consulta">
	</form>
		<br>

		<form action="<%=request.getContextPath()%>/pais"method="post">
		<input type="hidden" name="opcion" value="registra">
			<input class="boton_personalizado" type="submit" title="Insertar Pais" alt="Insertar Paises" value="inserta" style="width:100px; height:25px">
		</form>
		<br>
		
		<form action="<%=request.getContextPath()%>/pais" method="post">
		<input type="hidden" name="opcion" value="elimina">
			<input class="boton_personalizado" type="submit" title="Eliminar Pais" alt="Eliminar Pais" value="eliminar" style="width:100px; height:25px">
		</form>

		<br>
		<form action="<%=request.getContextPath()%>/pais" method="post">
		<input type="hidden" name="opcion" value="actualiza">
			<input class="boton_personalizado" type="submit" title="Actualizar Pais" alt="Actualizar Pais" value="actualizar" style="width:100px; height:25px">
		</form>
		<br>
<form action="<%=request.getContextPath()%>/pais" method="post">
	<input class="boton_personalizado" type="submit" value="Regresar" title="Regresar" alt="Regresar" style="width:100px; height:25px">

<input type="hidden" id="regresa" name="opcion" value="regresa"></form>
		</center>
</body>
</html>