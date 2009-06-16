<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<link href="../css/gerpro.css" rel="stylesheet" type="text/css" />
</head>
<body>
<f:view>
<h:form>
	<h:outputText  id="mensagemErro"  value="#{erroBean.mensagemErro}" rendered="true"/>		
		
	<h:commandLink action="retornar"  immediate="true">Retornar à página anterior</h:commandLink>

</h:form>	

</f:view>		
	
</body>	
  
