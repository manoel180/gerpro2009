<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib
	uri="http://richfaces.org/rich" prefix="rich1"%><%@page	contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Cadastro de Propostas</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
</head>

<f:view>
	<h:form>

		<div align="center"><h:outputLabel value="RELATÓRIOS"
			styleClass="titulo" /></div>

		<h:messages layout="list" styleClass="" showDetail="true"
			showSummary="true" />
		<br>
		<br>
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro">
			<rich:panel focus="txtdesc1" label="Dados do cadastro" >
				<h:outputText value="Equipe:" />
				<h:inputText id="txtdesc1" required="true"
					value="#{}">
					<f:attribute name="fieldRef" value="Proposta" />
				</h:inputText>
						
			</rich:panel>
			<h:panelGrid columns="2" cellpadding="5" id="id1">
				<h:outputText value="Nome:" />
				<h:inputText id="txtdesc1" required="true"
					value="#{propostaBean.proposta.nome}">
					<f:attribute name="fieldRef" value="Proposta" />
				</h:inputText>
				
				<h:outputText value="Equipe:" />
				<h:selectOneMenu id="equipe" value="#{propostaBean.equipe.id}" rendered="true" required="true">					
					<f:selectItems value="#{propostaBean.equipesCombo}"/>
					<f:attribute name="fieldRef" value="Equipe" />	
				</h:selectOneMenu>
				
				<h:outputText value="Data Inicio:" />	
				<rich1:calendar id="dt_criacao" value="#{propostaBean.proposta.dataCriacao}" required="true">
					<f:attribute name="fieldRef" value="Data Criação" />
				</rich1:calendar>
	
				<h:outputText value="Periodo:" />
				<h:inputText id="txtperiodo" value="#{propostaBean.proposta.periodo}">
					<f:attribute name="fieldRef" value="P" />
				</h:inputText>
				
			</h:panelGrid>

			

		</rich:simpleTogglePanel>
<h:commandButton value="Salvar" action="#{propostaBean.salvar}" />
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