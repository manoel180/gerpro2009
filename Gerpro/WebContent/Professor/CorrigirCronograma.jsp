<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Correção do Cronograma</title>
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
	<br />
	<h:outputLabel value="CORREÇAO CRONOGRAMA"
		styleClass="Titulo1" />

	<h:messages tooltip="true" layout="list" showDetail="true"
		showSummary="true" rendered="true" errorClass="mensagem_erro"
		infoClass="mensagem_sucesso" /> <br><br>

	<div id="content">

	<h:panelGrid columns="1" width="560">

		<rich:simpleTogglePanel width="99%"
			label="#{corrigirPropostaBean.proposta.nome}">
			<h:form>
				<rich:dataTable id="idtable" var="lstCronograma"
					value="#{corrigirPropostaBean.lstCronograma}" rows="10"
					width="99%" align="center">
					<rich:column sortBy="#{lstCronograma.dataInicial}">
						<f:facet name="header">
							<h:outputText value="Data Inicial" />
						</f:facet>
						<h:outputText value="#{lstCronograma.dataInicial}">
							<f:convertDateTime dateStyle="short" type="date"
								pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column sortBy="#{lstCronograma.dataFinal}">
						<f:facet name="header">
							<h:outputText value="Data Final" />
						</f:facet>
						<h:outputText value="#{lstCronograma.dataFinal}">
							<f:convertDateTime dateStyle="short" type="date"
								pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column width="5%" sortBy="#{lstCronograma.artefatos.nome}">
						<f:facet name="header">
							<h:outputText value="Eventos/Artefatos" />
						</f:facet>
						<h:outputText value="#{lstCronograma.artefatos.nome}" />
					</rich:column>

				</rich:dataTable>
			</h:form>
		</rich:simpleTogglePanel>
	</h:panelGrid> <br>

		<%@ include file="perguntasCorrecao.jsp"%>
	
	</div>
	</div>
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>