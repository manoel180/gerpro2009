<%@page pageEncoding="ISO-8859-1"%>
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
          <!-- rint dos botoes calendario data inicio e fim -->
       <rich:toolTip for="dt_Fim" followMouse="true" zorder="90" value="Inserir uma data final"/>
       <rich:toolTip for="dt_Inicio" followMouse="true" zorder="90" value="Inserir uma data de Inicio"/>
	   				
	<div align="center"><h:outputLabel value="CRONOGRAMA"
		styleClass="Titulos" /></div>

	<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
		showSummary="true" />

	<br>

	<h:panelGrid columns="5">
		<%@ include file="menu.jsp"%>
		<rich:simpleTogglePanel  width="600px" label="Dados do cadastro">
			<h:form id="form1">
				<h:panelGrid columns="1">

					
					<h:outputText value="Data Inicial" />
					<rich:calendar id="dt_Inicio"
						value="#{construirPropostaBean.cronograma.dataInicial}"
						direction="auto" firstWeekDay="1" popup="true"
						showWeekDaysBar="true" showWeeksBar="false"
						todayControlMode="scroll" datePattern="dd/M/yyyy"
						showHeader="true" limitToList="true" locale="pt"
						minDaysInFirstWeek="6" required="true">
						<f:attribute name="fieldRef" value="Data Inicial" />
					</rich:calendar>

					
					<h:outputText value="Data Final:" />
					<rich:calendar id="dt_Fim"
						value="#{construirPropostaBean.cronograma.dataFinal}"
						direction="auto" firstWeekDay="1" popup="true"
						showWeekDaysBar="true" showWeeksBar="false"
						todayControlMode="scroll" datePattern="dd/M/yyyy"
						showHeader="true" limitToList="true" locale="pt"
						minDaysInFirstWeek="6" />
						
					<rich:toolTip for="art" followMouse="true" zorder="90"
						value="Selecione um artefato"/>
					<h:outputText value="Artefato:" />
					<h:selectOneMenu id="art" value="#{construirPropostaBean.artefatos.id}">
						<f:selectItems value="#{construirPropostaBean.artefatosCombo}" />
					</h:selectOneMenu>
					<rich:toolTip for="btnAdicionar" followMouse="true" zorder="90"
						value="Adicionar na lista Cronograma"/>
					<h:commandButton id="btnAdicionar" value="Adicionar"
						action="#{construirPropostaBean.addCronograma}" />

				</h:panelGrid>
			</h:form>
		</rich:simpleTogglePanel>

	</h:panelGrid>
	<h:form id="form2">
		<rich:dataTable id="idtable" var="lstCronograma"
			value="#{construirPropostaBean.lstCronograma}"
			binding="#{construirPropostaBean.objDatatableCronograma}" rows="10"
			width="550px" align="center">
			<rich:column sortBy="#{lstCronograma.dataInicial}">
				<f:facet name="header">
					<h:outputText value="Data Inicial" />
				</f:facet>
				<h:outputText value="#{lstCronograma.dataInicial}" >
				<f:convertDateTime dateStyle="short" type="date" pattern="dd/MM/yyyy"/>
				</h:outputText>
			</rich:column>

			<rich:column sortBy="#{lstCronograma.dataFinal}">
				<f:facet name="header">
					<h:outputText value="Data Final" />
				</f:facet>
				<h:outputText value="#{lstCronograma.dataFinal}" >
					<f:convertDateTime dateStyle="short" type="date" pattern="dd/MM/yyyy"/>
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
				<!-- rint botao alterar -->
				<rich:toolTip for="btnalterar" followMouse="true" zorder="90" value="Alterar"/>
				<h:commandButton image="/images/editar.png" id="btnalterar"
					action="#{construirPropostaBean.editCronograma}"
					style="height: 40px; width: 40px"></h:commandButton>
			</h:column>
		</rich:dataTable>
		<div=align="right" style=" width : 864px;">
	<h:commandButton value="Salvar" id="btnsalvar" action="#{construirPropostaBean.SalvarCronograma}" />
	</div>
	</h:form>
	
	<br>
	<h:form>
	     <!-- rint botao alterar -->
		<rich:toolTip for="btnsalvar" followMouse="true" zorder="90" value="Clique para salvar"/>
		
	</h:form>
	<%@ include file="../common/bannerPropostaEquipe.jsp"%>
</f:view>