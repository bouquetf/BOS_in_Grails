<%--
  Created by IntelliJ IDEA.
  User: bouquetf
  Date: 12/07/12
  Time: 01:20
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Start buy a mini</title>
</head>
<body>

<g:form action="instantiate_process">
    <fieldset>
        <g:hiddenField name="processDefinitionUUID" value="${processUUID}" />
        <div>
            <label for="car">Select a car</label>
            <g:select name="car" from="${['MINI Convertible', 'MINI Hardtop', 'MINI Clubman']}" value="MINI Hardtop" />
        </div>
        <div>
            <g:submitButton name="Validate" />
        </div>
    </fieldset>
</g:form>

</body>
</html>