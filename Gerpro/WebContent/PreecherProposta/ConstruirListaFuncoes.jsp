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
				<rich:column sortBy="#{listafuncao.id.numeroSequencia}">
					<f:facet name="header">
						<h:outputText value="Ordem" />
					</f:facet>
					<h:outputText value="#{listafuncao.id.numeroSequencia}" />
				</rich:column>
				
				<rich:column sortBy="#{listafuncao.uc}">
					<f:facet name="header">
						<h:outputText value="Caso de Uso" />
					</f:facet>
					<h:outputText value="#{listafuncao.uc}" />
				</rich:column>

				<rich:column sortBy="#{listafuncao.descricao}">
					<f:facet name="header">
						<h:outputText value="Descrição" />
					</f:facet>
					<h:outputText value="#{listafuncao.descricao}" />
				</rich:column>

				<rich:column sortBy="#{listafuncao.tipoFuncao.nome}">
					<f:facet name="header">
						<h:outputText value="Tipo" />
					</f:facet>
					<h:outputText value="#{listafuncao.tipoFuncao.nome}" />
				</rich:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Opções"></h:outputText>
					</f:facet>
					<h:commandButton image="/images/delete.png" action="#{construirPropostaBean.delfuncao}" style="height: 40px; width: 40px"></h:commandButton>
					<h:commandButton image="/images/editar.png" action="#{construirPropostaBean.editfuncao}" style="height: 40px; width: 40px"></h:commandButton>
				</h:column>
			</rich:dataTable>
			<rich:datascroller  align="center" for="idtable" maxPages="10"  fastControls="show"  />
        <rich:spacer height="30" />
        
			<br><br><h:commandButton value="Salvar" action="#{construirPropostaBean.SalvarListaFuncao}" />
		<br><%@include file="../common/bannerPropostaEquipe.jsp"%>

	</h:form>

</f:view>