<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
	<h:form id="form">
		<rich:panel >
			<rich:dataTable var="prop" id="listapropostas"
				value="#{propostaBean.listaPorProfessor}"
				binding="#{propostaBean.objDatatableProposta}">
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Código" />
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
						<h:outputText value="Opções" />
					</f:facet>
					
					<h:commandLink value="Corrigir" action="#{propostaBean.preperarEdicao}"></h:commandLink>						
				</h:column>
			</rich:dataTable>
		</rich:panel>
	</h:form>
</f:view>
