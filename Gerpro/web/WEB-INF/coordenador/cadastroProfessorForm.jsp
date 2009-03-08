<%-- 
    Document   : cadastroProfessor
    Created on : 06/01/2009, 00:11:48
    Author     : M2R
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<form method="POST" action="salvarProfessor.htm">
    <table>
        <tr>
            <h3>Cadastro de Professor</h3>
        </tr>
        <tr>
            <td>Matrícula</td>
            <td><input type="text" disabled value="${professor.matricula}" /></td>
        </tr>
        <tr>
            <td>Nome</td>
            <td><input type="text" value="${professor.nome}" /></td>
        </tr>
        <tr>
            <td>E-mail</td>
            <td><input type="text" value="${professor.email}" /></td>
        </tr>
        <tr>
            <td>
                <a href="salvarProfessor.htm" onclick="submit()">Salvar professor</a>
            </td>
            <td><a href="" onclick="reset()">Limpar formulário</a>
            </td>
        </tr>
    </table>
</form>