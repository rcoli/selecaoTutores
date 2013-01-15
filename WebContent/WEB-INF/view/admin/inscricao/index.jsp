<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:import url="../topo.jsp" />

<div id="sidebar">
	<c:import url="menuLateral.jsp" />
</div>
<div id="mainContent">
	<h1>Inscrições &raquo; Listagem</h1>

	<table id="tabelaIndex" class="tablesorter">
		<caption>Encontrados ${qtdRegistrosTotais} registro(s),
			exibindo ${qtdRegistrosTotais} nesta página.</caption>
		<thead>
			<tr>
				<th><strong><a href="">Concurso</a></strong></th>
				<th><strong><a href="">Disciplina</a></strong></th>
				<th><strong><a href="">Polo</a></strong></th>
				<th><strong><a href="">Candidato</a></strong></th>
				<th colspan="3"><strong>A&ccedil;&otilde;es</strong></th>
			</tr>
		</thead>



		<c:forEach items="${inscricoes}" var="inscricao" varStatus="sts">
			<tr>
				<td>${inscricao.vaga.concurso.nome}</td>
				<td>${inscricao.vaga.disciplina.nome}</td>
				<td>${inscricao.vaga.polo.poloSigla}</td>
				<td>${inscricao.candidato.nome}</td>

				<td><a
					href="${pageContext.request.contextPath}/admin/inscricao/visualizacao/${inscricao.id}"
					class="context_menu" title="Visualizar"><img
						src="${pageContext.request.contextPath}/static/img/icons/note.png"
						width="16" height="16" alt="Visualizar" border="0" /> </a></td>

				<td><a
					href="${pageContext.request.contextPath}/admin/inscricao/exclusao/${inscricao.id}"
					class="context_menu" title="Excluir"><img
						src="${pageContext.request.contextPath}/static/img/icons/cross.png"
						width="16" height="16" alt="Excluir" border="0" /></a></td>
			</tr>
		</c:forEach>

	</table>
	<!-- end #mainContent -->
</div>
<!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
<br class="clearfloat" />
<script>
	$(document).ready(function() {
		$("#tabelaIndex").tablesorter();
	});
</script>
<c:import url="../../rodape.jsp" />
