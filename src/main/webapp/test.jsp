<%-- 
    Document   : test
    Created on : 28 juin 2020, 23:59:43
    Author     : Franck
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="no.finn.unleash.Unleash" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Hello World!</h1>
    <%
      Unleash unleash = (Unleash) application.getAttribute("unleash");
    %>

    <h1>
      <%
        if (unleash.isEnabled("DisplayMIFID2Messages")) {
          out.println("DisplayMIFID2Messages : ON");
        } else {
          out.println("DisplayMIFID2Messages : OFF");
        }
      %>
      <h1>
  </body>
</html>
