<%-- 
    Document   : cadastroPropostaForm.jsp
    Created on : 12/01/2009, 19:50:52
    Author     : M2R
--%>
<!--%! String[{aluno.matricula}] ; %-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<script type="text/JavaScript">
    
    function MM_openBrWindow(theURL,winName,features) { //v2.0
        window.open(theURL,winName,features);
    }
    
</script>

<tr>
    <h3><spring:message code="cadastro_proposta"/></h3>
</tr>
<form:form method="post" commandName="proposta" >
    <table>
        <tr>
            <td>Proposta</td>
            <td><input type="text" size="80" name="nome" value="${proposta.nome}" /></td>
        </tr>
        <tr>
            <td>Equipe</td>
            <td><input type="text" size="80" value="${proposta.equipe.nome}" /></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <!--tr>
            <table>
                <tr>                    
                    <label ><h3>Componentes da Equipe</h3></label>
                    <--jsp:include page="listaAlunosBranco.jsp"/>
                </tr>
            </table>
            <table >
                <tr>
                    
                    <label><h3>Alunos disponíveis</h3></label>
                    <--jsp:include page="selecaoAlunos.jsp"/>
                    
                </tr>
            </table>
        </tr-->
        <tr>
            <!--jsp:include page="listaAlunosBranco.jsp"/-->
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
                            <td>
                                <a href="cadastroAluno.htm?id=${aluno.matricula}">Remover</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tr>
                    <td width="20px"></td>
                </tr>
                <!--tr>
                    <td>
                        <a href="cadastroNovoAluno.htm">Cadastrar novo aluno</a>
                    </td>
                </tr-->
            </table>
        </tr>        
        <tr>
            <!--jsp:include page="selecaoAlunos.jsp"/-->

            <td>
                <a href="" onclick="MM_openBrWindow('listar.htm?method=alunosSemEquipe','','scrollbars=yes,resizable=NO,width=600,height=400')">Adicionar aluno</a>            </td>
        </tr>
    </table>
    <table width="607" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <!--td><--% {aluno.matricula} = request.getParameter("{aluno.matricula}");%></td-->
        </tr>
        <tr>
            <td><a href="cadastroProposta.htm" onclick="submit()">Salvar Proposta</a></td>
            
        </tr>
    </table>
</form:form>