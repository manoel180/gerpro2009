<%@page	pageEncoding="UTF-8"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<f:view>      
        <rich:modalPanel  id="mp" minHeight="200" minWidth="450" 
            height="200" width="500">
            <f:facet name="header">
                <h:outputText value="${erroBean.tituloMensagemErro}"/>
            </f:facet>
            <f:facet name="controls">
            </f:facet>
            <p></p>
            	<h:outputText value="${erroBean.mensagemErro}"/>                              
        </rich:modalPanel>
</f:view>
            
