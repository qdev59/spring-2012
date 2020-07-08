<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="filter" action="list" method="get">
		<form:input path="name" />
		<form:select path="contractId">
			<form:option value=""/>
			<form:options items="${refData.contracts}" itemLabel="name" itemValue="id"/>
		</form:select>
		<input type="submit" />
	</form:form>
</body>
<c:forEach var="e" items="${results}">
	<a href="detail?id=${e.id}"> ${e.identity.firstname}
		${e.identity.lastname} </a>
	<br />
</c:forEach>


</html>