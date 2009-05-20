<?xml version="1.0" encoding="ISO-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich">

<f:view>
	<h:form id="form">
		<rich:panel label="Lista de Propostas">
			<rich:dataTable var="prop" id="listapropostas"
				value="#{propostaBean.listaPorProfessor}"
				binding="#{propostaBean.objDatatableProposta}">
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="C�digo" />
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
						<h:outputText value="Status" />
					</f:facet>
					<h:outputText value="#{prop.status.nome}"
						style="color:red; font-weight:bold; font-" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Op��es" />
					</f:facet>
					
					<h:commandLink value="Corrigir" action="#{propostaBean.preperarEdicao}"></h:commandLink>						
				</h:column>
			</rich:dataTable>
		</rich:panel>
	</h:form>
</f:view>
</html>