<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Login.do" method="post">
账号:<input type="text" name="loginName"/>
密码:<input type="password" name="loginPassword"/>
<input type="submit" value="LOGIN"/>
</form>
<c:forEach var="err" items="${errMsg}"><p color="red">${err}</p></c:forEach>
</body>
 
</html>