<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Justificativa</title>
</head>
<!--Chamada ao arquivo CSS -->
<link href="../css/gerpro.css" rel="stylesheet" type="text/css" />

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
	<br/>
		
	<div id="content"><h:form>

		
		<div align="center"><h:outputLabel value="JUSTIFICATIVA"
		styleClass="Titulo1" /></div>
		<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
			showSummary="true" />

		<br>

		<h:panelGrid columns="3">		

			<rich:simpleTogglePanel label="#{construirPropostaBean.proposta.nome}" width="300"
				height="129" style="width: 546px">
				<h:panelGrid columns="1" cellpadding="5">
					<h:outputText value="Justificativa:" />
					
					<rich:toolTip for="idjustificativa" followMouse="true" zorder="90"
						value="Clique para inserir" />

					<rich:editor id="idjustificativa" height="150" theme="advanced" width="490"
						style="width: 520px" readonly="#{construirPropostaBean.desabilitar}"
						value="#{construirPropostaBean.propostaItem.conteudoItem}" />
				</h:panelGrid>
			</rich:simpleTogglePanel>
		</h:panelGrid>
           
           <!-- hint botao salvar-->
		<rich:toolTip for="btnsalvar" followMouse="true" zorder="90"
			value="clique para Salvar" />
           <br>
          <div align="left">
		&nbsp;&nbsp;&nbsp;<h:commandButton id="btnsalvar" value="Salvar"
			disabled="#{construirPropostaBean.desabilitar}"
			action="#{construirPropostaBean.salvarJustificativa}" />
		<br>
	</h:form>
		
		</div>
	</div>
</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé -->
		<br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>