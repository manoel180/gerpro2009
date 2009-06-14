<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Cronograma</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css">
</head>


<f:view>
	<div align="center"><h:outputLabel value="CRONOGRAMA"
		styleClass="Titulos" /></div>

	<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
		showSummary="true" />

	<br>

	<h:panelGrid columns="5">
		<%@ include file="menu.jsp"%>
		<rich:simpleTogglePanel width="600px" label="Dados do cadastro">
			<h:form id="form2">
				<rich:dataTable id="idtable" var="lstCronograma"
					value="#{corrigirPropostaBean.lstCronograma}"
					rows="10"
					width="550px" align="center">
					<rich:column sortBy="#{lstCronograma.dataInicial}">
						<f:facet name="header">
							<h:outputText value="Data Inicial" />
						</f:facet>
						<h:outputText value="#{lstCronograma.dataInicial}">
							<f:convertDateTime dateStyle="short" type="date"
								pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column sortBy="#{lstCronograma.dataFinal}">
						<f:facet name="header">
							<h:outputText value="Data Final" />
						</f:facet>
						<h:outputText value="#{lstCronograma.dataFinal}">
							<f:convertDateTime dateStyle="short" type="date"
								pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column width="5%" sortBy="#{lstCronograma.artefatos.nome}">
						<f:facet name="header">
							<h:outputText value="Eventos/Artefatos" />
						</f:facet>
						<h:outputText value="#{lstCronograma.artefatos.nome}" />
					</rich:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="Opções"></h:outputText>
						</f:facet>

					</h:column>
				</rich:dataTable>
			</h:form>
		</rich:simpleTogglePanel>
	</h:panelGrid>
	<br>
	<h:form>
		<%@ include file="../common/bannerCorrigirPropostaEquipe.jsp"%>
		<%@ include file="perguntasCorrecao.jsp"%>
		<h:commandButton value="Salvar"
			action="#{corrigirPropostaBean.salvarCorrigirMissao}"
			disabled="#{corrigirPropostaBean.desabilitar}" />
	</h:form>

</f:view>