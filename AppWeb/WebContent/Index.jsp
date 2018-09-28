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
		<H1>BIENVENIDOS A LA BASE DE DATOS HR</H1>
		<hr color="#FE9A2E" size=5>
		<hr color="#1883ba" size=15>
		<hr color="#FE9A2E" size=5>
		<table>
			<th colspan=2><h2>Menu Principal</h2></th>
			<tr>
				<form action="<%=request.getContextPath()%>/inicio" method="post">
					<h3>
						<td>T.Paises:</td>
						<td><input class="boton_personalizado" type="submit" name="paises" value="Click me" title="Pasises"
							alt="Paises"></td>
					</h3>
					
					<input type="hidden" id="paises" name="opcion" value="paises">
				</form>
			</tr>

			<tr>
				<form action="<%=request.getContextPath()%>/inicio"
					method="post">
					<h3>
						<td>T.Empleados:</td>
						<td><input class="boton_personalizado" type="submit" name="empleados" value="Click me" title="Empleados"
							alt="Empleados"></td>
					</h3>
					<input type="hidden" id="empleados" name="opcion" value="empleados">
				</form>
			</tr>

			<tr>
				<form action="<%=request.getContextPath()%>/inicio"
					method="post">

					<h3>
						<td>T.Departamentos:</td>
						<td><input class="boton_personalizado" type="submit" value="Click me"
							title="Departamentos" alt="Departamentos"></td>
							<input type="hidden" id="departamento" name="opcion" value="departamento">
					</h3>
				</form>
			</tr>

			<tr>
				<form action="<%=request.getContextPath()%>/inicio"
					method="post">
					<h3>
						<td>T.Puesto:</td>
						<td><input class="boton_personalizado" type="submit" value="Click  me" title="Puesto"
							alt="Puesto"></td>
							<input type="hidden" id="puesto" name="opcion" value="puesto">
					</h3></form></tr>
					<tr>
					<form action="<%=request.getContextPath()%>/inicio" method="post">
					<h3>
						<td>T.Localidades:</td>
						<td><input class="boton_personalizado" type="submit" value="Click  me" title="localidad"
							alt="Puesto"></td>
							<input type="hidden" id="locaciones" name="opcion" value="locaciones">
					</h3></form></tr>
					<tr>
					<form action="<%=request.getContextPath()%>/inicio"  method="post">
					<h3>
						<td>T.Regiones:</td>
						<td><input class="boton_personalizado" type="submit" value="Click  me" title="Region"
							alt="Puesto"></td>
							<input type="hidden" id="regiones" name="opcion" value="regiones">
					</h3>
				</form>
			</tr>
		</table>
	</center>

</body>
</html>