<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Cadastro de Categorias</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css"
	href="WEB_INF/css/estilos.css">
</head>

<f:view>
	<h:form>
		<div align="center"><h:outputLabel value="ALTERAR CATEGORIAS"
			styleClass="titulo" /></div>
		<rich:simpleTogglePanel focus="txtdesc1" label="Dados do cadastro">
			<h:panelGrid columns="5" cellpadding="5">
				<h:outputText value="Descrição:" />
				<h:inputText id="txtdesc1"
					value="#{categoriasBean.categorias.catDescricao}" />
				<h:commandButton value="Salvar" action="#{categoriasBean.alterar}"
					style="background-color:#D2691E;color:#FFFFFF; font-weight:bold;border: 1px outset" />
			</h:panelGrid>
			<h:outputText value="#{categoriasBean.msg}"
				style="color:red; font-weight:bold" />
		</rich:simpleTogglePanel>

		<h:panelGrid columns="1" width="90%" border="0">
			<h:panelGrid columns="1" border="0">
				<h:panelGroup>
					<h:commandButton action="#{categoriasBean.prepararBean}"
						value="Ir para o listar categorias"
						style=" width : 182; background-color:#D2691E;color:#FFFFFF; font-weight:bold;border;1px outset" />

				</h:panelGroup>
			</h:panelGrid>
		</h:panelGrid>
	</h:form>
</f:view>