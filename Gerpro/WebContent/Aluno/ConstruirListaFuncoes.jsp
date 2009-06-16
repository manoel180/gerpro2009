<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Funções</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css">
</head>

<f:view>
	<h:form>

		<div align="center"><h:outputLabel value="FUNÇÕES"
			styleClass="Titulos" /></div>

		<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
			showSummary="true" />

		<br>

		<h:panelGrid columns="3">
			<%@ include file="menu.jsp"%>
			<br/>
			<br/>
				<%@include file="../common/bannerPropostaEquipe.jsp"%>	

			<rich:simpleTogglePanel rendered="#{!construirPropostaBean.desabilitar}" label="Dados do cadastro">
				<h:panelGrid columns="1" cellpadding="5" style="width: 798px">

					<h:outputText value="Ordem:" />
					<!-- rint Textarea -->
					<rich:toolTip for="textordem" followMouse="true" zorder="90"
						value="clique para inserir" />
					<h:inputTextarea
						value="#{construirPropostaBean.listafuncaoid.numeroSequencia}"
						disabled="#{construirPropostaBean.desabilitar}" id="textordem"
						style="width: 762px; height: 57px" />


					<h:outputText value="Caso de Uso:" />
					<!-- rint Textarea -->
					<rich:toolTip for="textcasouso" followMouse="true" zorder="90"
						value="clique para inserir" />
					<h:inputTextarea value="#{construirPropostaBean.listaFuncao.uc}"
						disabled="#{construirPropostaBean.desabilitar}" id="textcasouso"
						style="width: 762px; height: 57px" />


					<h:outputText value="Descrição:" />
					<!-- rint Textarea -->
					<rich:toolTip for="textdesc" followMouse="true" zorder="90"
						value="clique para inserir" />
					<h:inputTextarea
						value="#{construirPropostaBean.listaFuncao.descricao}"
						disabled="#{construirPropostaBean.desabilitar}" id="textdesc"
						style="width: 762px; height: 57px" />

					<!-- Combobox tipo de funcao -->
					<h:outputText value="Tipo de Função:" />
					<!-- rint Combo -->
					<rich:toolTip for="combotipofunc" followMouse="true" zorder="90"
						value="clique para escolher" />
					<h:selectOneMenu value="#{construirPropostaBean.tipofuncao.id}"
						disabled="#{construirPropostaBean.desabilitar}" id="combotipofunc">
						<f:selectItems value="#{construirPropostaBean.tipoFuncaoCombo}" />
					</h:selectOneMenu>

					<!-- rint botao deletar add-->
					<rich:toolTip for="btnadd" followMouse="true" zorder="90"
						value="clique para Adicionar função" />
					<h:commandButton value="Adicionar" id="btnadd"
						disabled="#{construirPropostaBean.desabilitar}"
						action="#{construirPropostaBean.addfuncao}" />

				</h:panelGrid>
			</rich:simpleTogglePanel>
		</h:panelGrid>
	</h:form>

	<h:form>
		<rich:dataTable id="idtable" var="listafuncao"
			value="#{construirPropostaBean.lstlistaFuncao}"
			binding="#{construirPropostaBean.objDatatableListaFuncao}" rows="5"
			width="550px" align="center">
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
				<h:outputText value="#{listafuncao.uc}" />
			</rich:column>

			<rich:column sortBy="#{listafuncao.descricao}">
				<f:facet name="header">
					<h:outputText value="Descrição" />
				</f:facet>
				<h:outputText value="#{listafuncao.descricao}" />
			</rich:column>

			<rich:column sortBy="#{listafuncao.tipoFuncao.nome}">
				<f:facet name="header">
					<h:outputText value="Tipo" />
				</f:facet>
				<h:outputText value="#{listafuncao.tipoFuncao.nome}" />
			</rich:column>

			<h:column>
				<f:facet name="header">
					<h:outputText value="Opções"></h:outputText>
				</f:facet>
				<!-- rint botao deletar e alterar-->
				<rich:toolTip for="btndeletar" followMouse="true" zorder="90"
					value="Deletar/Excluir" />
				<rich:toolTip for="btnalterar" followMouse="true" zorder="90"
					value="Alterar" />
				<h:commandButton image="/images/delete.png" id="btndeletar"
					action="#{construirPropostaBean.delfuncao}"
					disabled="#{construirPropostaBean.desabilitar}"
					style="height: 40px; width: 40px"></h:commandButton>
				<h:commandButton image="/images/editar.png" id="btnalterar"
					action="#{construirPropostaBean.editfuncao}"
					disabled="#{construirPropostaBean.desabilitar}"
					style="height: 40px; width: 40px"></h:commandButton>
			</h:column>
		</rich:dataTable>
		<!-- rint botao salvar-->
		<rich:toolTip for="btnsalvar" followMouse="true" zorder="90"
			value="clique para Salvar" />
		<rich:datascroller align="center" for="idtable" maxPages="5"
			fastControls="show" />
		<div align="right" style="width: 899px;"><h:commandButton
			value="Salvar" id="btnsalvar"
			disabled="#{construirPropostaBean.desabilitar}"
			action="#{construirPropostaBean.SalvarListaFuncao}" /> <rich:spacer
			height="30" /> <br>
		<br>
		</div>
		<br>
	
	</h:form>
</f:view>
