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
		<rich:simpleTogglePanel focus="txtdesc" label="Dados da Pesquisa">
			<h:panelGrid columns="5" cellpadding="10" rowClasses="2">
				<h:outputText value="Descrição:" />
				<h:inputText id="txtdesc" value="#{propostaBean.proposta.nome}" />
				<h:commandButton value="Pesquisar"
					action="#{propostaBean.pesquisar}"
					style="background-color:#D2691E;color:#FFFFFF; font-weight:bold;border: 1px outset" />
				<h:commandButton value="Novo"
					action="#{propostaBean.preperarInclusao}"
					style="background-color:#D2691E;color:#FFFFFF; font-weight:bold;border: 1px outset" />
					<h:commandButton value="Gerar Relatório" action="#{propostaBean.gerarRelatorio}"/>
			</h:panelGrid>

		</rich:simpleTogglePanel>
	</h:form>
	<h:form id="form2">
		<rich:simpleTogglePanel label="Resultado da Pesquisa">
			<rich:dataTable var="prop" id="listapropostas"
				value="#{propostaBean.listaProposta}"
				binding="#{propostaBean.objDatatableProposta}" rows="10"
				width="550px" align="center">
				<h:column>
					<f:facet name="header">
						<h:outputText value="Cod" />
					</f:facet>
					<h:outputText value="#{prop.id}" />
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
					<h:commandButton image="/imagens/delete.png"
						action="#{propostaBean.excluir}" />
					<h:commandButton image="/imagens/editar.png"
						action="#{propostaBean.preperarEdicao}" />
				</h:column>
			</rich:dataTable>
		</rich:simpleTogglePanel>
	</h:form>
</f:view>