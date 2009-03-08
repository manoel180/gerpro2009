<%--
    Document   : cadastroPropostaFormEditado.jsp
    Created on : 12/01/2009, 19:50:52
    Author     : M2R
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<script type="text/JavaScript">
    <!--
    function MM_openBrWindow(theURL,winName,features) { //v2.0
        window.open(theURL,winName,features);
    }
    //-->
</script>

<tr>
    <h3><spring:message code="cadastro_proposta"/></h3>
</tr>
<form:form method="post" commandName="proposta">   
    <table>
        <tr>
            <td>Proposta</td>
            <spring:bind path="nome">
                <td>
                    <input type="text" name="${status.expression}" value="${status.value}" />
                    <c:if test="${status.error}">
                        <font color="red"><c:out value="${status.errorMessage}"/></font>
                    </c:if>
                </td>
            </spring:bind>
        </tr>
        <tr>
            <td>Equipe</td>
            <spring:bind path="equipe.nome">
                <td>
                    <input type="text" name="${status.expression}" value="${status.value}" />
                    <c:if test="${status.error}">
                        <font color="red"><c:out value="${status.errorMessage}"/></font>
                    </c:if>
                </td>
            </spring:bind>
        </tr>
        <tr>
            <spring:nestedPath path="proposta.equipe">
                <forEach items="{alunos}" var="aluno">
                    <tr>
                        <td>
                            ${matricula}
                        </td>
                        <td></td>
                        <td>
                            ${nome}
                        </td>
                        <td>
                            <a href="">Remover</a>
                        </td>
                    </tr>
                </forEach>
            </tr>
            <tr>
                <td onclick="MM_openBrWindow('listar.htm?method=alunosSemEquipe','','scrollbars=yes,resizable=yes,width=600,height=300')"><a href="">Adicionar aluno</a></td>
            </tr>
        </table>
        <table width="607" border="0" cellpadding="0" cellspacing="0">
            <tr><br></tr>
            <tr>
                <td><a href="salvarProposta.htm" onclick="submit()">Salvar proposta</a></td>
            </tr>
        </table>
    </spring:nestedPath>
</form:form>
<!--tr>
<h3><!--spring:message code="cadastro_proposta"/></h3>
</tr>
<!--form:form method="post" commandName="proposta">
<table>
<tr>
<td>Prospota</td>
<td><input type="text" value="{proposta.nome}" /></td>
</tr>
<tr>
<td>Equipe</td>
<td><input type="text" value="{proposta.equipe.nome}" /></td>
</tr>
<tr>
<forEach items="{alunos}" var="aluno">
<tr>
<td>
{matricula}
</td>
<td></td>
<td>
{nome}
</td>
<td>
<a href="">Remover</a>
</td>
</tr>
</forEach>
</tr>
<tr>
<td onclick="MM_openBrWindow('listar.htm?method=alunosSemEquipe','','scrollbars=yes,resizable=yes,width=600,height=300')"><a href="">Adicionar aluno</a></td>
</tr>
</table>
<table width="607" border="0" cellpadding="0" cellspacing="0">
<tr><br></tr>
<tr>
<td><a href="salvarProposta.htm" onclick="submit()">Salvar proposta</a></td>
</tr>
</table>
<!--/form:form>

