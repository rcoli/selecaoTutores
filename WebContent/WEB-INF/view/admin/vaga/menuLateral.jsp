<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h4>Concursos</h4>
<ul class="sidebar_menu">
	<li><a href="${pageContext.request.contextPath}/admin/concurso">Listar</a></li>
	<li><a
		href="${pageContext.request.contextPath}/admin/concurso/adicao">Incluir
			Novo</a></li>
</ul>

<h4>Fases</h4>
<ul class="sidebar_menu">
	<li><a href="${pageContext.request.contextPath}/admin/fase">Listar</a></li>
	<li><a href="${pageContext.request.contextPath}/admin/fase/adicao">Incluir
			Novo</a></li>
</ul>


<h4>Vagas</h4>
<ul class="sidebar_menu">
	<li><a href="${pageContext.request.contextPath}/admin/vaga">Listar</a></li>
	<li><a href="${pageContext.request.contextPath}/admin/vaga/adicao">Incluir
			Novo</a></li>
</ul>
