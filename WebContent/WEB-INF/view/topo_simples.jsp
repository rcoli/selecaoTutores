<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Pr&eacute;-Vestibular Social - Funda&ccedil;&atilde;o
	CECIERJ</title>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/static/css/menu.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/static/css/print.css" rel="stylesheet"
	type="text/css" media="print" />
<link type="text/css"
	href="${pageContext.request.contextPath}/static/css/pepper-grinder/jquery-ui-1.8.16.custom.css"
	rel="stylesheet" />

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.6.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.tablesorter.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.idTabs.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.maskedinput-1.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.print.js"></script>			

</head>
<body class="twoColElsLtHdr">
	<div id="container">
		<div id="header">
			<img src="${pageContext.request.contextPath}/static/img/logo_pvs.jpg" width="294" height="78"
				alt="" vspace="1" />
				<p class="logout"><a href="${pageContext.request.contextPath}/inscricao">Inscricao</a>
				| <a href="${pageContext.request.contextPath}/admin">Admin</a>
			</p>
			<!-- end #header -->
		</div>
		<c:if test="${!empty mensagensErro}">
			<div class="error">
				<c:forEach items="${mensagensErro}" var="msg">
					<c:out value="${msg}"></c:out>
					<br />
				</c:forEach>
				${mensagensErro.clear()}
			</div>
		</c:if>

		<c:if test="${!empty mensagensAlerta}">
			<div class="warning">
				<c:forEach items="${mensagensAlerta}" var="msg">
					<c:out value="${msg}"></c:out>
					<br />
				</c:forEach>
				${mensagensAlerta.clear()}
			</div>
		</c:if>

		<c:if test="${!empty mensagensSucesso}">
			<div class="success">
				<c:forEach items="${mensagensSucesso}" var="msg">
					<c:out value="${msg}"></c:out>
					<br />
				</c:forEach>
				${mensagensSucesso.clear()}
			</div>
		</c:if>
		<div id="content">