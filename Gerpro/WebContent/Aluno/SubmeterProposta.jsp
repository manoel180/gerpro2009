<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Submeter Proposta</title>
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
	<%@include file="menuAluno.jsp"%></div>
	<br />

	<div id="content">

	<h:outputLabel value="SUBMETER PROPOSTA" styleClass="Titulo1" />

	<h:messages layout="list" showDetail="true" showSummary="true"
		rendered="true" errorClass="mensagem_erro"
		infoClass="mensagem_sucesso" /> <br>
	
	<h:panelGrid columns="1" width="560">
		<rich:simpleTogglePanel label="#{construirPropostaBean.proposta.nome}"
			width="99%">
			<h:form>
				<rich:dataTable var="itens" id="listapropostasitens"
					value="#{submeterPropostaBean.listaPropostaItem}"
					binding="#{submeterPropostaBean.objDatatablePropostaItem}"
					rows="10" width="99%" align="center">
					<h:column>
						<f:facet name="header">
							<h:outputText value="Item"></h:outputText>
						</f:facet>
						<h:outputText value="#{itens.item.nome}"></h:outputText>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Status"></h:outputText>
						</f:facet>
						<h:outputText value="#{itens.status.nome}"
							style="color:red; width: 5px;  font-weight:bold;"></h:outputText>
					</h:column>
				</rich:dataTable>
			</h:form>
		</rich:simpleTogglePanel>

		<h:commandButton value="Submeter"
			disabled="#{submeterPropostaBean.desabilita}"
			action="#{submeterPropostaBean.submeterProposta}" />

		<br>
	</h:panelGrid>
	</div>
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>