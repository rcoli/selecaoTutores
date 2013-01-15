<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../topo.jsp" />

<div id="sidebar">
	<c:import url="menuLateral.jsp" />
</div>
<div id="mainContent">
	<h1>Inscrições</h1>
	<h2 class="ico historico">Visualização</h2>

	<fieldset>
		<legend>Dados da Vaga</legend>
		<p>
			<label>Concurso: </label>${inscricao.vaga.concurso.nome}
		</p>
		<p>
			<label>Disciplina:</label> ${inscricao.vaga.disciplina.nome}
		</p>
		<p>
			<label>Polo:</label> ${inscricao.vaga.polo.poloTitulo}
		</p>
	</fieldset>
	<fieldset>
		<legend>Dados do Candidato</legend>
		<p>
			<label>Nome:</label> ${inscricao.candidato.nome}
		</p>
		<p>
			<label>CPF:</label> ${inscricao.candidato.cpf}
		</p>
		<p>
			<label>Data de Nascimento:</label>
			${inscricao.candidato.dataNascimento}
		</p>
	</fieldset>
	<fieldset>
		<legend>Dados do Inscricao</legend>
		<p>
			<label>Motivo:</label> ${inscricao.motivoInscricao}
		</p>
		<p>
			<label>Número:</label>&nbsp; ${inscricao.numeroInscricao}
		</p>
		<p>
			<label>Outras Informações:</label> ${inscricao.outrasInformacoes}
		</p>
		<br />

		<p>
			<label>Comprovante de Pagamento:</label> ${inscricao.pgtoComprovante}
		</p>
		<br />

		<p>
			<label>Data do Pagamento:</label> ${inscricao.pgtoData}
		</p>
		<br />

		<p>
			<label>Tipo do Pagamento:</label>
			<c:choose>
				<c:when test="${inscricao.pgtoTipo=='DEP_DIN'}">Depósito em Dinheiro</c:when>
				<c:when test="${inscricao.pgtoTipo=='DEP_ENV'}">Depósito no Caixa Eletrônico</c:when>
				<c:when test="${inscricao.pgtoTipo=='TRA_ONLINE'}">Transferência On-line</c:when>
			</c:choose>
		</p>
		<br />
		<p>
			<label>Termo de compromisso:</label>
			<c:if test="${inscricao.termoCompromisso==1}">Sim, concordo.</c:if>
		</p>
	</fieldset>
	<p>
		<input name="$laquo; Voltar" type="button" value="&laquo; Voltar"
			onclick="history.go(-1)" />

	</p>
	<!-- end #mainContent -->
</div>
<!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
<br class="clearfloat" />
<c:import url="../../rodape.jsp" />

