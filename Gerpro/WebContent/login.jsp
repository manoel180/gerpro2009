<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
	<h:form>
		<h:panelGrid columns="2" border="1" rules="groups">
			<f:facet name="header">
				<h:outputText value="Login" />
			</f:facet>
			
			<h:outputText value="Matricula*" />
			<h:inputText id="matricula" required="true"
				value="#{usuarioBean.usuario.matricula}">
			</h:inputText>

			<h:outputText value="Senha*:" />
			<h:inputSecret id="senha" required="true"
				value="#{usuarioBean.usuario.senha}">
			</h:inputSecret>
			<h:commandButton value="Entrar" action="#{usuarioBean.logar}" />
		</h:panelGrid>
	</h:form>
</f:view>