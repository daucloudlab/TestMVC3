
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>login page</title>
</head>
<body>

<span style="float: right;">
  <a href="?lang=kk">kz</a>
  <a href="?lang=ru">ru</a>
  <a href="?lang=en">en</a>
</span>

<form:form action="/check-user" method="POST" commandName="user">
  <label for="name"><spring:message code="name"/>: </label>
  <form:input path="name" id="name"/>
  <form:errors path="name" />

  <label for="password"><spring:message code="password"/>: </label>
  <form:password path="password" id="password"/>
  <form:errors path="password" />

  <form:checkbox path="admin" id="admin"/>
  <label for="admin"><spring:message code="admin"/>: </label>

  <input type="submit" value="<spring:message code="login"/>" />
</form:form>
</body>
</html>
