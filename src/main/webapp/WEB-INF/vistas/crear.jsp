<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<form:form action="crear-usuario" method="POST" modelAttribute="usuario">
	email:<form:input path="email" id="email" type="email"  /><br/>
	contrase�a:<form:input path="password" type="password" id="password"/><br/>     		  
	rol:<form:input path="rol" type="text" id="rol" />    <br/>
	<button type="Submit"/>registro</button>
</form:form>
</body>
</html>