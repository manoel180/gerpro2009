<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pesquisar Artefatos</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css" href="WEB-INF/css/estilos.css" >

</head>
<f:view>
	<h:form id="form1">
	<div align="center"><h:outputLabel value="PESQUISAR ARTEFATOS"	styleClass="titulo"/></div>
		<rich:simpleTogglePanel focus="txtdesc" label="Dados da Pesquisa">
			<h:panelGrid columns="5" cellpadding="10" rowClasses="2">
				<h:outputText value="Nome:" />
				<h:inputText id="txtdesc"
					value="#{artefatosBean.artefatos.nome}" />
				<h:commandButton value="Pesquisar"
					action="#{artefatosBean.pesquisar}"/> 
				<h:commandButton value="Novo"
					action="#{artefatosBean.preperarInclusao}"/>
			</h:panelGrid>
			
		</rich:simpleTogglePanel>
	</h:form>
	<h:form id="form2">
		<rich:simpleTogglePanel label="Resultado da Pesquisa">
			<rich:dataTable var="art" id="listaArtefatos"
				value="#{artefatosBean.listaArtefatos}"
				binding="#{artefatosBean.objDatatableArtefatos}" rows="10"
				width="550px" align="center">
				<h:column>
					<f:facet name="header">
						<h:outputText value="Cod" />
					</f:facet>
					<h:outputText value="#{art.id}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Artefatos" />
					</f:facet>
					<h:outputText value="#{art.nome}"
					style="color:red; font-weight:bold; font-" />
					
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Opções" />
						
					</f:facet>
					<h:commandButton value="Excluir"
						action="#{artefatosBean.excluir}" />
					<h:commandButton value="Editar"
						action="#{artefatosBean.preperarEdicao}" />
				</h:column>
			</rich:dataTable>
		</rich:simpleTogglePanel>
	</h:form>
</f:view>