<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Cadastro de Usuários</title>
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
	<%@ include file="menuCoordenador.jsp"%></div>

	<div id="content">


	<div align="center"><h:outputLabel value="CADASTRO DE USUÁRIOS"
		styleClass="Titulo1" /></div>

	<h:messages layout="list" showDetail="true"
				showSummary="true" rendered="true" errorClass="mensagem_erro"
				 infoClass="mensagem_sucesso"/> <br>
	<br>
	<rich:toolTip for="rbtTipo" followMouse="true" zorder="90"	value="Selecione um tipo de usuário" />
	<rich:toolTip for="txtmat" followMouse="true" zorder="90" value="Informe a matricula" /> 
	<rich:toolTip for="txtnome" followMouse="true" zorder="90" value="Inserir o nome do usuário" /> 
	<rich:toolTip for="equipe" followMouse="true" zorder="90" value="Selecione uma equipe para o aluno" /> 
	<rich:toolTip for="btnsalvar" followMouse="true" zorder="90" value="Clique para Salvar" />
	<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro" style="text-align:left">
		
		<h:form>
			<h:panelGrid columns="2" cellpadding="5" id="pg">
				<h:outputText value="Tipo:" />
				<h:selectOneMenu id="rbtTipo" required="true" value="#{usuarioBean.tipoUsuario.id}">
					<f:selectItem itemLabel="Aluno" itemValue="1" />
					<f:selectItem itemLabel="Professor" itemValue="2" />
					<f:selectItem itemLabel="Coordenador" itemValue="3" />
						<a4j:support event="onchange" ajaxSingle="true"	
							action="#{usuarioBean.desabilitarComponente}" reRender="pg"/>	
				</h:selectOneMenu>

				<h:outputText value="Matricula:" />
				<h:inputText id="txtmat" maxlength="8" required="true" size="10"
					value="#{usuarioBean.usuario.matricula}">
					<f:attribute name="fieldRef" value="Matricula" />
				</h:inputText>

				<h:outputText value="Nome:" />
				<h:inputText id="txtnome" maxlength="80" required="true" size="40"
					value="#{usuarioBean.usuario.nome}">
					<f:attribute name="fieldRef" value="Nome" />
				</h:inputText>


				<h:outputText value="Equipe:" rendered="#{usuarioBean.desabilitar}" />
				<h:selectOneMenu id="equipe"
					value="#{usuarioBean.usuario.equipe.id}" rendered="#{usuarioBean.desabilitar}">
					<f:selectItems value="#{usuarioBean.equipesCombo}" />
					<f:attribute name="fieldRef" value="Equipe" />
				</h:selectOneMenu>

				<div align="left">
				<h:commandButton id="btnsalvar" value="Salvar" action="#{usuarioBean.salvar}" />
				</div>
			</h:panelGrid>
		</h:form>


	</rich:simpleTogglePanel></div>
	</div>

</f:view>


<div class="fontBranca" id="rodape"><!-- Rodapé --> <br />
GerPro - Sistema de Gera&ccedil;&atilde;o e Apoio a
Corre&ccedil;&atilde;o de PESw &copy; Copyright</div>
