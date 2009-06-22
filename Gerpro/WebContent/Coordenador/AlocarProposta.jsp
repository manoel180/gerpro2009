<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%><%@page
	contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Alocar Propostas</title>
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
	<%@ include file="menuCoordenador.jsp"%></div>

	<div id="content">
	<h:form id="form1">

		<h:outputLabel styleClass="Titulo1" value="ALOCAR PROPOSTAS" />

		<h:panelGrid columns="1" cellpadding="10" style="width=100%"
			width="100%" rowClasses="2">

			<h:messages tooltip="true" layout="list" showDetail="true"
				showSummary="true" rendered="true" />
			<rich:simpleTogglePanel>
				<h:outputLabel value="Tipo de alocação" />
				<h:selectOneRadio id="radio" layout="pageDirection"
					value="#{alocarBean.correcaoGrupo}">
					<f:selectItem itemValue="true" itemLabel="Grupo" />
					<f:selectItem itemValue="false" itemLabel="Individual" />
				</h:selectOneRadio>

				<h:panelGrid columns="1" id="pg">

					<rich:pickList removeAllControlLabel="Remover Todos"
						copyControlLabel="Adicionar" removeControlLabel="Remover"
						copyAllControlLabel="Adicionar Todos" switchByDblClick="false"
						copyVisible="#{!alocarBean.desabilitar}"
						copyAllVisible="#{!alocarBean.desabilitarTodos}"
						value="#{alocarBean.listProfessores}">
						<f:selectItems value="#{alocarBean.professorCombo}" />
						<a4j:support event="onlistchange" ajaxSingle="true"
							action="#{alocarBean.desabilitar}" reRender="pg" />
					</rich:pickList>

					<h:commandButton value="Alocar" disabled="#{alocarBean.desabilitarBotaoAlocar}" action="#{alocarBean.alocar}"></h:commandButton>

				</h:panelGrid>

			</rich:simpleTogglePanel>
		</h:panelGrid>

	</h:form></div>
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>
