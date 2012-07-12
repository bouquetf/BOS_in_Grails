<%--
  Created by IntelliJ IDEA.
  User: bouquetf
  Date: 11/07/12
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Process list</title>
</head>
<body>

<h1>Here's the list of processes</h1>
    Select one to start it

<g:each in="${processList}" var="processUUID">
    <ul>
        <li><g:link action="start_Buy_A_Mini" params="${[process:processUUID]}">${processUUID}</g:link></li>
    </ul>
</g:each>

</body>
</html>