<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Missão</title>
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
	<br>
	
	<%@include file="menuProfessor.jsp"%></div>
	<br/>
		
	<div id="content">



	<div align="center"><h:outputLabel value="CORREÇÃO MISSÃO DO PRODUTO"
		styleClass="Titulo1" /></div>


	<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
		showSummary="true" />
	<br>

	<h:panelGrid columns="3">
		
		<rich:simpleTogglePanel label="#{corrigirPropostaBean.proposta.nome}">
			<h:panelGrid columns="1" cellpadding="5" style="width: 536px">
				<h:outputText value="Missão do Produto:" />
				<rich:editor height="50" width="467" theme="advanced"
					readonly="true" style="width: px"
					value="#{corrigirPropostaBean.propostaitem.conteudoItem}" />
			</h:panelGrid>
		</rich:simpleTogglePanel>
	</h:panelGrid>

	
	<h:form>
	   
		<%@include file="perguntasCorrecao.jsp"%>
		
		<!-- hint botao salvar-->
		<rich:toolTip for="btnsalvar" followMouse="true" zorder="90"
			value="clique para Salvar" />
		
		
		<br>
		<div align="left">
		<h:commandButton id="btnsalvar" value="Salvar"
			action="#{corrigirPropostaBean.salvarCorrigir}"
			disabled="#{corrigirPropostaBean.desabilitar}" />
	</h:form>
			
		</div>
	</div>
 </f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé -->
		<br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>