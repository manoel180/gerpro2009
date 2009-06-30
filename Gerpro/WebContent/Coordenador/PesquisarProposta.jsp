<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%><%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Pesquisar Propostas</title>
</head>
<!--Chamada ao arquivo CSS -->
<link href="../css/gerpro.css" rel="stylesheet" type="text/css" />
<link href="css/gerpro.css" rel="stylesheet" type="text/css" />

<div id="topo"><!-- Início da DIV do Topo -->
<div id="topo_linha"></div>
<!-- DIV Linha Cinza -->
<div id="banner"></div>
<!-- DIV Banner Gerpro--></div>
<!-- Fim da DIV do Topo -->


<f:view>
	<div id="div_corpo">
	<div id="menu"><br />
	<br />
	<%@ include file="menuCoordenador.jsp"%>
	</div>

	<div id="content">


	<rich:toolTip for="tipobusca" followMouse="true" zorder="90" value="Selecione a forma de busca" />
	<!--  rint  -->
	<rich:toolTip for="txtdesc" followMouse="true" zorder="90" value="Digite o conteúdo da pesquisa."/>
	<rich:toolTip for="txtdescint" followMouse="true" zorder="90" value="Informe o código da proposta"/>
	<rich:toolTip for="btnpesquisar" followMouse="true" zorder="90" value="Fazer pesquisa."/>
	
	
<h:form id="form1">	
	
			<h:outputLabel styleClass="Titulo1" value="PESQUISAR PROPOSTAS"/>
			   
		<h:panelGrid columns="1" cellpadding="10" width="560" rowClasses="2">
		
		<h:messages layout="list" showDetail="true"
				showSummary="true" rendered="true" errorClass="mensagem_erro"
				 infoClass="mensagem_sucesso"/>
				 
		<rich:simpleTogglePanel label="Pesquisa">
			<h:panelGrid columns="5" id="pg">
				<h:selectOneMenu id="tipobusca" value="#{propostaBean.tipo}" >
					<f:selectItems value="#{propostaBean.itensPesqCombo}" />
					<a4j:support event="onchange" ajaxSingle="true"
						action="#{propostaBean.alterarComponente}"
						reRender="pg"/>
				</h:selectOneMenu>
					<h:inputText maxlength="100" autocomplete="on" immediate="true" id="txtdesc" value="#{propostaBean.busca}" >
				</h:inputText>
					<h:commandButton value="Pesquisar" id="btnpesquisar" action="#{propostaBean.pesquisar}" />
			</h:panelGrid>
		</rich:simpleTogglePanel>		
		</h:panelGrid>
	
	</h:form>
	<h:form id="form2">

		<rich:dataTable var="prop" id="listapropostas"
			 value="#{propostaBean.listaProposta}" width="560" 
			binding="#{propostaBean.objDatatableProposta}" rows="5"
			 align="center" >			
			<rich:column width="60%" sortBy="#{prop.nome}">
				<f:facet name="header">
					<h:outputText value="Proposta" />
				</f:facet>
				<h:outputText style="text-align:left" value="#{prop.nome}" />
			</rich:column>
			<rich:column width="15%" sortBy="#{prop.equipe.nome}">
				<f:facet name="header">
					<h:outputText value="Equipe" />
				</f:facet>
				<h:outputText value="#{prop.equipe.nome}" />
			</rich:column>
			<rich:column width="30%" sortBy="#{prop.id}">
				<f:facet name="header">
					<h:outputText value="Status" />
				</f:facet>
				<h:outputText value="#{prop.status.nome}" />
			</rich:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputText value="Opções" />
				</f:facet>
				
				
				<rich:toolTip for="btnalterar" followMouse="true" zorder="90" value="Alterar uma proposta"/>				
				<h:commandButton value="Editar" action="#{propostaBean.prepararEdicao}" id="btnalterar"/>
				
			</h:column>
		</rich:dataTable>
		<rich:datascroller align="center" for="listapropostas" maxPages="5"	page="#{dataTableScrollerBean.scrollerPage}" fastControls="show" />
		<rich:spacer height="30" />

	</h:form>
	<h:form>
		<h:commandButton value="Nova Proposta" id="btncadastrar" action="#{propostaBean.prepararInclusao}" />
	</h:form>
	</div>
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>
