<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	<c:if test="${not empty empresa }">
		<p>	Empresa ${empresa}  cadastrada com sucesso! </p>
	</c:if>
	
	<p> Lista de Empresas: </p>

	<ul>
		<c:forEach items="${empresas}" var="empresa">			
			<li>
				${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="/gerenciador/mostraEmpresa?id=${empresa.id}">editar</a>
				<a href="/gerenciador/removeEmpresa?id=${empresa.id}">remove</a>			
			
			</li>
		</c:forEach>
	
	</ul>
	
</body>
</html>