<%-- 
    Document   : missaoPrdouto
    Created on : 13/01/2009, 10:03:09
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<form>
    <tr>
    <h3>Submeter Proposta</h3>
    </tr>
    <table>        
        <tr>
            <table border="1">
                <tr>
                    <th>Itens</th>                    
                    <th>Status</th>
                </tr>
                <tr>
                    <th><input type="text" value="Missao do produto" /></th>
                    <td><input type="text" value="" /></td>
                </tr>
                
                <tr>
                    <td><input type="text" value="Lista de Funcão" /></td>
                    <td><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td><input type="text" value="Justificativa" /></td>
                    <td><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td><input type="text" value="Metodologia" /></td>
                    <td><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td><input type="text" value="Cronograma" /></td>
                    <td><input type="text" value="" /></td>
                </tr>
                
            </table>
            <tr>
                <a href="submeterProposta.htm" onclick="submit()">Submeter</a>
            </tr>
        </tr>
    </table>
</form>