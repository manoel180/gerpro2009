<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Correção da Lista de Funções</title>
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
	<br>
	<%@include file="menuProfessor.jsp"%></div>
	<br/>
	<h:outputLabel value="CORREÇÃO LISTA DE FUNÇÕES"
		styleClass="Titulo1" />
	<h:messages tooltip="true" layout="list" showDetail="true"
				showSummary="true" rendered="true" errorClass="mensagem_erro"
				 infoClass="mensagem_sucesso"/>
<br>		<br>
	<div id="content">

	<h:panelGrid columns="1" width="560">
		
		<rich:simpleTogglePanel label="#{corrigirPropostaBean.proposta.nome}" width="99%">
			<h:form>
				<h:panelGrid columns="1" cellpadding="5" width="99%">

					<rich:dataTable id="idtable" var="listafuncao"
						value="#{corrigirPropostaBean.lstListaFuncao}" rows="5"
						width="99%" align="center">
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
							<h:outputLabel escape="false"  value="#{listafuncao.uc}" />
						</rich:column>

						<rich:column sortBy="#{listafuncao.descricao}">
							<f:facet name="header">
								<h:outputLabel value="Descrição" />
							</f:facet>
							<h:outputLabel escape="false" value="#{listafuncao.descricao}" />
						</rich:column>

						<rich:column sortBy="#{listafuncao.tipoFuncao.nome}">
							<f:facet name="header">
								<h:outputLabel value="Tipo" />
							</f:facet>
							<h:outputLabel escape="false" value="#{listafuncao.tipoFuncao.nome}" />
						</rich:column>

					</rich:dataTable>
					<rich:datascroller align="center" for="idtable" maxPages="5"
						fastControls="show" />
					<rich:spacer height="30" />
				</h:panelGrid>
			</h:form>
		</rich:simpleTogglePanel>
	</h:panelGrid>

	<br>
	
		<%@ include file="perguntasCorrecao.jsp"%>
			
		</div>
	</div>
 </f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé -->
		<br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>