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
					<rich:calendar  id="dt_Inicio" value="#{construirPropostaBean.cronograma.dataInicial}" 
					direction="auto" firstWeekDay="1" popup="true" showWeekDaysBar="true" showWeeksBar="false"
					 todayControlMode="scroll" datePattern="dd/M/yyyy"  showHeader="true" limitToList="true" 
					 locale="pt" minDaysInFirstWeek="6" />
					
					
					<h:outputText value="Data Final:" />
					<rich:calendar id="dt_Fim" value="#{construirPropostaBean.cronograma.dataFinal}"/>
						
					<h:outputText value="Artefato:" />
					<h:selectOneMenu value="#{construirPropostaBean.artefatos.id}" >					
						<f:selectItems value="#{construirPropostaBean.artefatosCombo}"/>	
					</h:selectOneMenu>
					
					<h:commandButton value="Adicionar" action="#{construirPropostaBean.addCronograma}"/>
					
				</h:panelGrid>
			</rich:simpleTogglePanel>
		</h:panelGrid>

		<rich:dataTable id="idtable" var="lstCronograma" value="#{construirPropostaBean.lstCronograma}" binding="#{construirPropostaBean.objDatatableCronograma}" rows="10" width="550px" align="center">
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Data Inicial"></h:outputText>
					</f:facet>
					<h:outputText value="#{lstCronograma.dataInicial}" style="color:red; font-weight:bold; font-"></h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Data Final"></h:outputText>
					</f:facet>
					<h:outputText value="#{lstCronograma.dataFinal}" style="color:red; font-weight:bold; font-"></h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Eventos/Artefatos"></h:outputText>
					</f:facet>
					<h:outputText value="#{lstCronograma.artefatos.nome}" style="color:red; font-weight:bold; font-"></h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Opções"></h:outputText>
					</f:facet>
					<h:commandButton image="/images/delete.png" action="#{construirPropostaBean.delCronograma}" style="height: 40px; width: 40px"></h:commandButton>
					<h:commandButton image="/images/editar.png" action="#{construirPropostaBean.editCronograma}" style="height: 40px; width: 40px"></h:commandButton>
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