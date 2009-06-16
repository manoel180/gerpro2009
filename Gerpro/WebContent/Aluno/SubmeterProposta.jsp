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

		<h:commandButton value="Visualizar"
			action="#{submeterPropostaBean.prepararBean}" />
		<h:commandButton value="Submeter"
			action="#{submeterPropostaBean.prepararBean}" /> <h:commandButton action="#{propostaBean.prepararBean}" value="Ir para o listar propostas" />
		<br>

		<rich:simpleTogglePanel label="Informações">		
			<h:panelGrid columns="4" cellpadding="5">
				<h:outputLabel value="Nome:"/>
				<h:outputLabel value="#{submeterPropostaBean.equipe.nome}" />
				
				<h:outputLabel value="Data Limite:"/>
				<h:outputLabel value="#{submeterPropostaBean.proposta.dataSubmissao}" />
				
				<h:outputLabel value="Componentes:"/>
				<h:inputTextarea value="#{submeterPropostaBean.listaUsuarios.Usuario.nome}" readonly="true" />
				
				<h:outputLabel value="Status:"/>
				<h:outputLabel value="#{submeterPropostaBean.propitem.status.nome}" />
				
			</h:panelGrid>
		</rich:simpleTogglePanel>

	</h:form>
</f:view>