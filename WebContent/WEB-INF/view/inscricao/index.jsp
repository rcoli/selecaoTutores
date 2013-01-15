<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../topo_simples.jsp" />

<div id="mainContent_large">
	<h1>
		<spring:message code="stu.sistem.title" />
	</h1>
	<p>
		Lorem ipsum dolor sit amet, vestibulum condimentum vel leo rutrum,
		purus aliquet potenti amet. Sed laoreet temporibus praesent iaculis
		etiam, vivamus aenean interdum. Augue nam. Nulla nam neque ut quis
		viverra, nullam nec sed, commodo odio tristique sit enim egestas
		molestie. <a href="http://www.pvs.cederj.edu.br/">Clique para
			voltar &agrave; p&aacute;gina principal</a>
	</p>
	<p>
		<i>Atenção para as datas do Processo Seletivo</i>
	</p>


	<%-- <c:forEach items="${concurso}" var="concurso">
			<h4>${concurso.nome}</h4> --%>
	<ul>
		<c:forEach items="${concurso[0].fase}" var="fase">
			<li><fmt:formatDate value="${fase.inicio}" type="both"
					pattern="dd/MM/yyyy hh:mm" /> a <fmt:formatDate
					value="${fase.fim}" type="both" pattern="dd/MM/yyyy hh:mm" /> -
				${fase.nome}</li>
		</c:forEach>
	</ul>
	<%-- </c:forEach> --%>



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
	<form:form method="post" name="stu_login" id="stu_login"
		action="${pageContext.request.contextPath}/inscricao/login">
		<%-- action="j_security_check_stu" --%>

		<%-- <c:if test="${not empty param.erro}">
			<div class="error">
				<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
			</div>
		</c:if> --%>



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
			<label>&nbsp;</label> <input type="submit"
				value='<spring:message code="main.btn.enviar" 	/>' /><input
				type="reset" value='<spring:message code="main.btn.cancelar" />' />
		</fieldset>

	</form:form>


	<!-- end #mainContent -->
</div>
<br class="clearfloat" />
<c:import url="../rodape.jsp" />
