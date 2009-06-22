<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Relatórios de Propostas</title>
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
	<%@include file="../Coordenador/menuCoordenador.jsp"%></div>
	<br/>
		
	<div id="content">


		
		<div align="center"><h:outputLabel value="RELATÓRIOS"
		styleClass="Titulo1" /></div>


	<h:messages layout="list" showDetail="true" showSummary="true" />
	
	<br>
	<h:form>
		<rich:simpleTogglePanel focus="txtdesc1">
			<h:panelGrid columns="2" id="id1">
				<h:outputText value="Relatório" />
				<h:selectOneRadio id="radio" layout="pageDirection" value="#{relatorioBean.tipo}">
					<f:selectItem itemValue="1" itemLabel="Relatório Equipe x Proposta" />
					<f:selectItem itemValue="2" itemLabel="Relatório Resultados Proposta" />
				</h:selectOneRadio>
				
				<h:outputText value="Periodo:" />
				<h:selectOneMenu id="combo"
					value="#{relatorioBean.proposta.periodo}">
					<f:selectItems value="#{relatorioBean.periodoCombo}" />
				</h:selectOneMenu>
			</h:panelGrid>
			
		</rich:simpleTogglePanel>
		<div  align="left">
		<h:commandButton value="Visualizar"
			action="#{relatorioBean.exibir}" />
          

	</h:form>
			</div>
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé -->
		<br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>