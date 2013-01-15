<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../topo_simples.jsp" />

<div id="sidebar">
	<c:import url="menuLateral.jsp"></c:import>
</div>

<div id="mainContent">
	<h1>
		<spring:message code="stu.sistem.title" />
	</h1>
	<h2><spring:message code="stu.sistem.meusdados" /> &raquo; <spring:message code="stu.sistem.efetuarnovainscricao" /></h2>
	<div class="warning">
		<p>Já há uma <b>INSCRIÇÃO</b> para os dados informados:</p>
	</div>
		<ul>
			<li><b><i>Candidato</i></b>: ${inscricao.candidato.nome}</li>
			<li><b><i>CPF</i></b>: ${inscricao.candidato.cpf}</li>
			<li><b><i>Disciplina</i></b>: ${inscricao.vaga.disciplina.nome}</li>
			<li><b><i>Polo</i></b>: ${inscricao.vaga.polo.poloTitulo}</li>
			
		</ul>
	<p>
		<b>O que deseja fazer?</b>
	</p>
	<script>
		$(function() {
			$("input:submit, a, button", ".opcao").button();
			$("a", ".opcao").click(function() {
				return true;
			});
		});
	</script>
	<div class="opcao">

		<p>
			<a href="${pageContext.request.contextPath}/inscricao/atualiza">1 - Refazer minha inscrição</a> 
			<a href="${pageContext.request.contextPath}/inscricao/comprovante">2 - Emitir o comprovante de inscrição</a>
		</p>

		<!-- <p><b>Atenção</b>: Ao refazer sua inscrição você apagará a inscrição anterior e ganhará um novo número de inscrição.</p> -->

	</div>
	<!-- 
	<hr />
	<p><b>OU</b></p>
	<div class="warning">
		<p>Já há um <b>CADASTRO</b> para os dados informados:</p>
	</div>
	<p>
		<b>Para efetuar sua inscrição é necessário que atualize o seu cadastro clicando no botão abaixo!</b>
	</p>
	<div class="opcao">

		<p>
			<a href="inscricaoNova">Atualizar meus dados e Efetuar minha inscrição</a> 
			
		</p>

		

	</div>
	 -->
	
	<!-- end #mainContent -->
</div>
<br class="clearfloat" />
<c:import url="../rodape.jsp" />
