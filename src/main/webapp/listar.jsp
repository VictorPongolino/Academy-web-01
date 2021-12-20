<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty personagens or fn:length(personagens) eq 0}">
		Não há personagens a serem exibidos, verifique se chamou a servlet!
	</c:if>
	
	<c:if test="${fn:length(personagens) ne 0}">
		<table>
			<tr>
				<th>ID</th>
				<th>Personagem</th>
			</tr>
			<c:forEach var="i" items="${personagens}">
				<tr>
					<th>${i.id}</th>
					<th>${i.nome}</th>
				</tr>
			</c:forEach>	
		</table>
	</c:if>
	
</body>
</html>