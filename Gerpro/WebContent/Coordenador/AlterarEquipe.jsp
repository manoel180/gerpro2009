<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Cadastro de Equipes</title>
<!--Chamada ao arquivo CSS -->
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
	<!--fim div menu-->
	
	
<br>
		<h:outputLabel value="ALTERAR EQUIPE" styleClass="Titulo1" />

		<h:messages tooltip="true" layout="list" showDetail="true"
			showSummary="true" rendered="true" errorClass="mensagem_erro"
			infoClass="mensagem_sucesso" />		
		<br>
		<br>
		<div id="content">
			<h:panelGrid columns="1" cellpadding="5" width="560">
				<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro">
				<h:form>
					<h:panelGrid columns="1" cellpadding="5" width="99%">
						<h:outputText value="Nome*:"  styleClass="Obrigatorio"/>
						<h:inputText id="txtdesc1" value="#{equipeBean.equipe.nome}" required="true">
							<f:attribute name="fieldRef" value="Nome" />
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



