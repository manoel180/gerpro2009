<%@page	contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Cadastro de Propostas</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
</head>

<f:view>
	<h:form>

		<div align="center"><h:outputLabel value="CADASTRO DE PROPOSTAS"
			styleClass="titulo" /></div>

		<h:messages layout="list" styleClass="" showDetail="true"
			showSummary="true" />
		<br>
		<br>
		<rich:toolTip for="txtdesc1" followMouse="true" zorder="90" value="Inserir um nome da Proposta"/>
		<rich:toolTip for="equipe" followMouse="true" zorder="90" value="Selecione uma equipe"/>
		<rich:toolTip for="dt_criacao" followMouse="true" zorder="90" value="Inserir uma data de Criação da Proposta"/>
		<rich:toolTip for="txtperiodo" followMouse="true" zorder="90" value="Inserir um Periodo"/>
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro">
			<h:panelGrid columns="2" cellpadding="5" id="id1">
				<h:outputText value="Nome:" />
				<h:inputText id="txtdesc1" required="true"
					value="#{propostaBean.proposta.nome}">
					<f:attribute name="fieldRef" value="Nome" />
				</h:inputText>
				
				<h:outputText value="Equipe:" />
				<h:selectOneMenu id="equipe" value="#{propostaBean.equipe.id}" rendered="true">					
					<f:selectItems value="#{propostaBean.equipesCombo}"/>
					<f:attribute name="fieldRef" value="Equipe" />	
				</h:selectOneMenu>
				
				<h:outputText value="Data Criação:" />	
				
				<rich:calendar id="dt_criacao" value="#{propostaBean.proposta.dataCriacao}" required="true">
					<f:attribute name="fieldRef" value="Data Criação" />
				</rich:calendar>
	
				<h:outputText value="Periodo:" />
				<h:inputText id="txtperiodo" value="#{propostaBean.proposta.periodo}" required="true">
					<f:attribute name="fieldRef" value="Período" />
				</h:inputText>
				
			</h:panelGrid>

			

		</rich:simpleTogglePanel>
			<h:commandButton value="Salvar" action="#{propostaBean.salvar}" />
	</h:form>
	<h:form>
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