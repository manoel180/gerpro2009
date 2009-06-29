<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Cadastro de Equipe</title>
<link href="../css/gerpro.css" rel="stylesheet" type="text/css" />
<link href="css/gerpro.css" rel="stylesheet" type="text/css" />
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
<br>
		<h:outputLabel value="CADASTRO DE EQUIPES"
			styleClass="Titulo1" />

		<h:messages tooltip="true" layout="list" showDetail="true"
			showSummary="true" rendered="true" errorClass="mensagem_erro"
			infoClass="mensagem_sucesso" />
	
	<br>
		<br>
	<div id="content">
		<h:panelGrid  cellpadding="5" width="560">
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro" width="99%">
			<h:form id="form1">
			<h:panelGrid columns="2" cellpadding="5" width="">
				<h:outputText value="Nome*:" styleClass="Obrigatorio"/>
				<h:inputText maxlength="50" id="txtdesc1" required="true"
					value="#{equipeBean.equipe.nome}">
					<f:attribute name="fieldRef" value="Equipe" />
				</h:inputText>
				<h:commandButton value="Salvar" action="#{equipeBean.salvar}" />
			</h:panelGrid>

			</h:form>
		</rich:simpleTogglePanel>
		
	</h:panelGrid>

	</div>
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>





