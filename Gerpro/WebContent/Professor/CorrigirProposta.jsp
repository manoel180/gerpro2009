<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Construir Proposta</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css">
</head>

<f:view>
	<h:form>

		<div align="center"><h:outputLabel value="CORRIGIR PROPOSTA"
			styleClass="Titulos" /></div>

		<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
			showSummary="true" />

		<br>
		
		<h:panelGrid columns="3" width="890">	
		<%@ include file="menuProfessor.jsp" %>
		<%@include file="../common/bannerPropostaEquipe.jsp"%>			

			
		</h:panelGrid>

		<h:commandButton value="Salvar" action="#{equipeBean.salvar}" /><br>

	</h:form>

</f:view>