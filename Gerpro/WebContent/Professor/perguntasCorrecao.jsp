<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<rich:simpleTogglePanel label="Proposta">
	<h:outputLabel value="#{corrigirPropostaBean.pergunta.descricao}"></h:outputLabel>
	<h:selectOneRadio value="#{corrigirPropostaBean.resposta.id}" disabled="#{corrigirPropostaBean.desabilitar}">
		<f:selectItem itemLabel="Sim" itemValue="1" />
		<f:selectItem itemLabel="Não" itemValue="2" />
	</h:selectOneRadio>
	<rich:editor  value="#{corrigirPropostaBean.correcao.observacao}" readonly="#{corrigirPropostaBean.desabilitar}"
		theme="advanced" required="true">
		<f:attribute name="fieldRef" value="Descrição" />	
	</rich:editor>
</rich:simpleTogglePanel>