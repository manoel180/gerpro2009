<%@page	contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Cadastro de Equipes</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
</head>

<f:view>
	<h:form>
		<div align="center">
		<h:outputLabel value="Alterar Equipes"	styleClass="titulo"/></div>
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro">
			<h:panelGrid columns="5" cellpadding="5">
				<h:outputText value="Nome:" />
				<h:inputText id="txtdesc1"
					value="#{equipeBean.equipe.nome}" /> 
				<h:commandButton value="Salvar" action="#{equipeBean.salvar}" />
			</h:panelGrid>
		</rich:simpleTogglePanel>
	</h:form>
</f:view>