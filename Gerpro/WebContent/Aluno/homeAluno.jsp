<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@
taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Aluno - Página Inicial</title>
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
	<h:form>
	
		<h:messages layout="list" showDetail="true" showSummary="true"
			rendered="true" errorClass="mensagem_erro"
			infoClass="mensagem_sucesso" />
<br>
<br>
		
		<h:panelGrid columns="1" width="560">
			<h:outputLabel
			value="Olá, #{usuarioBean.logado.nome}" styleClass="Titulo1" />
		<br>
		<p style="font-family: sans-serif; font-size: 14;">Seja bem vindo
		ao GERPRO.<br>
		Para acessar os itens de sua prospota, basta escolher uma das opções
		do menu, que<br>
		sistema irá direcioná-lo a página do item escolhido! Divirta-se</p>
		</h:panelGrid>
	</h:form></div>
	<br>
	</div>
	
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>