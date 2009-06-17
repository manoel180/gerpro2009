<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Relatórios de Propostas</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css">
</head>

<f:view>
	<div align="center"><h:outputLabel
		value="RELATÓRIOS RESULTADO DAS PROPOSTAS" styleClass="titulo" /></div>

	<h:messages layout="list" showDetail="true" showSummary="true" />
	<br>
	<br>
	<h:form>
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados da Consulta">
			<h:panelGrid columns="2" id="id1">
				<h:outputText value="Periodo:" />
				<h:selectOneMenu id="combo"
					value="#{relatorioBean.proposta.periodo}">
					<f:selectItems value="#{relatorioBean.periodoCombo}" />
				</h:selectOneMenu>
			</h:panelGrid>
			<a4j:mediaOutput element="img" cacheable="false" session="true"
				createContent="#{relatorioBean.paint}" value="#{relatorioBean.imagen}"
				mimeType="image/jpeg" />
		</rich:simpleTogglePanel>
		<h:commandButton value="Visualizar"
			action="#{relatorioBean.prepararBean}" />


	</h:form>
</f:view>