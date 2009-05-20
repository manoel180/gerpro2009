<%@page contentType="text/html"%> <%@page pageEncoding="UTF-8"%> <%@
taglib prefix="f" uri="http://java.sun.com/jsf/core"%> <%@ taglib
prefix="h" uri="http://java.sun.com/jsf/html"%> <%@taglib
uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<link href="/css/estilos.css" rel="stylesheet" type="text/css" />
<ui:insert name="titulo"></ui:insert>
</head>

<h:form>
	<tr>
		<h3>Missão do Produto</h3>
	</tr>
	<table>

		<tr>
			<h:inputTextarea rows="10" cols="70">
			</h:inputTextarea>

		</tr>
		<tr>
			<td><h:commandButton value="Salvar" action="Submit"></h:commandButton>
			<h:commandButton value="Concluir" action="Submit"></h:commandButton>
			</td>
		</tr>

	</table>

</h:form>



