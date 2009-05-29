<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%><%@page
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Construir Proposta</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css">
</head>





<f:view>
	<h:form>

		<div align="center"><h:outputLabel value="CONSTRUIR PROPOSTA"
			styleClass="Titulos" /></div>

		<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
			showSummary="true" />

		<br>
		<h:panelGrid columns="2">
			<rich:panelMenu expandMode="ajax" label="Itens">
				<rich:panelMenuItem label="Missão"
					action="#{construirPropostaBean.prepararMissao}" />
				<rich:panelMenuItem label="Lista de Funções"
					action="#{construirPropostaBean.prepararListaFuncao}" />
				<rich:panelMenuItem label="Justificativa"
					action="#{construirPropostaBean.prepararJustificativa}" />
				<rich:panelMenuItem label="Metodologia"
					action="#{construirPropostaBean.prepararMetodologia}" />
				<rich:panelMenuItem label="Cronograma"
					action="#{construirPropostaBean.prepararCronograma}" />
			</rich:panelMenu>
			

			<rich:simpleTogglePanel label="Dados do cadastro">
				<h:panelGrid columns="1" cellpadding="5" style="width: 798px">
					<h:outputText value="Missão:" />
					<h:inputTextarea style="width: 762px; height: 57px" />

					<h:outputText value="Lista Funções:" />
					<h:inputTextarea style="width: 762px; height: 57px" />

					<h:outputText value="Justificativa:" />
					<h:inputTextarea style="width: 762px; height: 57px" />

					<h:outputText value="Metodologia:" />
					<h:inputTextarea style="width: 762px; height: 57px" />

					<h:outputText value="Cronograma:" />

				</h:panelGrid>
			</rich:simpleTogglePanel>
		</h:panelGrid>

		<h:commandButton value="Salvar" action="#{equipeBean.salvar}" />
		<h:panelGrid columns="1" width="90%" border="0">
			<h:panelGrid columns="1" border="0">
				<h:panelGroup>
					<h:commandButton action="#{equipeBean.prepararBean}"
						value="Ir para o listar propostas" />
				</h:panelGroup>
			</h:panelGrid>
		</h:panelGrid>

	</h:form>

</f:view>