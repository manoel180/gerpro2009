<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
<div align="center">
	<h:form>

		
			<div align="center">
				<h:graphicImage url="images/i_topo.jpg"/>
				<br>
				<br>
				<h:graphicImage url="images/bem_vindo.gif" /> 
				<br>
				<br>
				<h:graphicImage url="images/linha_h.gif" />
				<br> 
				<br>
				<h:outputFormat
					value="Informe seu login e senha para ter acesso ao GERPRO." /> 
				<br>
				<br>
				<h:messages layout="list" styleClass="Obrigatório" showDetail="true"
					showSummary="true" />
				<br>
				<br>
				<h:outputText value="Matricula*" /> <h:inputText id="matricula"
					required="true" value="#{usuarioBean.usuario.matricula}">
						<f:attribute name="fieldRef" value="Matricula" />
				</h:inputText> 
				<h:outputText value="Senha*:" />
				<h:inputSecret id="senha"
					required="true" value="#{usuarioBean.usuario.senha}">
						<f:attribute name="fieldRef" value="Senha" />
				</h:inputSecret> 
				<h:commandButton value="Entrar" action="#{usuarioBean.logar}" /> 
				<br>
				<br>
				<br>
				<h:graphicImage url="images/i_rodape.gif" />
			</div>
	</h:form>
	</div>
</f:view>