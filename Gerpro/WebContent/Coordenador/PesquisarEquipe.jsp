<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%><%@page
	contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Pesquisar Equipes</title>
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
	<%@ include file="menuCoordenador.jsp"%></div>

	<div id="content"><h:form id="form1">
	<h:messages tooltip="true" layout="list" showDetail="true"
				showSummary="true" rendered="true" errorClass="mensagem_erro"
				 infoClass="mensagem_sucesso"/>
		<div align="center"><h:outputLabel value="PESQUISAR EQUIPES"
			styleClass="titulo" /></div>
		<rich:simpleTogglePanel focus="txtdesc" label="Dados da Pesquisa">
			<h:panelGrid columns="5" cellpadding="10" rowClasses="2">
				<h:outputText value="Nome:" />
				<h:inputText maxlength="50" id="txtdesc"
					value="#{equipeBean.equipe.nome}" />
				<h:commandButton value="Pesquisar" action="#{equipeBean.pesquisar}" />

			</h:panelGrid>

		</rich:simpleTogglePanel>
	</h:form> <h:form id="form2">
		<rich:simpleTogglePanel label="Resultado da Pesquisa">
			<rich:dataTable var="eqp" id="listaequipe"
				value="#{equipeBean.listaEquipe}"
				binding="#{equipeBean.objDatatableEquipe}" rows="10" width="550px"
				align="center">
				<h:column>
					<f:facet name="header">
						<h:outputText value="Cod" />
					</f:facet>
					<h:outputText value="#{eqp.id}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Equipe" />
					</f:facet>
					<h:outputText value="#{eqp.nome}"
						style="color:red; font-weight:bold; font-" />

				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Opções" />

					</f:facet>
					<h:commandButton value="Excluir" action="#{equipeBean.excluir}" />
					<h:commandButton value="Editar"
						action="#{equipeBean.prepararEdicao}" />
				</h:column>
			</rich:dataTable>
		</rich:simpleTogglePanel>
	</h:form></div>
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>


