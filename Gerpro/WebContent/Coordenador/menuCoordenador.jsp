<%@page	contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<link href="/css/estilos.css" rel="stylesheet" type="text/css" />
</head>
<body>


<h:form>

	<h:panelGrid columns="1">

		<h:commandLink value="Tela Inicial" action="homeCoordenador" />


		<!-- <a href="listar.htm?method=alunos" class="categorylink">ManterAluno</a>


		<a href="listar.htm?method=professores" class="categorylink">Manter
		Professores</a> -->

		<h:commandLink value="Manter Propostas" action="go_altproposta" />

		<!--  <a href="alocarPropostas.htm" class="categorylink">Alocar
		Propostas</a>

		<a href="relatorios.htm" class="categorylink">Relatórios</a>

		<a href="login.htm?method=remove" class="categorylink">Logoff</a>
		-->

	</h:panelGrid>
	</h:form>

</body>
