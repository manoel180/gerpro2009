<%-- 
    Document   : template
    Created on : 08/01/2009, 11:02:59
    Author     : msouza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/tiles/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="comum/layout.css" rel="stylesheet" type="text/css" />
        <title>Gerpro: <tiles:getAsString name="title"/></title>
    </head>
    <body>

        <div id="container">
            <div id="internal_container">
                <div id="header">
                    <tiles:insertAttribute name="header"/>
                </div>
                <div id="navbar">
                    <tiles:insertAttribute name="navbar"/>
                </div>

                <div id="menu">
                    <tiles:insertAttribute name="menu"/>
                </div>

                <div id="content">
                    <tiles:insertAttribute name="body"/>
                </div>

                <div id="footer">
                    <tiles:insertAttribute name="footer"/>
                </div>
            </div>
        </div>

    </body>
</html>
