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
	<br>
	
	<%@include file="menuProfessor.jsp"%></div>
	<br/>

	<h:outputLabel value="CORREÇÃO MISSÃO"
		styleClass="Titulo1" />


	<h:messages tooltip="true" layout="list" showDetail="true"
				showSummary="true" rendered="true" errorClass="mensagem_erro"
				 infoClass="mensagem_sucesso"/>
	<br>		
	<div id="content">


	<h:panelGrid columns="1" width="560">
		
		<rich:simpleTogglePanel label="#{corrigirPropostaBean.proposta.nome}">
			<h:panelGrid columns="1" cellpadding="5" width="99%">
				
				<rich:editor height="50" width="467" theme="advanced"
					readonly="true"
					value="#{corrigirPropostaBean.propostaitem.conteudoItem}" />
			</h:panelGrid>
		</rich:simpleTogglePanel>
	</h:panelGrid>

	
	   
		<%@include file="perguntasCorrecao.jsp"%>
			</div>
		</div>
	
 </f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé -->
		<br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>