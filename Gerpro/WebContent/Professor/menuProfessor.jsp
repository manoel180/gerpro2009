<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<br>
<h:panelGrid>
	<rich:panelMenu expandMode="ajax" style="width:170px" mode="ajax"
		iconExpandedGroup="disc" iconCollapsedGroup="disc" 
		iconExpandedTopGroup="chevronUp" iconGroupTopPosition="right"
		iconCollapsedTopGroup="chevronDown">

		<rich:panelMenuGroup label="Proposta" expanded="true">
			<rich:panelMenuItem label="Lista de Propostas"
				action="#{propostaBean.listaPorProfessor}" />
			<rich:panelMenuItem label="Missão do Produto"
				action="#{corrigirPropostaBean.prepararCorrigirMissao}" />
			<rich:panelMenuItem label="Lista de Função"
				action="#{corrigirPropostaBean.prepararCorrigirListaFuncao}" />
			<rich:panelMenuItem label="Justificativa"
				action="#{corrigirPropostaBean.prepararCorrigirJustificativa}" />
			<rich:panelMenuItem label="Metodologia"
				action="#{corrigirPropostaBean.prepararCorrigirMetodologia}" />
			<rich:panelMenuItem label="Cronograma"
				action="#{corrigirPropostaBean.prepararCorrigirCronograma}" />	
			<rich:panelMenuGroup label="Avaliação Geral">
				<rich:panelMenuItem label="Avaliação Geral - 1"
					action="#{corrigirPropostaBean.prepararAvaliacaoGeral1}" />
				<rich:panelMenuItem label="Avaliação Geral - 2"
					action="#{corrigirPropostaBean.prepararAvaliacaoGeral2}" />
				<rich:panelMenuItem label="Avaliação Geral - 3"
					action="#{corrigirPropostaBean.prepararAvaliacaoGeral7}" />
			</rich:panelMenuGroup>
			<rich:panelMenuItem label="Submeter Correção"
				action="#{corrigirPropostaBean.prepararSubmeterCorrecao}" />
		</rich:panelMenuGroup>		
		<rich:panelMenuGroup label="Sair" action="#{usuarioBean.sairAplicacao}" />

	</rich:panelMenu>
</h:panelGrid>
