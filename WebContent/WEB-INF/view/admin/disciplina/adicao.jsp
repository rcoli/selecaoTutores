<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../topo.jsp" />

<div id="sidebar">
	<c:import url="menuLateral.jsp" />
</div>
<div id="mainContent">
	<h1>Disciplinas</h1>
	<h2 class="ico add">Adicionar Novo</h2>


	<form:form method="post"
		action="${pageContext.request.contextPath}/admin/disciplina/adicionar"
		commandName="disciplina">
		<c:import url="_form.jsp" />

	</form:form>

	<!-- end #mainContent -->
</div>
<!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
<br class="clearfloat" />
<c:import url="../../rodape.jsp" />

