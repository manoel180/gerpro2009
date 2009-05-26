<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib
	uri="http://richfaces.org/rich" prefix="rich1"%><%@page	contentType="text/html"%>
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
		<br><rich:dataTable var="itens" id="listapropostasitens" value="#{submeterPropostaBean.listaPropostaItem}" binding="#{submeterPropostaBean.objDatatablePropostaItem}" rows="10" width="550px" align="center">
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
					<h:outputText value="#{itens.status.nome}" style="color:red; font-weight:bold; font-"></h:outputText>
				</h:column>
								
			</rich:dataTable>
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro">
			

			

		</rich:simpleTogglePanel>
<h:commandButton value="Salvar" action="#{submeterPropostaBean.prepararBean}" />
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