<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Correção da Avaliação Geral</title>
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

	<div id="content">

	<div align="center"><h:outputLabel value="AVALIAÇÃO GERAL"
		styleClass="Titulo1" /></div>
	<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
		showSummary="true" /> <br>

	<rich:simpleTogglePanel width="520px"
		label="#{corrigirPropostaBean.proposta.nome}">
	</rich:simpleTogglePanel> <h:form>
		<%@ include file="perguntasCorrecao.jsp"%>

		<!-- hint botao salvar-->
		<rich:toolTip for="btnsalvar" followMouse="true" zorder="90"
			value="clique para Salvar" />
		<br>
		<div align="left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h:commandButton
			id="btnsalvar" value="Salvar"
			action="#{corrigirPropostaBean.salvarCorrigirAvaliacaoGeral1}"
			disabled="#{corrigirPropostaBean.desabilitar}" />
	</h:form> <h:form>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%@ include
			file="perguntasCorrecao.jsp"%>
		<!-- hint botao salvar-->
		<rich:toolTip for="btnsalvar" followMouse="true" zorder="90"
			value="clique para Salvar" />
		<br>
		<div align="left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h:commandButton
			id="btnsalvar" value="Salvar"
			action="#{corrigirPropostaBean.salvarCorrigirAvaliacaoGeral2}"
			disabled="#{corrigirPropostaBean.desabilitar}" />
	</h:form> <h:form>
		<%@ include file="perguntasCorrecao.jsp"%>

		<!-- hint botao salvar-->
		<rich:toolTip for="btnsalvar" followMouse="true" zorder="90"
			value="clique para Salvar" />
		<br>
		<div align="left"><h:commandButton id="btnsalvar" value="Salvar"
			action="#{corrigirPropostaBean.salvarCorrigirAvaliacaoGeral3}"
			disabled="#{corrigirPropostaBean.desabilitar}" />
	</h:form></div>
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>