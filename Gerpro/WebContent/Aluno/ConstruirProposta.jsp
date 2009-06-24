<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Construir Proposta</title>
</head>
<!--Chamada ao arquivo CSS -->
<link href="../css/gerpro.css" rel="stylesheet" type="text/css" />

<div id="topo"> <!-- Início da DIV do Topo -->
<div id="topo_linha"></div> <!-- DIV Linha Cinza -->
<div id="banner"></div> <!-- DIV Banner Gerpro--></div> <!-- Fim da DIV do Topo -->


<f:view>
<div id="div_corpo">
<div id="menu">
	<br />
	<br />
	<%@ include file="menuAluno.jsp">
</div>

<div id="content">
	<h:form>	
		<p style="font-family: sans-serif; font-size: 14;">Esta  é a página inicial 
		para construir sua proposta. Acessando os itens no menu ao lado, você será
		redirecionado à todos os componentes de sua proposta que devem ser preenchidos e,
		ao fim, poderá submetê-la para a avaliação dos professores. Bom trabalho!<br>
	</p>

		<div align="center"><h:outputLabel value="CONSTRUIR PROPOSTA"
			styleClass="Titulos" /></div>

		<h:messages layout="list" showDetail="true"
				showSummary="true" rendered="true" errorClass="mensagem_erro"
				 infoClass="mensagem_sucesso"/>

		<br>
		
		<br><%@include file="../common/bannerSubmeterPropostaEquipe.jsp"%>	

	</h:form>
</div>
</div>
</f:view>

<div class="fontBranca" id="rodape"><!-- Rodapé -->
<br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a Corre&ccedil;&atilde;o de PESw &copy; Copyright</div> 