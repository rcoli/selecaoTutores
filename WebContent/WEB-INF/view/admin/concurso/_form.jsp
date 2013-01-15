<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<input type="hidden" name="id" value="${concurso.id}" />
<fieldset>
	<legend>Dados do Concurso</legend>
	<p>
		<label for="ano" style="margin-right: 6px;">Ano:<span
			style="color: red">*</span></label>

		<form:input path="ano" value="${concurso.ano}" size="4" />
		<form:errors path="ano" cssClass="erro" />
	</p>
	<p>
		<label for="nome">Nome:<span style="color: red">*</span></label>

		<form:input path="nome" value="${concurso.nome}" size="50" />
		<form:errors path="nome" cssClass="erro" />
	</p>

	<p>
		<input type="submit" value="  Enviar  " /> <input name="Cancelar"
			type="button" value="Cancelar" onclick="history.go(-1)" />
	</p>

</fieldset>