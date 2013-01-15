<%-- <%@page import="net.sourceforge.htmlunit.corejs.javascript.ast.ForLoop"%> --%>
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
	<h2>
		<spring:message code="stu.sistem.meusdados" />
		&raquo;
		<spring:message code="stu.sistem.comprovanteinscricao" />
	</h2>


	<fieldset class="inscricao ui-corner-all">
		<legend>
			<spring:message code="stu.sistem.cadastro.dadosinscricao" />
		</legend>

		<p>
			<b><i>Disciplina e Polo onde deseja atuar:</i></b>
		</p>
		<p>${inscricao.vaga.disciplina.nome}</p>
		<p>${inscricao.vaga.polo.poloTitulo}</p>
		<p>
			<b><i><spring:message
						code="stu.sistem.cadastro.motivoinsceicao" /></i></b>
		</p>
		<p>${inscricao.motivoInscricao}</p>

	</fieldset>
	<fieldset class="inscricao">
		<legend>
			<spring:message code="stu.sistem.cadastro.dadospagamento" />
		</legend>

		<p>
			<b><i>Como você efetuou o pagamento?</i></b>
		</p>
		<p>
			<c:choose>
				<c:when test="${inscricao.pgtoTipo=='DEP_DIN'}">Depósito em Dinheiro</c:when>
				<c:when test="${inscricao.pgtoTipo=='DEP_ENV'}">Depósito no Caixa Eletrônico</c:when>
				<c:when test="${inscricao.pgtoTipo=='TRA_ONLINE'}">Transferência On-line</c:when>
			</c:choose>


		</p>
		<p>
			<b><i>Comprovante de Pagamento</i></b>
		</p>
		<p>${inscricao.pgtoComprovante}</p>
		<p>
			<b><i></i>
			<spring:message code="stu.sistem.cadastro.datapagamento" /></i></b>
		</p>
		<p>
			<fmt:formatDate value="${inscricao.pgtoData}" type="both"
				pattern="dd/MM/yyyy" />
		</p>

	</fieldset>

	<fieldset class="inscricao">
		<legend>
			<spring:message code="stu.sistem.cadastro.dadospessoais" />
		</legend>
		<p>
			<b><i><spring:message code="stu.sistem.cadastro.cpf" /></i></b>
		</p>
		<p>${inscricao.candidato.cpf}</p>
		<p>
			<b><i><spring:message code="stu.sistem.cadastro.nome" /></i></b>
		</p>
		<p>${inscricao.candidato.nome}</p>
		<p>
			<b><i><spring:message
						code="stu.sistem.cadastro.datanascimento" /></i></b>
		</p>
		<p>
			<fmt:formatDate value="${inscricao.candidato.dataNascimento}"
				type="both" pattern="dd/MM/yyyy" />
		</p>
	</fieldset>

	<fieldset class="inscricao">
		<legend>
			<spring:message code="stu.sistem.cadastro.outrasinformacoes" />
		</legend>
		<p>
			<b><i><spring:message
						code="stu.sistem.cadastro.outrasinformacoesjulgarconveniente" /></i></b>
		</p>
		<p>${inscricao.outrasInformacoes}</p>

	</fieldset>

	<fieldset class="inscricao">
		<legend>
			<spring:message code="stu.sistem.cadastro.termocompromisso" />
		</legend>
		<p style="text-align: justify;">Declaro ter pleno conhecimento dos
			termos do Edital e assumo inteira responsabilidade pela veracidade
			das informações por mim prestadas neste formulário, estando ciente de
			que a não comprovação destas informações e/ou a não-entrega da
			documentação obrigatória implicarão o indeferimento de minha
			inscrição.Se contemplado com uma vaga, estou ciente de que terei que
			me adequar às regras gerais do curso dispostas no site, no Edital e
			nas orientações da Direção do curso. Declaro ainda que tenho dias e
			horários livres para ministrar as aulas no(s) dia(s)/horário(s)
			referente(s) ao polo de minha inscrição.</p>
		<b><i><spring:message
					code="stu.sistem.cadastro.liconcondotermosacima" /></i></b>
		<p>
			<c:if test="${inscricao.termoCompromisso==1}">Sim, concordo.</c:if>

		</p>

	</fieldset>

	<script type="text/javascript">
		jQuery(function($) {
			$("input:submit, input:button, a, button", ".imprime").button();
			$("#imprime").click(function() {
				$("#mainContent").print();
			});
		});
	</script>
	<div class="imprime" style="text-align: center;">
		<p>
			<input type="button" name="imprime" id="imprime"
				value="&laquo; Imprimir &raquo;" />
		</p>
	</div>

	<!-- end #mainContent -->
</div>
<br class="clearfloat" />
<c:import url="../rodape.jsp" />
