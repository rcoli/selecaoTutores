<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Pr&eacute;-Vestibular Social - Funda&ccedil;&atilde;o
	CECIERJ</title>

<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/static/css/menu.css"
	rel="stylesheet" type="text/css" media="screen" />
<link
	href="${pageContext.request.contextPath}/static/css/pepper-grinder/jquery-ui-1.8.16.custom.css"
	type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/static/css/thickbox.css"
	rel="stylesheet" type="text/css" media="screen" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-1.6.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.tablesorter.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.idTabs.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/thickbox.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.datepicker-pt-br.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.maskMoney.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.maskedinput-1.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/mamuteJSUtils.js"></script>

</head>
<body class="twoColElsLtHdr">
	<div id="container">
		<div id="header">
			<img src="${pageContext.request.contextPath}/static/img/logo_pvs.jpg"
				width="294" height="78" alt="" class="fltlft" vspace="1" />
			<p class="logout">
				<%-- Bem-vindo, Administrador (Administrador)| <a href="#">Gerenciar</a>
				| <a href="${pageContext.request.contextPath}/adm/logout">Sair</a> --%>
				<c:url value="/j_spring_security_logout" var="logoutUrl" />
				<a href="${logoutUrl}">Sair</a>
			</p>

			<ul class="main_menu">

				<li><a class="unselected"
					href="${pageContext.request.contextPath}/admin/disciplina">Disciplina</a></li>
				<li><a class="unselected"
					href="${pageContext.request.contextPath}/admin/polo">Polo</a></li>
				<li><a class="unselected"
					href="${pageContext.request.contextPath}/admin/concurso">Concurso</a></li>
				<li><a class="unselected"
					href="${pageContext.request.contextPath}/admin/inscricao">Inscrição</a></li>	
			</ul>
			<!-- end #header -->
		</div>
		<script type="text/javascript">
			$("#header ul").idTabs(
					function(id, list, set) {
						$("a", set).removeClass("selected").filter(
								"[href='" + id + "']", set)
								.addClass("selected");
						for (i in list)
							$(list[i]).hide();
						$(id).fadeIn(200);
						//$(id).show();
						return false;
					});
		</script>
		<script type="text/javascript">
			/* Função para trazer o menu principal aberto */
			$(document).ready(
					function() {
						var url = window.location.pathname;
						var posUltimaBarra = url.lastIndexOf('/');
						var pathName = url.slice(0, posUltimaBarra);
						var actualDiv = $("a[href^='" + pathName + "']")
								.closest("div").attr("id");
						//console.log(actualDiv);
						//console.log(pathName);
						$("a[href='#" + actualDiv + "']").addClass("selected");
						$("#" + actualDiv).fadeIn(200);
					});
		</script>
		<!-- <script type="text/javascript">
			$("#header ul").idTabs(
					function(id, list, set) {
						$("a", set).removeClass("selected").filter(
								"[href='" + id + "']", set)
								.addClass("selected");
						for (i in list)
							$(list[i]).hide();
						//$(id).fadeIn(); 
						$(id).show();
						return false;
					});
		</script> -->

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