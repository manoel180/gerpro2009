<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Relatórios de Propostas</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css">
</head>

<f:view>
		<div align="center"><h:outputLabel value="RELATÓRIOS EQUIPES X PROPOSTA"
			styleClass="titulo" /></div>

		<h:messages layout="list" styleClass="" showDetail="true"
			showSummary="true" />
		<br>
		<br>
		<h:form>
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados da Consulta">
			<h:panelGrid columns="2" cellpadding="5" id="id1">
				<h:outputText value="Periodo:" />
				<h:inputText id="txtperiodo"
					value="#{relatorioBean.periodo}" required="true">
				</h:inputText>
			</h:panelGrid>
		</rich:simpleTogglePanel>
		<h:commandButton value="Visualizar" action="#{relatorioBean.gerarRelatorioProposta}" />
	</h:form>
</f:view>