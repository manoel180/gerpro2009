<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%><%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
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
		<h:messages tooltip="true" layout="list"  showDetail="true" showSummary="true" rendered="true"/>
		<br>
		<rich:simpleTogglePanel label="Pesquisa">
			<h:panelGrid columns="3" id="pg">
				<h:selectOneMenu value="#{propostaBean.tipo}" >
					<f:selectItems value="#{propostaBean.itensPesqCombo}" />
					<a4j:support event="onchange" ajaxSingle="true"
						action="#{propostaBean.alterarComponente}"
						reRender="pg"/>
				</h:selectOneMenu>
				<h:outputText value="Descrição:" />
					<h:inputText autocomplete="on" immediate="true" id="txtdesc" value="#{propostaBean.busca}"   rendered="#{propostaBean.viewDes}">
				</h:inputText>
				
				<rich:inputNumberSpinner  rendered="#{propostaBean.viewint}"  immediate="true"  id="txtdescint" value="#{propostaBean.busca}">
					<f:convertNumber  integerOnly="true" type="number"/>
				</rich:inputNumberSpinner>
					<h:commandButton value="Pesquisar" action="#{propostaBean.pesquisar}" />
			
			</h:panelGrid>
		</rich:simpleTogglePanel>
		
		<rich:panel style="width: 217px" header="Opções">
			<h:commandButton value="Novo" action="#{propostaBean.preperarInclusao}" />
			<br>
			<h:commandButton  value="Gerar Relatório" onclick="submit()" action="#{relatorioBean.gerarRelatorioProposta}"/>
			<h:commandButton disabled="false" value="Gerar Relatório Processado" action="#{relatorioBean.gerarRelatorioResultadosProposta}"/>
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
				<h:commandButton image="/images/delete.png" alt="Excluir Proposta"
					action="#{propostaBean.excluir}" style="height: 40px; width: 40px" />
				<h:commandButton image="/images/editar.png"
					action="#{propostaBean.preperarEdicao}" alt="Editar Proposta"
					style="height: 40px; width: 40px" />
			</h:column>
		</rich:dataTable>
		<rich:datascroller align="center" for="listapropostas" maxPages="5"
			page="#{dataTableScrollerBean.scrollerPage}" fastControls="show" />
		<rich:spacer height="30" />

	</h:form>

</f:view>