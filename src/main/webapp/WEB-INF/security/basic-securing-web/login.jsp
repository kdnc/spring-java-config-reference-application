<%--
  Created by IntelliJ IDEA.
  User: nuwan
  Date: 4/12/15
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form method="POST" action="login">
    <table>
        <tr>
            <td>Username: </td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="submit" value="Submit"></td>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </table>

</form>

</body>
</html>
