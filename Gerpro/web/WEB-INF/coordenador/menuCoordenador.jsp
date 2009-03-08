<%--
    Document   : menuCoordenador
    Created on : 08/01/2009, 05:42:44
    Author     : M2R
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>
<link href="comum/layout.css" rel="stylesheet" type="text/css" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<table>
    <tr>
        <td align="left" valign="top" class="txt1" style="padding-left:12px;">
            <a href="bemVindoCoordenador" class="categorylink">Tela Inicial</a>
        </td>
    </tr>

    <tr>
        <td align="left" valign="top" class="txt1" style="padding-left:12px;">
            <a href="listar.htm?method=alunos" class="categorylink">Manter Aluno</a>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top" class="txt1" style="padding-left:12px;">
            <a href="listar.htm?method=professores" class="categorylink">Manter Professores</a>
        </td>
    </tr>    
    <tr>
        <td align="left" valign="top" class="txt1" style="padding-left:12px;">
            <a href="listar.htm?method=propostas" class="categorylink">Manter Propostas</a>
        </td>
    </tr>

    <tr>
        <td align="left" valign="top" class="txt1" style="padding-left:12px;">
            <a href="alocarPropostas.htm" class="categorylink">Alocar Propostas</a>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top" class="txt1" style="padding-left:12px;">
            <a href="relatorios.htm" class="categorylink">Relatórios</a>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top" class="txt1" style="padding-left:12px;">
            <a href="index.htm" class="categorylink">Logoff</a>
        </td>
    </tr>
</table>