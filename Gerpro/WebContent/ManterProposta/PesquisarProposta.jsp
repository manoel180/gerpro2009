<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Pesquisar Propostas</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css" href="WEB-INF/css/estilos.css">
</head>
<f:view>

	<h:form id="form1">
		<div align="center"><h:outputLabel value="PESQUISAR PROPOSTAS"
			styleClass="titulo" /></div>
		   <div align="center"> 
		<h:panelGrid columns="2" cellpadding="10" rowClasses="2" >
		<rich:simpleTogglePanel label="Pesquisa">
			<h:selectOneRadio value="#{propostaBean.tipo}" >
				<f:selectItem itemLabel="Cod" itemValue="1" />
				<f:selectItem itemLabel="Nome" itemValue="2" />				
				<f:selectItem itemLabel="Equipe" itemValue="3"/>
			</h:selectOneRadio>
			<h:outputText value="Descrição:" />
			<h:inputText id="txtdesc" value="#{propostaBean.busca}" />
			<h:commandButton value="Pesquisar" action="#{propostaBean.pesquisar}" />
		</rich:simpleTogglePanel>
		
		<rich:panel style="width: 217px" header="Opções">
			<h:commandButton value="Novo" action="#{propostaBean.preperarInclusao}" />
			<br>
			<h:commandButton  value="Gerar Relatório" action="#{relatorioBean.gerarRelatorioProposta}"/>
		</rich:panel>
		
		</h:panelGrid>
	</div>
	</h:form>
	<h:form id="form2">

		<rich:dataTable var="prop" id="listapropostas" rendered="true"
			value="#{propostaBean.listaProposta}"
			binding="#{propostaBean.objDatatableProposta}" rows="5"
			width="550px" align="center">
			<rich:column sortBy="#{prop.id}">
				<f:facet name="header">
					<h:outputText value="Cod" />
				</f:facet>
				<h:outputText value="#{prop.id}" />
			</rich:column>
			<rich:column sortBy="#{prop.nome}">
				<f:facet name="header">
					<h:outputText value="Proposta" />
				</f:facet>
				<h:outputText value="#{prop.nome}" />
			</rich:column>
			<rich:column sortBy="#{prop.equipe.nome}">
				<f:facet name="header">
					<h:outputText value="Equipe" />
				</f:facet>
				<h:outputText value="#{prop.equipe.nome}" />
			</rich:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputText value="Opções" />
				</f:facet>
				<h:commandButton image="/images/delete.png"
					action="#{propostaBean.excluir}" style="height: 40px; width: 40px" />
				<h:commandButton image="/images/editar.png"
					action="#{propostaBean.preperarEdicao}"
					style="height: 40px; width: 40px" />
			</h:column>
		</rich:dataTable>
		<rich:datascroller align="center" for="listapropostas" maxPages="5"
			page="#{dataTableScrollerBean.scrollerPage}" fastControls="show" />
		<rich:spacer height="30" />

	</h:form>

</f:view>