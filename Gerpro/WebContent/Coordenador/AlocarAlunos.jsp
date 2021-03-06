<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%><%@page
	contentType="text/html"%>
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
	<%@ include file="menuCoordenador.jsp"%></div>

	<br>
	<h:outputLabel styleClass="Titulo1" value="ALOCAR ALUNOS" />
	<h:messages tooltip="true" layout="list" showDetail="true"
				showSummary="true" rendered="true" errorClass="mensagem_erro"
				infoClass="mensagem_sucesso" />
	<br>			<br>
	<div id="content">
	<h:form id="form1">
		<h:panelGrid columns="1" cellpadding="5" width="560">
			
			<rich:simpleTogglePanel width="99%">
				<h:panelGrid columns="2" id="pg">
					<h:outputText value="Equipe:" />
					<h:selectOneMenu id="equipe" value="#{alocarBean.equipe.id}">
						<f:selectItems value="#{alocarBean.equipesCombo}" />
						<f:attribute name="fieldRef" value="Equipe" />
					</h:selectOneMenu>
					<br>
					<rich:pickList removeAllControlLabel="Remover Todos"
						copyControlLabel="Adicionar" removeControlLabel="Remover"
						copyAllControlLabel="Adicionar Todos" switchByDblClick="false"
						value="#{alocarBean.listAlunos}">
						<f:selectItems value="#{alocarBean.alunosCombo}" />
					</rich:pickList>

					<h:commandButton value="Alocar" action="#{alocarBean.alocarAlunos}"></h:commandButton>

				</h:panelGrid>
'			
			</rich:simpleTogglePanel>
		</h:panelGrid>

	</h:form></div>
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>
