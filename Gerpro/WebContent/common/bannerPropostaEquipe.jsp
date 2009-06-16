<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
    <rich:simpleTogglePanel label="Dados da Equipe">
			<h:panelGrid columns="4">
				<h:outputText value="Proposta:" />
				<h:outputText value="#{construirPropostaBean.proposta.nome}" />
				<h:outputText value="Equipe:" />
				<h:outputText value="#{construirPropostaBean.proposta.equipe.nome}" />
				<h:outputLabel value="Status:" />
				<h:outputLabel value="#{construirPropostaBean.proposta.status.nome}" />
				<h:outputLabel value="Componentes:" />
				<rich:dataTable var="lstUsers" 
					value="#{construirPropostaBean.listaUsuarios}"
					rows="4"  frame="vsides"  align="center">
					<rich:column sortBy="#{lstUsers.nome}">
						<h:outputText value="#{lstUsers.nome}"/>						
					</rich:column>
				</rich:dataTable>
			</h:panelGrid>
		</rich:simpleTogglePanel>
