<%@page	pageEncoding="UTF-8"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<br>
<h:panelGrid >
	<rich:panelMenu expandMode="ajax"  style="width:160px"  mode="ajax"
        iconExpandedGroup="disc" iconCollapsedGroup="disc" 
        iconExpandedTopGroup="chevronUp" iconGroupTopPosition="right" 
        iconCollapsedTopGroup="chevronDown">
        
		<rich:panelMenuGroup label="Equipe">
			<rich:panelMenuItem label="Pesquisar" action="#{equipeBean.prepararBean}"  />
			<rich:panelMenuItem label="Cadastrar" action="#{equipeBean.prepararInclusao}"/>
		</rich:panelMenuGroup>
		
		<rich:panelMenuGroup label="Propostas">
			<rich:panelMenuItem label="Alocar"  action="#{alocarBean.prepararBean}"/>
			<rich:panelMenuItem label="Cadastrar" action="#{propostaBean.prepararBean}" />			
		</rich:panelMenuGroup>
		
		<rich:panelMenuGroup label="Usuários">
			<rich:panelMenuItem label="Alocar" action="#{alocarBean.preparaAlocarAlunoEquipe}" />
			<rich:panelMenuItem label="Pesquisar" action="#{usuarioBean.prepararPesquisar}" />
			<rich:panelMenuItem label="Cadastrar" action="#{usuarioBean.prepararInclusao}" />
			
		</rich:panelMenuGroup> 
		
		<rich:panelMenuGroup label="Relatórios"> 
			<rich:panelMenuItem label="Equipe x Proposta" action="#{relatorioBean.prepararRelatorioPropostaEquipe}"/>
			<rich:panelMenuItem label="Média das Proposta" action="#{relatorioBean.prepararRelatorioResultadoProposta}" />
		</rich:panelMenuGroup>
		
		<rich:panelMenuGroup label="Correção"> 
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
		<rich:panelMenuGroup label="Alterar Senha" action="#{usuarioBean.prepararAlterarSenha}"/>
		<rich:panelMenuGroup label="Sair" action="#{usuarioBean.sairAplicacao}"/>
	</rich:panelMenu>
</h:panelGrid>