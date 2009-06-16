<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<link href="../css/estilos.css" rel="stylesheet" type="text/css" />
</head>
<body>

<h:form>
	<table>
		<tr>
			<td align="left" valign="top" class="txt1"
				style="padding-left: 12px;"><h:commandLink
				value="Lista de Propostas"
				action="#{propostaBean.listaPorProfessor}"></h:commandLink></td>
		</tr>
		
		<tr>
			<td align="left" valign="top" class="txt1"
				style="padding-left: 12px;"><h:commandLink value="Logoff"
				action="index.jsf"></h:commandLink></td>
		</tr>

	</table>

</h:form>

</body>