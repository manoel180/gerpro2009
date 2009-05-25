<%@page	contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Cadastro de Propostas</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css" href="WEB-INF/css/estilos.css">
</head>

<f:view>
	<h:form>

		<div align="center"><h:outputLabel value="ALTERAR DE PROPOSTAS"
			styleClass="titulo" /></div>

		<h:messages layout="list" styleClass="Obrigatorio" showDetail="true"
			showSummary="true" />
		<br>
		<br>
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro">
			<h:panelGrid columns="2" cellpadding="5" style="height: 103px">
				<h:outputText value="Nome:" />
				<h:inputText id="txtdesc1" required="true"
					value="#{propostaBean.proposta.nome}">
					<f:attribute name="fieldRef" value="Proposta" />
				</h:inputText>
				
				<h:outputText value="Equipe:" />
				<h:selectOneMenu id="equipe" value="#{propostaBean.equipe.id}" rendered="true" required="true">					
					<f:selectItems value="#{propostaBean.equipesCombo}"/>	
				</h:selectOneMenu>

				<h:outputText value="Status:" />
				<h:selectOneMenu value="#{propostaBean.status.id}">					
					<f:selectItems value="#{propostaBean.statusCombo}"/>	
				</h:selectOneMenu>
			</h:panelGrid>

		</rich:simpleTogglePanel>
<h:commandButton value="Salvar" action="#{propostaBean.alterar}" />
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