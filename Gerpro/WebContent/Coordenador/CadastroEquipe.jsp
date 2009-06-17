<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Cadastro de Equipe</title>
<link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>

<f:view>
	<h:form>

		<div align="center"><h:outputLabel value="CADASTRO DE EQUIPES"
			styleClass="titulo" /></div>

		<h:messages layout="list" styleClass="Obrigatorio" showDetail="true"
			showSummary="true" />
		<br>
		<br>
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro">
			<h:panelGrid columns="5" cellpadding="5" style="height: 103px">
				<h:outputText value="Nome:" />
				<h:inputText id="txtdesc1" required="true"
					value="#{equipeBean.equipe.nome}">
					<f:attribute name="fieldRef" value="Equipe" />
				</h:inputText>

			</h:panelGrid>

			

		</rich:simpleTogglePanel>
<h:commandButton value="Salvar" action="#{equipeBean.salvar}" />		
	</h:form>
</f:view>