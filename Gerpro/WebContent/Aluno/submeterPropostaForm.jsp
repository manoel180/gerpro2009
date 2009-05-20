<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<link href="/css/estilos.css" rel="stylesheet" type="text/css" />
<ui:insert name="titulo"></ui:insert>
</head>

<h:form>
	<tr>
		<h3>Submeter Proposta</h3>
	</tr>
	<table>
		<tr>
			<table border="1">
				<tr>
					<th>Itens</th>
					<th>Status</th>
				</tr>
				<tr>
					<th><input type="text" value="Missao do produto" /></th>
					<td><input type="text" value="" /></td>
				</tr>

				<tr>
					<td><input type="text" value="Lista de Funcões" /></td>
					<td><input type="text" value="" /></td>
				</tr>

				<tr>
					<td><input type="text" value="Justificativa" /></td>
					<td><input type="text" value="" /></td>
				</tr>

				<tr>
					<td><input type="text" value="Metodologia" /></td>
					<td><input type="text" value="" /></td>
				</tr>

				<tr>
					<td><input type="text" value="Cronograma" /></td>
					<td><input type="text" value="" /></td>
				</tr>

			</table>
		<tr>
			<a href="submeterProposta.htm" onclick="submit()">Submeter</a>
		</tr>
	</table>
</h:form>




