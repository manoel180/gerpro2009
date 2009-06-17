<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Missão</title>
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
	<%@include file="menu.jsp"%></div>
	<br/>
		
	<div id="content"><h:form>


	<div align="center"><h:outputLabel value="CORREÇÃO MISSÃO DO PRODUTO"
		styleClass="Titulo1" /></div>


	<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
		showSummary="true" />
	<br>

	<h:panelGrid columns="3">
		
		<rich:simpleTogglePanel label="#{corrigirPropostaBean.proposta.nome}">
			<h:panelGrid columns="1" cellpadding="5" style="width: 798px">
				<h:outputText value="Missão:" />
				<rich:editor height="100" width="600" theme="advanced"
					readonly="true" style="width: 769px"
					value="#{corrigirPropostaBean.propostaitem.conteudoItem}" />
			</h:panelGrid>
		</rich:simpleTogglePanel>
	</h:panelGrid>

	
	<h:form>
		<%@ include file="perguntasCorrecao.jsp"%>
		<h:commandButton value="Salvar"
			action="#{corrigirPropostaBean.salvarCorrigirMissao}"
			disabled="#{corrigirPropostaBean.desabilitar}" />
	</h:form>
			
		</div>
	</div>
 </f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé -->
		<br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>