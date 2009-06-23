<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Missão</title>
</head>
<!--Chamada ao arquivo CSS -->
<link href="../css/gerpro.css" rel="stylesheet" type="text/css" />

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

	<div id="content"><h:form>
		<div align="center"><h:outputLabel value="SUBMETER CORREÇÃO"
			styleClass="titulo" /></div>

		<h:messages tooltip="true" layout="list" showDetail="true"
				showSummary="true" rendered="true" errorClass="mensagem_erro"
				 infoClass="mensagem_sucesso"/>
		<br>
		<br>

		<rich:dataTable var="correcoes" id="listaCorrecao"
			value="#{corrigirPropostaBean.listaCorrecao}" rows="10" width="550px"
			align="center">
			<h:column>
				<f:facet name="header">
					<h:outputText value="Pergunta"></h:outputText>
				</f:facet>
				<h:outputText value="#{correcoes.pergunta.descricao}"></h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Resposta"></h:outputText>
				</f:facet>
				<h:outputText value="#{correcoes.resposta.descricao}"
					style="color:red; font-weight:bold; font-"></h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Status"></h:outputText>
				</f:facet>
				<h:outputText value="#{correcoes.status.nome}"
					style="color:red; font-weight:bold; font-"></h:outputText>
			</h:column>

		</rich:dataTable>
		<h:commandButton value="Submeter Correção"
			disabled="#{corrigirPropostaBean.desabilitar}"
			action="#{corrigirPropostaBean.submeterCorrecao}"
			style=" width : 142px;" />
		<br>
	</h:form></div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>