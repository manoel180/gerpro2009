<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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

		<div align="center"><h:outputLabel value="SUBMETER PROPOSTAS"
			styleClass="titulo" /></div>

		<h:messages layout="list" styleClass="Obrigatorio" showDetail="true"
			showSummary="true" />
		<br>
		<br>
		<rich:dataTable var="itens" id="listapropostasitens"
			value="#{submeterPropostaBean.listaPropostaItem}"
			binding="#{submeterPropostaBean.objDatatablePropostaItem}" rows="10"
			width="550px" align="center">
			<h:column>
				<f:facet name="header">
					<h:outputText value="Item"></h:outputText>
				</f:facet>
				<h:outputText value="#{itens.item.nome}"></h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Status"></h:outputText>
				</f:facet>
				<h:outputText value="#{itens.status.nome}"
					style="color:red; font-weight:bold; font-"></h:outputText>
			</h:column>
		</rich:dataTable>

		<h:commandButton value="Submeter"
			disabled="#{submeterPropostaBean.desabilita}"
			action="#{submeterPropostaBean.submeterProposta}" />
		
		<br>
		<%@include file="../common/bannerSubmeterPropostaEquipe.jsp"%>	
	</h:form>
</f:view>