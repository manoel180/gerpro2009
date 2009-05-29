<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Missão</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css">
	
	
</head>





<f:view>
	<h:form>

		<div align="center"><h:outputLabel value="MISSÃO PROPOSTA"
			styleClass="Titulos" /></div>

		<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
			showSummary="true" />

		<br>
		
		<h:panelGrid columns="3">	
		<%@ include file="../templates/menu.jsp" %>			

			<rich:simpleTogglePanel label="Dados do cadastro">
				<rich:suggestionbox height="200" width="200" title="teste" value="teste"></rich:suggestionbox>
				<h:panelGrid columns="1" cellpadding="5" style="width: 798px">
					<h:outputText value="Missão:" />
					<h:inputTextarea cols="20" rows="10" tabindex="20"  style="width: 759px"/>
				</h:panelGrid>
			</rich:simpleTogglePanel>
		</h:panelGrid>

		
		<h:panelGrid columns="1" width="90%" border="0">
			<h:panelGrid columns="1" border="0">
				<h:panelGroup>
					<h:commandButton value="Salvar" action="#{construirPropostaBean.teste}" />
					<h:commandButton action="#{equipeBean.prepararBean}"
						value="Ir para o listar propostas" />
				</h:panelGroup>
			</h:panelGrid>
		</h:panelGrid> 

	</h:form>

</f:view>