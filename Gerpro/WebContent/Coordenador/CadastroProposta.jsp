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
<link href="${pageContext.request.contextPath}/css/gerpro.css" rel="stylesheet" type="text/css" />

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


	<div align="center"><h:outputLabel value="CADASTRO DE PROPOSTAS"
		styleClass="Titulo1" /></div>

	<h:messages layout="list" styleClass="" showDetail="true"
		showSummary="true" /> <br>
	<br>
	<rich:toolTip for="txtdesc1" followMouse="true" zorder="90"
		value="Inserir um nome da Proposta" /> <rich:toolTip for="equipe"
		followMouse="true" zorder="90" value="Selecione uma equipe" /> 
		<rich:toolTip for="dt_criacao" followMouse="true" zorder="90"
		value="Inserir uma data de Criação da Proposta" /> 
		<rich:toolTip for="txtperiodo" followMouse="true" zorder="90"
		value="Inserir um Periodo" /> <rich:simpleTogglePanel focus="txtdesc1"
		label="Dados do cadastro" style="text-align:left">
		<h:form>
			<h:panelGrid columns="2" cellpadding="5" id="pg">


				<h:outputText value="Nome:" />
				<h:inputText maxlength="100" id="txtdesc1" required="true"
					value="#{propostaBean.proposta.nome}">
					<f:attribute name="fieldRef" value="Nome" />
				</h:inputText>

				<h:outputText value="Equipe:" />
				<h:selectOneMenu id="equipe" value="#{propostaBean.equipe.id}"
					rendered="true">
					<f:selectItems value="#{propostaBean.equipesCombo}" />
					<f:attribute name="fieldRef" value="Equipe" />	
				</h:selectOneMenu>

				<h:outputText value="Data Criação:" />

				<rich:calendar id="dt_criacao"
					value="#{propostaBean.proposta.dataCriacao}" required="true">
					<f:attribute name="fieldRef" value="Data Criação" />
				</rich:calendar>

				<h:outputText value="Periodo:" />
				<h:inputText maxlength="8" id="txtperiodo"
					value="#{propostaBean.proposta.periodo}"  required="true">
					<f:attribute name="fieldRef" value="Período" />
				</h:inputText>
				<rich:toolTip for="btnsalvar" followMouse="true" zorder="90"
		       value="Clique para Salvar" />
		        <div align="left">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h:commandButton id="btnsalvar" value="Salvar" action="#{propostaBean.salvar}" />

			</h:panelGrid>
		</h:form>

	</rich:simpleTogglePanel> 
	</div>
	</div>
	
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>
