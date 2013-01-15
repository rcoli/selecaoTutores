<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:import url="../topo.jsp" />

<div id="sidebar">
	<c:import url="menuLateral.jsp" />
</div>
<div id="mainContent">
	<h1> Disciplinas &raquo; Listagem</h1>
	<%-- <p class="txt_right">
		<a href="${pageContext.request.contextPath}/admin/disciplina/adicao" class="ico add">Adicionar Novo</a>
	</p> --%>

	<table
		id="tabelaIndex" class="tablesorter">
		<caption>Encontrados ${qtdRegistrosTotais} registro(s),
			exibindo ${qtdRegistrosTotais} nesta página.</caption>
		<thead>
			<tr>
				<th><strong><a href="">Sigla</a></strong></th>
				<th><strong><a href="">Nome</a></strong></th>
				<th><strong><a href="">Situa&ccedil;&atilde;o</a></strong></th>
				<th colspan="3"><strong>A&ccedil;&otilde;es</strong></th>
			</tr>
		</thead>

		<c:forEach items="${disciplinas}" var="disciplina" varStatus="sts">
			<tr>
				<td>${disciplina.sigla}</td>
				<td>${disciplina.nome}</td>
				<td>
					<c:choose>
						<c:when test="${disciplina.ativo}">
					      	Ativo
					    </c:when>
						<c:otherwise>
					      	Inativo
					    </c:otherwise>
					</c:choose>
				</td>
				<td><a
					href="${pageContext.request.contextPath}/admin/disciplina/atualizacao/${disciplina.id}"
					class="context_menu" title="Atualizar"><img
						src="${pageContext.request.contextPath}/static/img/icons/arrow_refresh.png" width="16"
						height="16" alt="Atualizar" border="0" /> </a></td>
				
				<td><c:choose>
						<c:when test="${disciplina.id ge 0}">
							<a
								href="${pageContext.request.contextPath}/admin/disciplina/exclusao/${disciplina.id}"
								class="context_menu" title="Excluir"><img
								src="${pageContext.request.contextPath}/static/img/icons/cross.png" width="16" height="16"
								alt="Excluir" border="0" /> </a>
						</c:when>
						<c:otherwise>&nbsp;</c:otherwise>
					</c:choose></td>
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
