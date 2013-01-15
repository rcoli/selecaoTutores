<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../topo.jsp" />

<div id="sidebar">
	<c:import url="menuLateral.jsp" />
</div>
<div id="mainContent">
	<h1>Inscrições</h1>
	<h2 class="ico excluir">Exclusão</h2>

	<form:form method="post"
		action="${pageContext.request.contextPath}/admin/inscricao/excluir"
		commandName="inscricao">

		<input type="hidden" name="idInscricao" value="${inscricao.id}" />
		<fieldset>
			<legend>Registro a ser Excluído</legend>
			<p>
				<label>Concurso:
				</label>${inscricao.vaga.concurso.nome}
			</p>
			<p>
				<label>Disciplina:</label>
				${inscricao.vaga.disciplina.nome}
			</p>
			<p>
				<label>Polo:</label>
				${inscricao.vaga.polo.poloTitulo}
			</p>
			<p>
				<label>Candidato:</label>
				${inscricao.candidato.nome}
			</p>
			<p>
				<label>CPF:</label>
				${inscricao.candidato.cpf}
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

