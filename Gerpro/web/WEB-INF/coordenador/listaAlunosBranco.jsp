<%-- 
    Document   : listaAlunos
    Created on : 05/01/2009, 22:30:44
    Author     : 2MR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<table>  
    <tr>
        <table>
            <thead>
                <th>Matrícula</th>
                <th>Nome</th>
            </thead>
            <tbody>
                <c:forEach items="${alunos}" var="aluno">
                    <tr>
                        <td>
                            <fmt:formatNumber value="${aluno.matricula}" pattern="00000000"/>
                        </td>
                        <td>
                            ${aluno.nome}
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tr>
                <td width="20px"></td>
            </tr>            
        </table>
    </tr>
</table>