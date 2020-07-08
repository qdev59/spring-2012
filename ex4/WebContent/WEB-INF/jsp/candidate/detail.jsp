<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	Nom : ${candidate.identity.lastname }
	<br /> Prénom : ${candidate.identity.firstname }
	<br /> Manager : ${candidate.manager.identity.firstname }
	${candidate.manager.identity.lastname }
	<br />

	<hr />
	<sec:authorize ifAnyGranted="ROLE_ADMIN, ROLE_1">
		<h3>Voulez vous embaucher ce candidat ?</h3>
		<form:form commandName="hireCandidateCommand" action="hire">
			<form:hidden path="candidateId"/>
			Contrat : <form:select path="contract.id" items="${refData.contracts}" itemLabel="name" itemValue="id"/>
			<br/>
			Début : <form:input path="startDate"/><br/>
			Fin : <form:input path="endDate"/><br/>
			<input type="submit" value="Oui !" />
			
		</form:form>
	</sec:authorize>
</body>
</html>