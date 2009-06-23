<%@page	contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Cadastro de Artefatos</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css" href="../css/gerpro.css">
</head>

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
	<!--fim div menu-->
	<div id="content"><h:form>
	<h:messages tooltip="true" layout="list" showDetail="true"
				showSummary="true" rendered="true" errorClass="mensagem_erro"
				 infoClass="mensagem_sucesso"/>
		<div align="center"><h:outputLabel value="Alterar Artefatos"	styleClass="titulo"/></div>
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro">
			<h:panelGrid columns="5" cellpadding="5">
				<h:outputText value="Nome:" />
				<h:inputText id="txtdesc1"
					value="#{artefatosBean.artefatos.nome}" /> 
				<h:commandButton value="Salvar" action="#{artefatosBean.salvar}" />
			</h:panelGrid>
		</rich:simpleTogglePanel>
	</h:form></div>
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>