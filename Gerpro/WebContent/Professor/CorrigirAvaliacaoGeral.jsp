<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Missão</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css"
	href="../css/gerpro.css">

</head>

<f:view>
	<div align="center"><h:outputLabel value="AVALIAÇÃO GERAL"
		styleClass="Titulos" /></div>

	<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
		showSummary="true" />
	<br>

			<%@ include file="menu.jsp"%>
		<h:form>
		<%@ include file="perguntasCorrecao.jsp"%>
		<h:commandButton value="Salvar"
			action="#{corrigirPropostaBean.salvarCorrigirMissao}"
			disabled="#{corrigirPropostaBean.desabilitar}" />
	</h:form>
	<h:form>
		<%@ include file="perguntasCorrecao.jsp"%>
		<h:commandButton value="Salvar"
			action="#{corrigirPropostaBean.salvarCorrigirMissao}"
			disabled="#{corrigirPropostaBean.desabilitar}" />
	</h:form>
	<h:form>
		<%@ include file="perguntasCorrecao.jsp"%>
		<h:commandButton value="Salvar"
			action="#{corrigirPropostaBean.salvarCorrigirMissao}"
			disabled="#{corrigirPropostaBean.desabilitar}" />
	</h:form>
	

	<%@ include file="../common/bannerCorrigirPropostaEquipe.jsp"%>
	<h:form>
		<%@ include file="perguntasCorrecao.jsp"%>
		<h:commandButton value="Salvar"
			action="#{corrigirPropostaBean.salvarCorrigirMissao}"
			disabled="#{corrigirPropostaBean.desabilitar}" />
	</h:form>
</f:view>