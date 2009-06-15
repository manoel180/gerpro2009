<%@page	pageEncoding="UTF-8"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<rich:simpleTogglePanel label="Proposta">
	<rich:panelMenu expandMode="ajax" label="Itens">
		<rich:panelMenuItem label="Missão"
			 />
		<rich:panelMenuItem label="Lista de Funções"
			/>
		<rich:panelMenuItem label="Justificativa"
			/>
		<rich:panelMenuItem label="Metodologia"
			 />
		<rich:panelMenuItem label="Cronograma"
			 />
	</rich:panelMenu>
</rich:simpleTogglePanel>