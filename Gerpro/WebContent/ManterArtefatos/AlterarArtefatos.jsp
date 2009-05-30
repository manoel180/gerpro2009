<%@page	contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Cadastro de Artefatos</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css" href="WEB-INF/css/estilos.css">
</head>

<f:view>
	<h:form>
		<div align="center"><h:outputLabel value="Alterar Equipes"	styleClass="titulo"/></div>
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro">
			<h:panelGrid columns="5" cellpadding="5">
				<h:outputText value="Nome:" />
				<h:inputText id="txtdesc1"
					value="#{artefatosBean.artefatos.nome}" /> 
				<h:commandButton value="Salvar" action="#{artefatosBean.alterar}" 
				style="background-color:#D2691E;color:#FFFFFF; font-weight:bold;border: 1px outset"/>
			</h:panelGrid>
		</rich:simpleTogglePanel>
	
		<h:panelGrid columns="1" width="90%" border="0">
			<h:panelGrid columns="1" border="0">
				<h:panelGroup>
					<h:commandButton action="#{artefatosBean.prepararBean}"
						value="Ir para a lista de equipes" />
						
						</h:panelGroup>
			</h:panelGrid>
		</h:panelGrid>
	</h:form>
</f:view>