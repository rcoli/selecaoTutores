<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<select name="polo" id="polo">
	<option value="">(selecione)</option>
	<c:forEach items="${polosAtivos}" var="pa">
		<option value="${pa.id}">${pa.poloTitulo}</option>
	</c:forEach>														
</select>