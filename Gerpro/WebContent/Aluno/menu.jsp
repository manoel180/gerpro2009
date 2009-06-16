<%@page	pageEncoding="UTF-8"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<rich:simpleTogglePanel label="Proposta">
	<rich:panelMenu expandMode="ajax" label="Itens">
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
		<rich:panelMenuItem label="Submeter"
			action="#{submeterPropostaBean.prepararBean}" />
	</rich:panelMenu>
</rich:simpleTogglePanel>