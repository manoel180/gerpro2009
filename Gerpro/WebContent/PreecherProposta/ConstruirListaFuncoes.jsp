<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Funções</title>
<!--Chamada ao arquivo CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilos.css">
</head>





<f:view>
	<h:form>

		<div align="center"><h:outputLabel value="FUNÇÕES"
			styleClass="Titulos" /></div>

		<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
			showSummary="true" />

		<br>
		
		<h:panelGrid columns="3">	
		<%@ include file="../templates/menu.jsp" %>			

			<rich:simpleTogglePanel label="Dados do cadastro">
				<h:panelGrid columns="1" cellpadding="5" style="width: 798px">
					
					<h:outputText value="Ordem:" />
					<h:inputTextarea value="#{construirPropostaBean.listafuncaoid.numeroSequencia}" style="width: 762px; height: 57px" />
					
					
					<h:outputText value="Caso de Uso:" />
					<h:inputTextarea value="#{construirPropostaBean.listaFuncao.uc}" style="width: 762px; height: 57px" />
					

					<h:outputText value="Descrição:" />
					<h:inputTextarea value="#{construirPropostaBean.listaFuncao.descricao}" style="width: 762px; height: 57px" />
					
					<h:outputText value="Tipo de Função:" />
					<h:selectOneMenu value="#{construirPropostaBean.tipofuncao.id}" >					
						<f:selectItems value="#{construirPropostaBean.tipoFuncaoCombo}"/>	
					</h:selectOneMenu>
					
					<h:commandButton value="Adicionar" action="#{construirPropostaBean.addfuncao}"/>
					
				</h:panelGrid>
			</rich:simpleTogglePanel>
		</h:panelGrid>

		<rich:dataTable id="idtable" var="listafuncao" value="#{construirPropostaBean.lstlistaFuncao}" binding="#{construirPropostaBean.objDatatableListaFuncao}" rows="10" width="550px" align="center">
				<h:column>
					<f:facet name="header">
						<h:outputText value="Ordem"></h:outputText>
					</f:facet>
					<h:outputText value="#{listafuncao.id.numeroSequencia}"></h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Caso de Uso"></h:outputText>
					</f:facet>
					<h:outputText value="#{listafuncao.uc}" style="color:red; font-weight:bold; font-"></h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Descrição"></h:outputText>
					</f:facet>
					<h:outputText value="#{listafuncao.descricao}" style="color:red; font-weight:bold; font-"></h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Tipo"></h:outputText>
					</f:facet>
					<h:outputText value="#{listafuncao.tipoFuncao.nome}" style="color:red; font-weight:bold; font-"></h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Opções"></h:outputText>
					</f:facet>
					<h:commandButton image="/images/delete.png" action="#{construirPropostaBean.delfuncao}" style="height: 40px; width: 40px"></h:commandButton>
					<h:commandButton image="/images/editar.png" action="#{construirPropostaBean.editfuncao}" style="height: 40px; width: 40px"></h:commandButton>
				</h:column>
			</rich:dataTable><br><br><h:commandButton value="Salvar" action="#{construirPropostaBean.SalvarListaFuncao}" />
		<h:panelGrid columns="1" width="90%" border="0">
			<h:panelGrid columns="1" border="0">
				<h:panelGroup>
					<h:commandButton action="#{propostaBean.prepararBean}"
						value="Ir para o listar propostas" />
				</h:panelGroup>
			</h:panelGrid>
		</h:panelGrid>

	</h:form>

</f:view>