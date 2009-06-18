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
		iconCollapsedTopGroup="chevronDown">

		<rich:panelMenuGroup label="Proposta">
			<rich:panelMenuItem value="Lista de Propostas"
				action="#{propostaBean.listaPorProfessor}" />
			<rich:panelMenuItem value="Missão do Produto"
				action="#{corrigirPropostaBean.prepararCorrigirMissao}" />
			<rich:panelMenuItem value="Lista de Função"
				action="#{corrigirPropostaBean.prepararCorrigirListaFuncao}" />
			<rich:panelMenuItem value="Justificativa"
				action="#{corrigirPropostaBean.prepararCorrigirJustificativa}" />
			<rich:panelMenuItem value="Metodologia"
				action="#{corrigirPropostaBean.prepararCorrigirMetodologia}" />
			<rich:panelMenuItem value="Avaliação Geral"
				 />
				
			<rich:panelMenuItem value="Submeter Correção"
				action="#{submeterCorrecaoBean.listaPorProfessor}" />
				
		</rich:panelMenuGroup>
		<rich:panelMenuGroup value="Sair" action="index.jsf" />

	</rich:panelMenu>
</h:panelGrid>
