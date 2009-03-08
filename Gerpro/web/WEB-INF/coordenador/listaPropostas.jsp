<%-- 
    Document   : listaAlunos
    Created on : 05/01/2009, 22:30:44
    Author     : M2R
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<tr>
    <h2><spring:message code="cadastro_proposta"/></h2>
</tr>
<table>    
    <tr>
        <table cellspacing="5px">
            <thead>
                <th>Proposta</th>
                <td></td>
                <th>Equipe</th>
                <td></td>
                <th>Status</th>
            </thead>
            <tbody>
                <c:forEach items="${propostas}" var="proposta">
                    <tr>
                        <td>
                            ${proposta.nome}
                        </td>
                        <td></td>
                        <td>
                            ${proposta.equipe.nome}
                        </td>
                        <td></td>
                        <td>
                            ${proposta.status.nome}
                        </td>
                        <td></td>
                        <td>
                            <a href="editarProposta.htm?id=${proposta.id}">Editar</a>
                            <!--a href="cadastroPropostaEdit.htm">Editar</a-->
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tr>
                <td width="20px"></td>
            </tr>
            <tr>
                <td>
                    <a href="cadastroProposta.htm">Cadastrar nova proposta</a>
                </td>
            </tr>
        </table>        
    </tr>    
</table>