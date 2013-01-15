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
	
	<form:form method="post" action="${pageContext.request.contextPath}/admin/concurso/excluir" commandName="concurso">
	
		<input type="hidden" name="idConcurso" value="${concurso.id}" />
		<fieldset>
			<legend>Registro a ser Excluído</legend>
			<p>
				<label for="ano" style="margin-right: 6px;">Ano: </label>${concurso.ano}
			</p>
			<p>
				<label for="nome">Nome:</label> ${concurso.nome}
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

