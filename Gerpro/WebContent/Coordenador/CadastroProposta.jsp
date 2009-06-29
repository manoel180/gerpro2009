<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Cadastro de Propostas</title>
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
	<%@ include file="menuCoordenador.jsp"%></div>

	<br>
	<h:outputLabel value="CADASTRO DE PROPOSTAS" styleClass="Titulo1" /> <h:messages
		tooltip="true" layout="list" showDetail="true" showSummary="true"
		rendered="true" errorClass="mensagem_erro"
		infoClass="mensagem_sucesso" /> <br>
	<br>
	<rich:toolTip for="txtdesc1" followMouse="true" zorder="90"
		value="Inserir um nome da Proposta" /> <rich:toolTip for="equipe"
		followMouse="true" zorder="90" value="Selecione uma equipe" /> <rich:toolTip
		for="txtperiodo" followMouse="true" zorder="90"
		value="Inserir um Periodo" />

	<div id="content"><h:panelGrid cellpadding="5" width="560">
		<rich:simpleTogglePanel label="Dados do Cadastro" width="99%">

			<h:form id="form1">
				<h:panelGrid columns="2" cellpadding="5" id="pg">
					<h:outputText value="Nome*:" styleClass="Obrigatorio"/>
					<h:inputText maxlength="100" id="txtdesc1" required="true"
						value="#{propostaBean.proposta.nome}">
						<f:attribute name="fieldRef" value="Nome" />
					</h:inputText>

					<h:outputText value="Equipe*:" styleClass="Obrigatorio"/>
					<h:selectOneMenu id="equipe" value="#{propostaBean.equipe.id}"
						rendered="true">
						<f:selectItems value="#{propostaBean.equipesCombo}" />
						<f:attribute name="fieldRef" value="Equipe" />
					</h:selectOneMenu>

					<h:outputText value="Periodo*:" styleClass="Obrigatorio"/>
					<h:inputText maxlength="8" id="txtperiodo"
						value="#{propostaBean.proposta.periodo}" required="true">
						<f:attribute name="fieldRef" value="Período" />
					</h:inputText>
					<rich:toolTip for="btnsalvar" followMouse="true" zorder="90"
						value="Clique para Salvar" />
					<h:commandButton
						id="btnsalvar" value="Salvar" action="#{propostaBean.salvar}" />
				</h:panelGrid>
			</h:form>
		</rich:simpleTogglePanel>
	</h:panelGrid>
	</div>

	</div>
	</div>


</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>
