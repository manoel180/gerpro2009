<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Alterar Proposta</title>
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
	<%@ include file="menuCoordenador.jsp"%></div>
	<br>
	<!--fim div menu--> 
	<h:outputLabel value="ALTERAR PROPOSTA"	styleClass="Titulo1" /> 
	<h:messages tooltip="true" layout="list"
		showDetail="true" showSummary="true" rendered="true"
		errorClass="mensagem_erro" infoClass="mensagem_sucesso" />
		 <br>
	<br>
	<div id="content"><h:panelGrid columns="2" cellpadding="5"
		width="560">
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro"
			width="99%">
			<h:form>
				<h:panelGrid columns="1" cellpadding="5" width="99%" id="id1">
					<h:outputText value="Nome*:" styleClass="Obrigatorio" />
					<h:inputText maxlength="100" id="txtdesc1" required="true"
						value="#{propostaBean.proposta.nome}">
						<f:attribute name="fieldRef" value="Proposta" />
					</h:inputText>

					<h:outputText value="Equipe:" />
					<h:selectOneMenu id="equipe" value="#{propostaBean.equipe.id}"
						disabled="true">
						<f:selectItems value="#{propostaBean.equipesAlterarCombo}" />
					</h:selectOneMenu>

					<h:outputText value="Data de criação:" />
					<h:inputText id="txtdata"
						value="#{propostaBean.proposta.dataCriacao}" disabled="true"></h:inputText>

					<h:outputText value="Periodo:" />
					<h:inputText id="txtperiodo"
						value="#{propostaBean.proposta.periodo}" disabled="true"></h:inputText>
				</h:panelGrid>
				<h:commandButton value="Salvar" action="#{propostaBean.salvar}" />
			</h:form>
		</rich:simpleTogglePanel>

	</h:panelGrid></div>

	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>
