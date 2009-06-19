<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- link href="css/gerpro.css" rel="stylesheet" type="text/css" -->
<head>
<title>Seja Bem Vindo ao GERPRO</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css" href="css/gerpro.css" />
</head>


<div id="topo"><!-- Início da DIV do Topo -->
<div id="topo_linha"></div>
<!-- DIV Linha Cinza -->
<div id="banner"></div>
<!-- DIV Banner Gerpro--></div>
<!-- Fim da DIV do Topo -->

<f:view>
	<div id="div_corpo" align="center"><!-- Início DIV Content  -->

	<div
		style="width: 300px; height: 150px; text-align: right; float: left; vertical-align: middle; margin-top: 100px"><img
		src="images/login.jpg" /></div>
	<div
		style="width: 300px; height: 150px; text-align: left; float: left; margin-top: 120px">
	<h:form>
		<h:outputFormat styleClass="fontAzul"
			value="Informe seu login e senha para ter acesso ao GERPRO." />
		<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
			showSummary="true" />
		<br>
		<br>
		<h:outputText styleClass="fontAzul" value="Matricula*: "
			style=" width : 124px;" />
		<h:inputText styleClass="form_superior" id="matricula" required="true"
			value="#{usuarioBean.usuario.matricula}">
			<f:attribute name="fieldRef" value="Matricula" />
		</h:inputText>
		<br />
		<br />
		<h:outputText styleClass="fontAzul" value="Senha*: " />
				&nbsp;&nbsp;
				<h:inputSecret styleClass="form_superior" id="senha" required="true"
			value="#{usuarioBean.usuario.senha}" style=" width : 130px;">
			<f:attribute name="fieldRef" value="Senha" />
		</h:inputSecret>
		<br />
		<br />
		<h:commandButton value="Entrar" action="#{usuarioBean.logar}" />
	</h:form></div>
	</div>
</f:view>
<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>
