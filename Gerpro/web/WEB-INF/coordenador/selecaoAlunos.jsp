<%-- 
    Document   : listaAlunos
    Created on : 05/01/2009, 22:30:44
    Author     : 2MR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<form action="selecionaAlunos.htm" method="post" name="form" >
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="21">&nbsp;</td>
            <td width="100" align="left"><strong>Matrícula</strong></td>
            <td width="253" align="left"><strong>Nome</strong></td>
            <td width="38">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="5"><table border="0" cellspacing="0">
 
                    <c:forEach items="${alunosSemEquipe}" var="aluno">
                        <tr>
                          <td width="20" align="center" valign="middle">
						  <input name="matriculas" type="checkbox" id="${aluno.matricula}" value="${aluno.matricula}"></td>
                            <td width="100" align="left" valign="middle"><fmt:formatNumber value="${aluno.matricula}" pattern="00000000"/></td>
                            <td width="130" align="left" valign="middle">${aluno.nome} </td>
                            <td width="137">&nbsp;</td>
                        </tr>
                    </c:forEach>
            </table></td>
        </tr>
        <tr>
            <td colspan="5">&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td align="right">
            <a href="selecionaAluno.htm" onclick="submit()">Concluir</a>      
            <td><label>
            <input type="submit" name="Submit" value="Submit">
            </label></td>
        </tr>
    </table>
</form>


<!--form action="selecionaAlunos.htm" method="post" name="form" >
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="21">&nbsp;</td>
            <td width="100" align="left"><strong>Matrícula</strong></td>
            <td width="253" align="left"><strong>Nome</strong></td>
            <td width="38">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="5"><table border="0" cellspacing="0">

                    <--c:forEach items="{alunosSemEquipe}" var="aluno">
                        <tr>
                          <td width="20" align="center" valign="middle">
						  <input name="{aluno.matricula}" type="checkbox" id="{aluno.matricula}" value="{aluno.matricula}"></td>
                            <td width="100" align="left" valign="middle"><--fmt:formatNumber value="{aluno.matricula}" pattern="00000000"/></td>
                            <td width="130" align="left" valign="middle">{aluno.nome} </td>
                            <td width="137">&nbsp;</td>
                        </tr>
                    <--/c:forEach>
            </table></td>
        </tr>
        <tr>
            <td colspan="5">&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td align="right">
            <a href="selecionaAluno.htm" onclick="submit()">Concluir</a>
            <td><label>
            <input type="submit" name="Submit" value="Submit">
            </label></td>
        </tr>
    </table>
</form-->