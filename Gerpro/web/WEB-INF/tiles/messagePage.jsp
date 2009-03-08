<%-- 
    Document   : messagePage
    Created on : 10/01/2009, 01:56:19
    Author     : M2R
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <body>
        <h1>
            <tiles:getAsString name="message"/>
        </h1>
    </body>
</html>
