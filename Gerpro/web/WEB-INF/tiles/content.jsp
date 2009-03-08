package WEB-INF.tiles;

<%-- 
    Document   : content
    Created on : 28/12/2008, 02:39:54
    Author     : Marcelo&Marcela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<form id="form1" name="form1" method="post" action="cadastroProposta.htm">
    <table width="69%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td width="243" class="textbox">&nbsp;</td>
        </tr>
        <tr>
            <td height="10">&nbsp;</td>
        </tr>
        <tr>
            <td height="25">Matr&iacute;cula:<br />
                <input name="matricula" type="text" class="txt2" id="matricula" />
            * </td>
        </tr>
        <tr>
            <td height="25">Senha:<br />
                <input name="senha" type="password" class="txt2" id="senha" />
            * </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td><table width="40%" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                        <td><label for="Submit"></label>
                        <input name="Submit" type="submit" class="bg1" id="Submit" value="Entrar" /></td>
                    </tr>
            </table></td>
        </tr>
        <tr>
            <td><br />
            * Campos Obrigat&oacute;rios. </td>
        </tr>

    </table>
</form>

