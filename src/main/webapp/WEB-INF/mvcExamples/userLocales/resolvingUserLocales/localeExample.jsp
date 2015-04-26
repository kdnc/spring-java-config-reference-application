<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title><spring:message code="welcome.title" text="Welcome" /></title>
</head>
<body>
    <h1><spring:message code="welcome.message" text="Welcome to Court Reservation System" /></h1>
    <br />Locale : ${pageContext.response.locale}

    <%--you can use the <spring:message> tag to resolve a message given the
        code.  Note that this tag is defined in
    Spring’s tag library, so you have to declare it at the top of your JSP file.
    In <spring:message>, you can specify the default text to output when a message for the given code cannot
    be resolved.
    --%>

</body>
</html>