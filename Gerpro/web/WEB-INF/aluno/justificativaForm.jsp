<%-- 
    Document   : Justificativa
    Created on : 13/01/2009, 10:03:09
    Author     : M2R
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<form>
     <tr>
        <h3>Justificativa</h3>
     </tr>
  <table>
     
       <tr>
        <textarea name="areatexto" rows="10" cols="70">
        </textarea>
       </tr>
     <tr>
        <td>
        <a href="salvarItem.htm" onclick="submit()">Salvar</a>       
        <a href="concluirItem.htm" onclick="submit()">Concluir</a>
        </td>
     </tr>

    </table>

</form>