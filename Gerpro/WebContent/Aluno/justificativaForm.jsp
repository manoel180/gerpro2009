justificativaForm.jsp
<head>
<link href="/css/estilos.css" rel="stylesheet" type="text/css" />
<ui:insert name="titulo"></ui:insert>
</head>

<h:form>
	<tr>
		<h3>Justificativa</h3>
	</tr>
	<table>

		<tr>
			<h:inputTextarea rows="10" cols="70">
			</h:inputTextarea>

		</tr>
		<tr>
			<td><h:commandButton value="Salvar" action="Submit" /> <h:commandButton
				value="Concluir" action="Submit" /></td>
		</tr>

	</table>

</h:form>

