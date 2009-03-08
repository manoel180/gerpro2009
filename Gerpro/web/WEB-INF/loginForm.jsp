<%-- 
    Document   : loginForm
    Created on : 07/01/2009, 00:45:08
    Author     : M2R
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<form name="form" method="post" action="login.htm?method=valida" commandName="usuario">
    <table width="69%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td width="243" class="textbox">&nbsp;</td>
        </tr>
        <tr>
            <td height="10">&nbsp;</td>
        </tr>
        <tr>
            <td height="25">Matrícula:<br />
                <input name="matricula"  id="matricula" path="matricula" />
            * </td>
        </tr>
        <tr>
            <td height="25">Senha:<br />
                <input name="senha" type="password" path="senha" id="senha" />
            * </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <td></td>
        <tr>
            <td><label>
                    <input type="submit" name="Submit" value="Submit">
                </label>
                <br />
            * Campos Obrigat&oacute;rios. </td>
        </tr>
    </table>
</form>
<!--table>
<--form:form method="post" commandName="usuario" action="index.htm?method=valida">
<tr>
<td>Matrícula</td>
<td>
<--form:input path="matricula"/>
</td>
</tr>
<tr>
<td>Senha </td>
<td>
<--form:password path="senha"/>
</td>
</tr>
<tr>
<td>
<a href="index.htm?method=valida" onclick="submit()">Entrar</a>
</td>
</tr>
<--/form:form>
</table-->

