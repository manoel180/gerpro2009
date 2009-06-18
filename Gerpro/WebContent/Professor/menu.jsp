<%@page	pageEncoding="UTF-8"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<rich:simpleTogglePanel label="Menu Itens">
	<rich:panelMenu expandMode="ajax" label="Itens">
		<rich:panelMenuItem label="Missão"
			action="#{corrigirPropostaBean.prepararCorrigirMissao}" />
		<rich:panelMenuItem label="Lista de Funções"
			action="#{corrigirPropostaBean.prepararCorrigirListaFuncao}" />
		<rich:panelMenuItem label="Justificativa"
			action="#{corrigirPropostaBean.prepararCorrigirJustificativa}" />
		<rich:panelMenuItem label="Metodologia"
			action="#{corrigirPropostaBean.prepararCorrigirMetodologia}" />
		<rich:panelMenuItem label="Cronograma"
			action="#{corrigirPropostaBean.prepararCorrigirCronograma}" />
		<rich:panelMenuItem label="Avaliação Geral"
			action="#{corrigirPropostaBean.prepararAvaliacaoGeral}" />
		<rich:panelMenuItem label="Submeter Correção"
			action="#{corrigirPropostaBean.prepararSubmeterCorrecao}" />
		<rich:panelMenuItem label="Logoff"
			action="#{corrigirPropostaBean.sairAplicacao}" />
	</rich:panelMenu>
</rich:simpleTogglePanel>