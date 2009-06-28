<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Funções</title>
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
	<%@ include file="menuAluno.jsp"%></div>

	<div><br>
	<h:outputLabel value="LISTA DE FUNÇÕES" styleClass="Titulo1" /> <br>


	<h:messages layout="list" showDetail="true" showSummary="true"
		rendered="true" errorClass="mensagem_erro"
		infoClass="mensagem_sucesso" /> <br>
	<div id="content">
	<h:panelGrid columns="1" width="560">

		<rich:simpleTogglePanel label="#{construirPropostaBean.proposta.nome}"
			rendered="#{!construirPropostaBean.desabilitar}" width="99%">
			<h:form id="form1">
				<h:panelGrid columns="1">

					<h:outputText value="Ordem*:" styleClass="Obrigatorio" />
					<rich:inputNumberSpinner
						value="#{construirPropostaBean.listafuncaoid.numeroSequencia}"
						disabled="#{construirPropostaBean.desabilitar}" id="textordem"
						required="true" >
						<f:attribute name="fieldRef" value="Ordem" />
					</rich:inputNumberSpinner>

					<h:outputText value="Caso de Uso*:" styleClass="Obrigatorio" />
					<rich:editor value="#{construirPropostaBean.listaFuncao.uc}"
						theme="advanced" readonly="#{construirPropostaBean.desabilitar}"
						id="textcasouso" required="true" width="540">
						<f:attribute name="fieldRef" value="Caso de Uso" />
					</rich:editor>

					<h:outputText value="Descrição*:" styleClass="Obrigatorio"/>
					<rich:editor value="#{construirPropostaBean.listaFuncao.descricao}"
						theme="advanced" readonly="#{construirPropostaBean.desabilitar}"
						id="textdesc" required="true" width="540" />

					<!-- Combobox tipo de funcao -->
					<h:outputText value="Tipo de Função:" />
					<!-- rint Combo -->
					<rich:toolTip for="combotipofunc" followMouse="true" zorder="90"
						value="clique para escolher" />
					<h:selectOneMenu value="#{construirPropostaBean.tipofuncao.id}"
						disabled="#{construirPropostaBean.desabilitar}" id="combotipofunc">
						<f:selectItems value="#{construirPropostaBean.tipoFuncaoCombo}" />
					</h:selectOneMenu>

					<!-- hint botao deletar add-->
					<rich:toolTip for="btnadd" followMouse="true" zorder="90"
						value="clique para Adicionar função" />
					<h:commandButton value="Adicionar" id="btnadd"
						disabled="#{construirPropostaBean.desabilitar}"
						action="#{construirPropostaBean.addfuncao}" />
				</h:panelGrid>
			</h:form>
		</rich:simpleTogglePanel>

		<h:form id="form2">
			<rich:dataTable id="idtable" var="listafuncao"
				value="#{construirPropostaBean.lstlistaFuncao}"
				binding="#{construirPropostaBean.objDatatableListaFuncao}" rows="5"
				align="center" width="99%">
				<rich:column sortBy="#{listafuncao.id.numeroSequencia}">
					<f:facet name="header">
						<h:outputText value="Ordem" />
					</f:facet>
					<h:outputText value="#{listafuncao.id.numeroSequencia}" />
				</rich:column>

				<rich:column sortBy="#{listafuncao.uc}">
					<f:facet name="header">
						<h:outputText value="Caso de Uso" />
					</f:facet>
					<h:outputLabel escape="false" value="#{listafuncao.uc}"/>
				</rich:column>

				<rich:column sortBy="#{listafuncao.descricao}">
					<f:facet name="header">
						<h:outputFormat value="Descrição" />
					</f:facet>
					<h:outputLabel escape="false" value="#{listafuncao.descricao}" />
				</rich:column>

				<rich:column sortBy="#{listafuncao.tipoFuncao.nome}">
					<f:facet name="header">
						<h:outputText value="Tipo" />
					</f:facet>
					<h:outputText value="#{listafuncao.tipoFuncao.nome}" />
				</rich:column>

				<h:column rendered="#{!construirPropostaBean.desabilitar}">
					<f:facet name="header">
						<h:outputText value="Opções"></h:outputText>
					</f:facet>
					<!-- hint botao deletar e alterar-->
					<rich:toolTip for="btndeletar" followMouse="true" zorder="90"
						value="Deletar/Excluir" />
					<rich:toolTip for="btnalterar" followMouse="true" zorder="90"
						value="Alterar" />
					<h:commandButton value="Excluir" id="btndeletar"
						action="#{construirPropostaBean.delfuncao}"
						disabled="#{construirPropostaBean.desabilitar}">
					</h:commandButton>
					<h:commandButton value="Editar" id="btnalterar"
						action="#{construirPropostaBean.editfuncao}"
						disabled="#{construirPropostaBean.desabilitar}"
						>
					</h:commandButton>
				</h:column>
			</rich:dataTable>
			<rich:datascroller align="center" for="idtable" maxPages="5"
				fastControls="show" />
			<!-- hint botao salvar-->
			<rich:toolTip for="btnsalvar" followMouse="true" zorder="90"
				value="clique para Salvar" />

			<div align="left" style="width: 495px;">
			<h:commandButton value="Salvar"
				id="btnsalvar" disabled="#{construirPropostaBean.desabilitar}"
				action="#{construirPropostaBean.salvarListaFuncao}" />
			<br>
			<br>
			</div>
			<br>

		</h:form>
	</h:panelGrid></div>
	</div>
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>
