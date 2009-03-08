<%-- 
    Document   : listaProfessor
    Created on : 05/01/2009, 22:30:44
    Author     : 2MR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<tr>       
    <h2>Lista de Professores</h2>
</tr>

<table>
    <thead>
        <th>Matrícula</th>
        <th>Nome</th>
        <th>E-mail</th>
    </thead>
    <tbody>
        <c:forEach items="${professores}" var="professor">
            <tr>
                <td>
                    <fmt:formatNumber value="${professor.matricula}" pattern="00000000"/>
                </td>
                <td>
                    ${professor.nome}
                </td>
                <td>
                    ${professor.email}
                </td>
                <td>
                    <a href="cadastroProfessor.htm?id=${professor.matricula}">Editar</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
    <tr>
        <td width="20px"></td>
    </tr>
    <tr>
        <td>
            <a href="cadastroNovoProfessor.htm">Cadastrar professor</a>
        </td>
    </tr>
</table>