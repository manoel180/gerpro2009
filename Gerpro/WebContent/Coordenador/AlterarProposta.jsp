<%@page	contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Alterar Proposta</title>
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
	<%@ include file="menuCoordenador.jsp"%>
	</div><!--fim div menu-->
	<div id="content">

	<h:form>

		<div align="center"><h:outputLabel  value="ALTERAR PROPOSTA" 
		styleClass="Titulo1" /></div>

		<h:messages layout="list" styleClass="" showDetail="true"
			showSummary="true" />
		<br>
		<br>
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro">
			<h:panelGrid columns="2" cellpadding="5" id="id1">
				<h:outputText value="Nome:" />
				<h:inputText maxlength="100" id="txtdesc1" required="true"
					value="#{propostaBean.proposta.nome}">
					<f:attribute name="fieldRef" value="Proposta" />
				</h:inputText>
				
				<h:outputText value="Equipe:" />
				<h:selectOneMenu id="equipe" value="#{propostaBean.equipe.id}" disabled="true" rendered="true" required="true">					
					<f:selectItems value="#{propostaBean.equipesCombo}"/>
					<f:attribute name="fieldRef" value="Equipe" />	
				</h:selectOneMenu>
				
				<h:outputText value="Data Criação:" />	
				<rich:calendar id="dt_criacao" disabled="true" value="#{propostaBean.proposta.dataCriacao}" required="true">
					<f:attribute name="fieldRef" value="Data Criação" />
				</rich:calendar>
	
				<h:outputText value="Periodo:" />
				<h:inputText id="txtperiodo" value="#{propostaBean.proposta.periodo}" disabled="true">
					<f:attribute name="fieldRef" value="P" />
				</h:inputText>
				
			</h:panelGrid>

			

		</rich:simpleTogglePanel>
			<h:commandButton value="Salvar" action="#{propostaBean.salvar}" />
	</h:form>

   </div >
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>
