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
	<br>
			<h:outputLabel styleClass="Titulo1" value="PESQUISAR USUÁRIOS"/>
		<h:messages tooltip="true" layout="list" showDetail="true"
				showSummary="true" rendered="true" errorClass="mensagem_erro"
				 infoClass="mensagem_sucesso"/>
				 
	<div id="content">
	<rich:toolTip for="tipobusca" followMouse="true" zorder="90" value="Selecione a forma de busca" />
	<!--  rint  -->
	<rich:toolTip for="txtdesc" followMouse="true" zorder="90" value="Digite os dados para pesquisa."/>
	<rich:toolTip for="btnpesquisar" followMouse="true" zorder="90" value="Fazer pesquisa."/>
	
	
	
			   
		<h:panelGrid columns="1" cellpadding="10" width="560" rowClasses="2">
		
	
		<rich:simpleTogglePanel label="Pesquisa">
		<h:form id="form1">
			<h:panelGrid columns="5" id="pg">
				<h:selectOneMenu id="tipobusca" value="#{usuarioBean.tipo}" >
					<f:selectItems value="#{usuarioBean.itensPesqCombo}" />
					<a4j:support event="onchange" ajaxSingle="true"
						action="#{usuarioBean.alterarComponente}"
						reRender="pg"/>
				</h:selectOneMenu>
				
					<h:inputText autocomplete="on" immediate="true" id="txtdesc" value="#{usuarioBean.busca}"   rendered="#{usuarioBean.viewDes}">
				</h:inputText>
					
				<rich:inputNumberSpinner  rendered="#{usuarioBean.viewint}"  immediate="true"  id="txtdescint" value="#{usuarioBean.busca}">
					<f:convertNumber  integerOnly="true" type="number"/>
				</rich:inputNumberSpinner>
					<h:commandButton value="Pesquisar" id="btnpesquisar" action="#{usuarioBean.pesquisar}" />
			</h:panelGrid>
			</h:form>
		</rich:simpleTogglePanel>		
		</h:panelGrid>
	
	<h:form id="form2">
		<h:panelGrid columns="1" cellpadding="10" width="560" rowClasses="2">
		<rich:dataTable var="users" id="listausuario" width="99%"
			 value="#{usuarioBean.listaUsuario}" 
			binding="#{usuarioBean.objDatatableUsuario}" rows="5"
			 align="center">
			<rich:column width="5%" sortBy="#{users.matricula}">
				<f:facet name="header">
					<h:outputText value="Matricula" />
				</f:facet>
				<h:outputText value="#{users.matricula}" />
			</rich:column>
			<rich:column width="60%" sortBy="#{users.nome}">
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{users.nome}" />
			</rich:column>
			
			<rich:column width="15%" sortBy="#{users.tipoUsuario.nome}">
				<f:facet name="header">
					<h:outputText value="Tipo" />
				</f:facet>
				<h:outputText value="#{users.tipoUsuario.nome}" />
			</rich:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputText value="Opções" />
				</f:facet>
				
				<rich:toolTip for="btnalterar" followMouse="true" zorder="90" value="Alterar uma proposta"/>
				
				<h:commandButton value="Editar" action="#{usuarioBean.prepararEdicao}" id="btnalterar" 
					 />
				
			</h:column>
		</rich:dataTable>
		<rich:datascroller align="center" for="listausuario" maxPages="5"	page="#{dataTableScrollerBean.scrollerPage}" fastControls="show" />
		<rich:spacer height="30" />
</h:panelGrid>
	</h:form>
	</div>
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>
