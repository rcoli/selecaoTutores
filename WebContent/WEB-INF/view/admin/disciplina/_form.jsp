<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<input type="hidden" name="id" value="${disciplina.id}" />
<fieldset>
	<legend>Dados da Disciplina</legend>
	<p>
		<label for="sigla" style="margin-right: 6px;">Sigla:<span
			style="color: red">*</span></label>

		<form:input path="sigla" value="${disciplina.sigla}" />
		<form:errors path="sigla" cssClass="erro" />
	</p>
	<p>
		<label for="nome">Nome:<span style="color: red">*</span></label>

		<form:input path="nome" value="${disciplina.nome}" />
		<form:errors path="nome" cssClass="erro" />
	</p>
	<p>
		<label for="nome">Status:<span style="color: red">*</span></label>

		<form:select path="ativo">
			<form:option value="1">Ativo</form:option>
			<form:option value="0">Desativado</form:option>
		</form:select>
		<form:errors path="ativo" cssClass="erro" />
	</p>

	<p>
		<input type="submit" value="  Enviar  " /> <input name="Cancelar"
			type="button" value="Cancelar" onclick="history.go(-1)" />
	</p>

</fieldset>