<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<input type="hidden" name="id" value="${fase.id}" />
<fieldset>
	<legend>Dados da Fase</legend>
	<p>
		<label for="concurso.id" style="margin-right: 6px;">Concurso:<span
			style="color: red">*</span></label>
		<form:select path="concurso.id">
			<c:forEach items="${concursos}" var="concurso" varStatus="sts">
				<form:option value="${concurso.id}">${concurso.nome}</form:option>
			</c:forEach>
		</form:select>
		<form:errors path="concurso.id" cssClass="erro" />
	</p>
	<p>
		<label for="inicio">Início:<span style="color: red">*</span></label>
		<form:input path="inicio" value="${inicio}" size="30" />
		<form:errors path="inicio" cssClass="erro" />
	</p>
	<p>
		<label for="fim">Fim:<span style="color: red">*</span></label>
		<form:input path="fim" value="${fim}" size="30" />
		<form:errors path="fim" cssClass="erro" />
	</p>
	<p>
		<label for="nome">Nome:<span style="color: red">*</span></label>
		<form:input path="nome" value="${nome}" size="50" />
		<form:errors path="nome" cssClass="erro" />
	</p>
	<p>
		<label for="sigla">Sigla:<span style="color: red">*</span></label>
		<form:input path="sigla" value="${sigla}" />
		<form:errors path="sigla" cssClass="erro" />
	</p>
	<p>
		<input type="submit" value="  Enviar  " /> <input name="Cancelar"
			type="button" value="Cancelar" onclick="history.go(-1)" />
	</p>

</fieldset>