<%@page contentType="text/html"%> <%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Submeter Proposta</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css" href="WEB-INF/css/estilos.css">
</head>

<f:view>
	<h:form>

		<div align="center"><h:outputLabel value="SUBMETER CORREÇÃO"
			styleClass="titulo" /></div>

		<h:messages layout="list" styleClass="Obrigatorio" showDetail="true"
			showSummary="true" />
		<br>
		<br>
		<rich:dataTable var="correcoes" id="listaCorrecao"
			value="#{submeterCorrecaoBean.listaCorrecao}"
			binding="#{submeterCorrecaoBean.objDatatableCorrecao}" rows="10"
			width="550px" align="center">
			<h:column>
				<f:facet name="header">
					<h:outputText value="Pergunta"></h:outputText>
				</f:facet>
				<h:outputText value="#{correcoes.pergunta.descricao}"></h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Resposta"></h:outputText>
				</f:facet>
				<h:outputText value="#{correcoes.resposta.descricao}"
					style="color:red; font-weight:bold; font-"></h:outputText>
			</h:column>			
			<h:column>
				<f:facet name="header">
					<h:outputText value="Status"></h:outputText>
				</f:facet>
				<h:outputText value="#{correcoes.status.nome}"
					style="color:red; font-weight:bold; font-"></h:outputText>
			</h:column>

		</rich:dataTable>

		<h:commandButton value="Visualizar"
			action="#{submeterCorrecaoBean.prepararBean}" />
		<h:commandButton value="Submeter Correção"		
			action="#{submeterCorrecaoBean.prepararBean}" style=" width : 142px;"/> <h:commandButton action="#{propostaBean.prepararBean}" value="Ir para o listar propostas" />
		<br>

		<rich:simpleTogglePanel label="Informações">		
			<h:panelGrid columns="4" cellpadding="5">
				<h:outputLabel value="Nome:"/>
				<h:outputLabel value="#{submeterCorrecaoBean.equipe.nome}" />
				
				<h:outputLabel value="Data Limite:"/>
				<h:outputLabel value="#{submeterCorrecaoBean.proposta.dataSubmissao}" />
				
				<h:outputLabel value="Componentes:"/>
				<h:inputTextarea value="#{submeterCorrecaoBean.listaUsuarios.Usuario.nome}" readonly="true" />
				
				<h:outputLabel value="Status:"/>
				<h:outputLabel value="#{submeterCorrecaoBean.propitem.status.nome}" />
				
			</h:panelGrid>
		</rich:simpleTogglePanel>
	</h:form>
</f:view>