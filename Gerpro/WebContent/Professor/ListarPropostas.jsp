<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Lista de Propostas</title>
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
	<br>
	<%@include file="menuProfessor.jsp"%></div>
	<br />
	<div id="content"><h:form id="form">
		<rich:panel>
		<h:messages tooltip="true" layout="list" showDetail="true"
				showSummary="true" rendered="true" errorClass="mensagem_erro"
				 infoClass="mensagem_sucesso"/>
			<rich:dataTable var="prop" id="listapropostas"
				value="#{propostaBean.listaPorProfessor}"
				binding="#{propostaBean.objDatatableProposta}">

				<rich:column sortBy="#{prop.id}">
					<f:facet name="header">
						<h:outputText value="Cód" />
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

				<rich:column sortBy="#{prop.status.nome}">
					<f:facet name="header">
						<h:outputText value="Status" />
					</f:facet>
					<h:outputText value="#{prop.status.nome}" />
				</rich:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Opções" />
					</f:facet>

					<h:commandLink value="Visualizar"
						action="#{propostaBean.prepararCorrecao}">
					</h:commandLink>
				</h:column>
			</rich:dataTable>
		</rich:panel>
	</h:form></div>
	</div>
</f:view>

<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>

