<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Cadastro de Artefatos</title>
<!--Chamada ao arquivo CSS -->
<!-- link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css" -->
</head>

<f:view>
	<h:form>

		<div align="center"><h:outputLabel value="CADASTRO DE ARTEFATOS"
			styleClass="titulo" /></div>

		<h:messages tooltip="true" layout="list" showDetail="true"
				showSummary="true" rendered="true" errorClass="mensagem_erro"
				 infoClass="mensagem_sucesso"/>
		<br>
		<br>
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro">
			<h:panelGrid columns="5" cellpadding="5" style="height: 103px">
				<h:outputText value="Nome:" />
				<h:inputText id="txtdesc1" required="true"
					value="#{artefatosBean.artefatos.nome}">
					<f:attribute name="fieldRef" value="Equipe" />
				</h:inputText>

			</h:panelGrid>

			

		</rich:simpleTogglePanel>
<h:commandButton value="Salvar" action="#{artefatosBean.salvar}" />
		<h:panelGrid columns="1" width="90%" border="0">
			<h:panelGrid columns="1" border="0">
				<h:panelGroup>
					<h:commandButton action="#{artefatosBean.prepararBean}"
						value="Ir para o listar propostas" />
				</h:panelGroup>
			</h:panelGrid>
		</h:panelGrid>
		
	</h:form>
</f:view>