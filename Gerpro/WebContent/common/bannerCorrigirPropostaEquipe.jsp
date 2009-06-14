<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
    <rich:simpleTogglePanel label="Dados da Equipe">
			<h:panelGrid columns="1">
				<h:outputText value="Proposta:" />
				<h:outputText value="#{corrigirPropostaBean.proposta.nome}" />
				<h:outputText value="Equipe:" />
				<h:outputText value="#{corrigirPropostaBean.proposta.equipe.nome}" />
			</h:panelGrid>
		</rich:simpleTogglePanel>
