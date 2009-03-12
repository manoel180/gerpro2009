<%-- 
    Document   : cadastroAluno
    Created on : 06/01/2009, 00:11:48
    Author     : M2R
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>
<link href="comum/layout.css" rel="stylesheet" type="text/css" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<form:form method="POST" action="salvarAluno.htm" commandName="usuario">
    <table>
        <tr>
            <h2>Cadastro de Aluno</h2>
        </tr>

        <tr>
            <td>Matrícula: </td>
            <td><form:input disabled="true" path="matricula" /></td>
        </tr>
        <tr>
            <td>Aluno: </td>
            <td><form:input path="nome" /></td>
        </tr>       

        <tr>
            <td>Periodo: </td>
            <td><form:input path="periodo" /></td>
        </tr>
        <tr>
            <td>
                <a href="salvarAluno.htm" onclick="submit()">Salvar aluno</a>
            </td>
            <td><a href="" onclick="reset()">Limpar formulário</a>
            </td>
        </tr>
    </table>
</form:form>

<!--form method="POST" action="salvarAluno.htm">
    <table>
        <tr>
            <h2>Cadastro de Aluno</h2>
        </tr>

        <tr>
            <td>Matrícula: </td>
            <td><input type="text" disabled value="{usuario.matricula}" /></td>
        </tr>
        <tr>
            <td>Aluno: </td>
            <td><input type="text" value="{usuario.nome}" /></td>
        </tr>       

        <tr>
            <td>Periodo: </td>
            <td><input type="text" value="{usuario.periodo}" /></td>
        </tr>
        <tr>
            <td>
                <a href="salvarAluno.htm" onclick="submit()">Salvar aluno</a>
            </td>
            <td><a href="" onclick="reset()">Limpar formulário</a>
            </td>
        </tr>
    </table>
</form-->