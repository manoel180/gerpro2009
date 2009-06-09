<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Metodologia</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css">

</head>

<f:view>
	<h:form>

		<div align="center"><h:outputLabel value="METODOLOGIA PROPOSTA"
			styleClass="Titulos" /></div>

		<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
			showSummary="true" />

		<br>

		<h:panelGrid columns="3">
			
			<%@ include file="menu.jsp"%>
						
			<rich:simpleTogglePanel label="Dados do Proposta">
				<h:panelGrid columns="1" cellpadding="5" style="width: 798px">
					<h:outputText value="Metodologia:" />
					<rich:editor height="300" width="700"  
						style="width: 769px"
						value="#{construirPropostaBean.propostaItem.conteudoItem}" />
				</h:panelGrid>
			</rich:simpleTogglePanel>
		</h:panelGrid>

		
		<h:commandButton value="Salvar" action="#{construirPropostaBean.SalvarMetodologia}" /><br><%@include file="../common/bannerPropostaEquipe.jsp"%>

	</h:form>

</f:view>