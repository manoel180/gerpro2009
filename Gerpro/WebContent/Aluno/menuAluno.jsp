<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<br>
<h:panelGrid>
	<rich:panelMenu expandMode="ajax" style="width:160px" mode="ajax"
		iconExpandedGroup="disc" iconCollapsedGroup="disc"
		iconExpandedTopGroup="chevronUp" iconGroupTopPosition="right"
		iconCollapsedTopGroup="chevronDown" expandSingle="true">

		<rich:panelMenuGroup label="Itens" expanded="true">
			<rich:panelMenuItem label="Missão"
				action="#{construirPropostaBean.prepararMissao}" />
			<rich:panelMenuItem label="Lista de Funções"
				action="#{construirPropostaBean.prepararListaFuncao}" />
			<rich:panelMenuItem label="Justificativa"
				action="#{construirPropostaBean.prepararJustificativa}" />
			<rich:panelMenuItem label="Metodologia"
				action="#{construirPropostaBean.prepararMetodologia}" />
			<rich:panelMenuItem label="Cronograma"
				action="#{construirPropostaBean.prepararCronograma}" />
			<rich:panelMenuItem label="Submeter Proposta"
				action="#{submeterPropostaBean.prepararBean}" />				
		</rich:panelMenuGroup>		
		<rich:panelMenuGroup label="Sair" action="#{usuarioBean.sairAplicacao}" />
	</rich:panelMenu>
</h:panelGrid>