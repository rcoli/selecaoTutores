<%-- <%@page import="net.sourceforge.htmlunit.corejs.javascript.ast.ForLoop"%> --%>
<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<c:import url="../topo_simples.jsp" />
<script type="text/javascript" src="/mamute/static/js/stu.inscricao.js"></script>
<div id="sidebar">
	<c:import url="menuLateral.jsp"></c:import>
</div>

<script type="text/javascript">
	jQuery(function($) {
		$("#pgtoData").mask("99/99/Y999");
		
		
		$("#cpf").attr('readonly', true);
		$("#cpf").css({backgroundColor: '#ccc'});
		$("#dataNascimento").attr('readonly', true);
		$("#dataNascimento").css({backgroundColor: '#ccc'});

	});
</script>

<div id="mainContent">
	<h1>
		<spring:message code="stu.sistem.title" />
	</h1>
	<h2>
		<spring:message code="stu.sistem.meusdados" />
		&raquo;
		<spring:message code="stu.sistem.efetuarnovainscricao" />
	</h2>

	<form:form method="post"
		action="${pageContext.request.contextPath}/inscricao/adicionar"
		commandName="inscricao">
		
		<form:hidden path="id" />
		<form:hidden path="candidato.id"/>


		<p class="campos_obrigatorios">
			*
			<spring:message code="stu.sistem.cadastro.camposobrigatorios" />
		</p>

		<fieldset class="inscricao ui-corner-all">
			<legend>
				<spring:message code="stu.sistem.cadastro.dadosinscricao" />
			</legend>

			<p>
				<i>Disciplina e Polo onde deseja atuar:</i>
			</p>
			<p>
				<form:label path="vaga.id">*Vaga</form:label>
				<br /> <br />
				<form:select path="vaga.id">
					<form:option value="">--Escolha Aqui--</form:option>
					<c:forEach items="${vagas}" var="vagas" varStatus="sts">
						<form:option value="${vagas.id}">
						${vagas.disciplina.nome} - ${vagas.polo.poloTitulo}</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="vaga.id" cssClass="erro" />

			</p>

			<p>
				<form:label path="motivoInscricao">*<spring:message
						code="stu.sistem.cadastro.motivoinsceicao" />
				</form:label>
				<form:textarea path="motivoInscricao" />
				<form:errors path="motivoInscricao" cssClass="erro" />
			</p>
		</fieldset>
		<fieldset class="inscricao">
			<legend>
				<spring:message code="stu.sistem.cadastro.dadospagamento" />
			</legend>

			<p>
				<i>*Como você efetuou o pagamento?</i>
			</p>
			<p class="clear_block">
				<form:radiobutton path="pgtoTipo" value="DEP_DIN" />
				<form:label path="pgtoTipo">
					<spring:message code="stu.sistem.cadastro.depositodinheiro" />
				</form:label>
			</p>
			<p class="clear_block">
				<form:radiobutton path="pgtoTipo" value="DEP_ENV" />
				<form:label path="pgtoTipo">
					<spring:message
						code="stu.sistem.cadastro.depositodinheirochequeenvelope" />
				</form:label>
			</p>
			<p class="clear_block">
				<form:radiobutton path="pgtoTipo" value="TRA_ONLINE" />
				<form:label path="pgtoTipo">
					<spring:message
						code="stu.sistem.cadastro.transferenciabancklinebanckfone" />
				</form:label>
				<form:errors path="pgtoTipo" cssClass="erro" />
			</p>

			<div id="grupo-pgto-tipo">
				<p>
					<form:label path="pgtoComprovante">*Comprovante de Pagamento
			</form:label>
					<form:input path="pgtoComprovante" />
					<form:errors path="pgtoComprovante" cssClass="erro" />

				</p>
				<p>
					<form:label path="pgtoData">*<spring:message
							code="stu.sistem.cadastro.datapagamento" />
					</form:label>
					<form:input path="pgtoData" id="pgtoData" />
					<small>(somente números)</small>
					<form:errors path="pgtoData" cssClass="erro" />
				</p>
			</div>
		</fieldset>

		<fieldset class="inscricao">
			<legend>
				<spring:message code="stu.sistem.cadastro.dadospessoais" />
			</legend>
			<p>
				<form:label path="candidato.cpf">*<spring:message
						code="stu.sistem.cadastro.cpf" />
				</form:label>
				<form:input path="candidato.cpf" id="cpf" />
				<form:errors path="candidato.cpf" cssClass="erro" />
			</p>

			<p>
				<form:label path="candidato.nome">*<spring:message
						code="stu.sistem.cadastro.nome" />
				</form:label>
				<form:input path="candidato.nome" />
				<form:errors path="candidato.nome" cssClass="erro" />
			</p>

			<p>
				<form:label path="candidato.dataNascimento">*<spring:message
						code="stu.sistem.cadastro.datanascimento" />
				</form:label>
				<form:input path="candidato.dataNascimento" id="dataNascimento"
					value=""  />
				<form:errors path="candidato.dataNascimento" cssClass="erro" />
			</p>
		</fieldset>

		<fieldset class="inscricao">
			<legend>
				<spring:message code="stu.sistem.cadastro.outrasinformacoes" />
			</legend>
			<p>
				<form:label path="outrasInformacoes">*<spring:message
						code="stu.sistem.cadastro.outrasinformacoesjulgarconveniente" />
				</form:label>
				<form:textarea path="outrasInformacoes" />
				<form:errors path="outrasInformacoes" cssClass="erro" />
			</p>
		</fieldset>

		<fieldset class="inscricao">
			<legend>
				<spring:message code="stu.sistem.cadastro.termocompromisso" />
			</legend>
			<p style="text-align: justify;">Declaro ter pleno conhecimento
				dos termos do Edital e assumo inteira responsabilidade pela
				veracidade das informações por mim prestadas neste formulário,
				estando ciente de que a não comprovação destas informações e/ou a
				não-entrega da documentação obrigatória implicarão o indeferimento
				de minha inscrição.Se contemplado com uma vaga, estou ciente de que
				terei que me adequar às regras gerais do curso dispostas no site, no
				Edital e nas orientações da Direção do curso. Declaro ainda que
				tenho dias e horários livres para ministrar as aulas no(s)
				dia(s)/horário(s) referente(s) ao polo de minha inscrição.</p>
			<form:label path="">*<spring:message
					code="stu.sistem.cadastro.liconcondotermosacima" />
			</form:label>
			<form:checkbox path="termoCompromisso" value="1" />
			<form:errors path="termoCompromisso" cssClass="erro" />


		</fieldset>
		<script type="text/javascript">
			jQuery(function($) {
				$("input:submit, input:button, input:reset, a, button",
						".opcao").button();

			});
		</script>

		<div class="opcao" style="text-align: center;">
			<p>
				<input type="submit" value="Enviar Inscrição &raquo;" /> <input
					type="reset" value="Apagar dados" />
			</p>

		</div>

	</form:form>
	<!-- end #mainContent -->
</div>
<br class="clearfloat" />
<c:import url="../rodape.jsp" />
