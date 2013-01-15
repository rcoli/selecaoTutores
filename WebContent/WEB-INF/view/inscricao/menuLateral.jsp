<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h4>
	<spring:message code="stu.sistem.meusdados" />
</h4>
<ul class="sidebar_menu">

	<%-- <li><a href="${pageContext.request.contextPath}/inscricao/adicao"><spring:message
				code="stu.sistem.efetuarnovainscricao" /></a></li> --%>
	<%-- <li><a
		href="${pageContext.request.contextPath}/inscricao/comprovante"><spring:message
				code="stu.sistem.comprovanteinscricao" /></a></li> --%>

	<li><a href="${pageContext.request.contextPath}/inscricao/logout"><span class="pare"><spring:message
					code="stu.sistem.sair" /></span></a></li>
</ul>

