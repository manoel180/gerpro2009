<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Justificativa</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css">

</head>

<f:view>

	<div align="center"><h:outputLabel value="JUSTIFICATIVA PROPOSTA"
		styleClass="Titulos" /></div>

	<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
		showSummary="true" />

	<br>

	<h:panelGrid columns="3">
		<%@ include file="menu.jsp"%>

		<rich:simpleTogglePanel label="Dados do Proposta">

			<h:panelGrid columns="1" cellpadding="5" style="width: 798px">
				<h:outputText value="Justificativa:" />
				<rich:editor height="100" width="600" theme="advanced"
					readonly="true" style="width: 769px"
					value="#{corrigirPropostaBean.propostaitem.conteudoItem}" />
			</h:panelGrid>

		</rich:simpleTogglePanel>
	</h:panelGrid>
	<br>
	<jsp:directive.include
		file="../common/bannerCorrigirPropostaEquipe.jsp" />
	<h:form>
		<jsp:directive.include file="perguntasCorrecao.jsp" />
		<h:commandButton value="Salvar"
			action="#{corrigirPropostaBean.salvarCorrigirMissao}"
			disabled="#{corrigirPropostaBean.desabilitar}" />
	</h:form>
</f:view>