<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: bondarm
  Date: 26.12.16
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Frontend</title>
    <base href="/ticket-booking-service/">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/x-icon" href="<spring:url value='/static/favicon.ico'/>">
    <link href="<spring:url value='/static/styles.bundle.css'/>" rel="stylesheet"></head>
<body>
<app-root>Loading...</app-root>
<script type="text/javascript" src="<spring:url value='/static/inline.bundle.js'/>"></script>
        <script type="text/javascript" src="<spring:url value='/static/vendor.bundle.js'/>"></script>
        <script type="text/javascript" src="<spring:url value='/static/main.bundle.js'/>"></script>
                </body>
</html>
