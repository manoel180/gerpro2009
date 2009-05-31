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
	<h:form>

		<div align="center"><h:outputLabel value="CRONOGRAMA"
			styleClass="Titulos" /></div>

		<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
			showSummary="true" />

		<br>
		
		<h:panelGrid columns="3">	
		<%@ include file="../templates/menu.jsp" %>			

			<rich:simpleTogglePanel label="Dados do cadastro">
				<h:panelGrid columns="1" cellpadding="5" style="width: 798px">
					
					<h:outputText value="Data Inicial" />
					<rich:calendar id="dt_Inicio" value="#{construirPropostaBean.cronograma.dataInicial}"/>
					
					
					<h:outputText value="Data Final:" />
					<rich:calendar id="dt_Fim" value="#{construirPropostaBean.cronograma.dataFinal}"/>
						
					<h:outputText value="Artefato:" />
					<h:selectOneMenu value="#{construirPropostaBean.artefatos.id}" >					
						<f:selectItems value="#{construirPropostaBean.artefatosCombo}"/>	
					</h:selectOneMenu>
					
					<h:commandButton value="Adicionar" action="#{construirPropostaBean.addcronograma}"/>
					
				</h:panelGrid>
			</rich:simpleTogglePanel>
		</h:panelGrid>

		<rich:dataTable id="idtable" var="lstArt" value="#{construirPropostaBean.lstArtefatos}" binding="#{construirPropostaBean.objDatatableArtefatos}" rows="10" width="550px" align="center">
				<h:column>
					<f:facet name="header">
						<h:outputText value="Artefato"></h:outputText>
					</f:facet>
					<h:outputText value="#{lstArt.nome}"></h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Data Inicio"></h:outputText>
					</f:facet>
					<rich:calendar id="dt_Inicio" value="#{construirPropostaBean.cronograma.dataInicial}"/>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Data Final"></h:outputText>
					</f:facet>
					<rich:calendar id="dt_Fim" value="#{construirPropostaBean.cronograma.dataFinal}"/>
				</h:column>

				
			</rich:dataTable>
			<br><br>
			<h:commandButton value="Salvar" action="#{construirPropostaBean.SalvarCronograma}" />
		<h:panelGrid columns="1" width="90%" border="0">
			<h:panelGrid columns="1" border="0">
				<h:panelGroup>
					<h:commandButton action="#{propostaBean.prepararBean}"
						value="Ir para o listar propostas" />
				</h:panelGroup>
			</h:panelGrid>
		</h:panelGrid>

	</h:form>

</f:view>