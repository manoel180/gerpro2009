<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>Pesquisar Categorias</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css"
	href="WEB-INF/css/estilos.css">
</head>
<f:view>
	<h:form id="form1">
		<div align="center"><h:outputLabel value="PESQUISAR PROPOSTAS"
			styleClass="titulo" /></div>		
			<h:panelGrid columns="5" cellpadding="10" rowClasses="2">
				<h:outputText value="Descrição:" />
				<h:inputText id="txtdesc" value="#{propostaBean.proposta.nome}" />
				<h:commandButton value="Pesquisar"
					action="#{propostaBean.pesquisar}" />
				<h:commandButton value="Novo"
					action="#{propostaBean.preperarInclusao}" />
					<h:commandButton value="Gerar Relatório" action="#{propostaBean.gerarRelatorio}"/>
			</h:panelGrid>


	</h:form>
	<h:form id="form2">
		
			<rich:dataTable var="prop" id="listapropostas"
				value="#{propostaBean.listaProposta}"
				binding="#{propostaBean.objDatatableProposta}" rows="10"
				width="550px" align="center">
				<h:column>
					<f:facet name="header">
						<h:outputText value="Cod" />
					</f:facet>
					<h:outputText value="#{prop.id}" 
					style="color:red; font-weight:bold; font-"  />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{prop.nome}"
						style="color:red; font-weight:bold; font-" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Equipe" />
					</f:facet>
					<h:outputText value="#{prop.equipe.nome}"
						style="color:red; font-weight:bold; font-" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Opções" />

					</f:facet>
					<h:commandButton image="/images/delete.png"
						action="#{propostaBean.excluir}" style="height: 40px; width: 40px"/>
					<h:commandButton image="/images/editar.png"
						action="#{propostaBean.preperarEdicao}" style="height: 40px; width: 40px"/>
				</h:column>
			</rich:dataTable>
			<rich:datascroller  boundaryControls="auto" stepControls="auto"  align="center" for="listapropostas" maxPages="10"
            page="#{dataTableScrollerBean.scrollerPage}" />
        <rich:spacer height="30" />

	</h:form>
</f:view>