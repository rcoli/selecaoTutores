<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../topo_simples.jsp" />

<div id="mainContent_large">
	<h1>
		<spring:message code="stu.sistem.title" />
	</h1>
	<p>
		O conteúdo desta página é destinado exclusivamente aos coordenadores do Pré-Vestibular Social.<a href="http://www.pvs.cederj.edu.br/">clique para
			voltar &agrave; p&aacute;gina principal</a>
	</p>
	

<script type="text/javascript">
		jQuery(function($) {
			$("#senha").mask("99/99/Y999");
			$("#user").mask("99999999999");

			$("#stu_login").validate({
				rules : {
					user : "required",
					senha : "required"
				}
			});

		});
	</script>
	<form:form method="post" name="stu_login" id="stu_login" action="j_spring_security_check">

		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
			<div class="error">
				<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
			</div>
		</c:if>



		<fieldset class="inscricao">
			<legend>
				<spring:message code="stu.inicio.legend" />
			</legend>
			<p>
				<label for="user"><spring:message code="stu.inicio.usuario" /></label>
				<input name="j_username" id="user" type="text" />
			</p>
			<p>
				<label for="senha"><spring:message code="stu.inicio.senha" /></label>
				<input name="j_password" id="senha" type="text" />
			</p>
			<label>&nbsp;</label> <input type="reset"
				value='<spring:message code="main.btn.cancelar" />' /> <input
				type="submit" value='<spring:message code="main.btn.enviar" 	/>' />
		</fieldset>

	</form:form>


	<!-- end #mainContent -->
</div>
<br class="clearfloat" />
<c:import url="../rodape.jsp" />
