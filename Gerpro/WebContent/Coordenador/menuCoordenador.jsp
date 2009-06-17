<%@page	pageEncoding="UTF-8"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<br>
<h:panelGrid>
	<rich:panelMenu expandMode="ajax"  style="width:160px"  mode="ajax"
        iconExpandedGroup="disc" iconCollapsedGroup="disc" 
        iconExpandedTopGroup="chevronUp" iconGroupTopPosition="right" 
        iconCollapsedTopGroup="chevronDown">
        
		<rich:panelMenuGroup label="Equipe">
			<rich:panelMenuItem label="Pesquisar" action="#{equipeBean.prepararBean}"  />
			<rich:panelMenuItem label="Cadastrar" action="#{equipeBean.prepararInclusao}"/>
		</rich:panelMenuGroup>
		
		<rich:panelMenuGroup label="Propostas">
			<rich:panelMenuItem label="Alocar"  />
			<rich:panelMenuItem label="Pesquisar" action="#{propostaBean.prepararBean}" />
			<rich:panelMenuItem label="Cadastrar" action="#{propostaBean.prepararInclusao}" />
		</rich:panelMenuGroup>
		
		<rich:panelMenuGroup label="Usuários">
			<rich:panelMenuItem label="Pesquisar"  />
			<rich:panelMenuItem label="Cadastrar"  />
		</rich:panelMenuGroup> 
		
		<rich:panelMenuGroup label="Relatórios"> 
			<rich:panelMenuItem label="Equipe x Proposta" action="#{relatorioBean.prepararRelatorioPropostaEquipe}"/>
			<rich:panelMenuItem label="Média das Proposta" action="#{relatorioBean.prepararRelatorioResultadoProposta}" />
		</rich:panelMenuGroup>
		
		<rich:panelMenuGroup label="Sair"/>
	</rich:panelMenu>
</h:panelGrid>