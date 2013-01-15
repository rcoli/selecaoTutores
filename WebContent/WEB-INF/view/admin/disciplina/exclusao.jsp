<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../topo.jsp" />

<div id="sidebar">
	<c:import url="menuLateral.jsp" />
</div>
<div id="mainContent">
	<h1>Disciplinas</h1>
	<h2 class="ico excluir">Exclusão</h2>

	<form:form method="post"
		action="${pageContext.request.contextPath}/admin/disciplina/excluir"
		commandName="disciplina">

		<input type="hidden" name="idDisciplina" value="${disciplina.id}" />
		<fieldset>
			<legend>Registro a ser Excluído</legend>
			<p>
				<label for="sigla" style="margin-right: 6px;">Sigla: </label>${disciplina.sigla}
			</p>
			<p>
				<label for="nome">Nome:</label> ${disciplina.nome}
			</p>
			<p>
				<label for="status">Status:</label>
				<c:choose>
					<c:when test="${disciplina.ativo}">Ativo</c:when>
					<c:otherwise>Inativo</c:otherwise>
				</c:choose>
			</p>

			<p>
				<input type="submit" value="  Excluir  " /> <input name="Cancelar"
					type="button" value="Cancelar" onclick="history.go(-1)" />

			</p>

		</fieldset>

	</form:form>
	<!-- end #mainContent -->
</div>
<!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
<br class="clearfloat" />
<c:import url="../../rodape.jsp" />

