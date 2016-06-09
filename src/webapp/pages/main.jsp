
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>main page</title>
</head>
<body>

<spring:message code="name_in_main_jsp"/> ${user.name}
User password is ${user.password}
User is admin ${user.admin}

${local}
</body>
</html>
