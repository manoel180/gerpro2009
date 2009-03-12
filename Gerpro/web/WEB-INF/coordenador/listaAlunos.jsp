<%-- 
    Document   : listaAlunos
    Created on : 05/01/2009, 22:30:44
    Author     : 2MR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<tr>
    <h2>Lista de Alunos</h2>
</tr>
<table>
    <!--tr>
        <table>
            <tr>
                <td>
                    <select name="listaAno">
                        <option>2008</option>
                        <option>2009</option>
                    </select>
                </td>
                <td>
                    <select name="listaSemestre">
                        <option>1</option>
                        <option>2</option>
                    </select>
                </td>
            </tr>
            <tr>
                 <td><a href="" onclick="submit()">Buscar</a></td>
            </tr>
        </table>
    </tr-->
    <tr>
        <table c>
            <thead>
                <th>Matrícula</th>
                <td>&nbsp;</td>
                <th>Nome</th>
                <td>&nbsp;</td>
                 <td>&nbsp;</td>
                <th>Período</th>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <th>Editar</th>
            </thead>
            <tbody>
                <c:forEach items="${alunos}" var="aluno" >
                    <tr>
                        <td>
                            <fmt:formatNumber value="${aluno.matricula}" pattern="00000000"/>
                        </td>
                        <td>&nbsp;</td>
                        <td>
                            ${aluno.nome}
                        </td>
                        <td>&nbsp;</td>
                         <td>&nbsp;</td>
                        <td>
                            ${aluno.periodo.semestre}
                        </td>
                         <td>&nbsp;</td>
                          <td>&nbsp;</td>
                        <td>
                            <a href="cadastroAluno.htm?matricula=${aluno.matricula}">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tr>
                <td width="20px"></td>
            </tr>
            <tr>
                <td>
                    <a href="cadastroAluno.htm">Cadastrar novo aluno</a>
                </td>
            </tr>
        </table>
    </tr>
</table>



