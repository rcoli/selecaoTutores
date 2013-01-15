<%@ include file="/WEB-INF/view/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<input type="hidden" name="id" value="${vaga.id}" />
<fieldset>
	<legend>Dados da Vaga</legend>
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
		<label for="polo.id" style="margin-right: 6px;">Polo:<span
			style="color: red">*</span></label>
		<form:select path="polo.id">
			<c:forEach items="${polos}" var="polo" varStatus="sts">
				<form:option value="${polo.id}">${polo.poloTitulo}</form:option>
			</c:forEach>
		</form:select>
		<form:errors path="polo.id" cssClass="erro" />
	</p>
	<p>
		<label for="disciplina.id">Disciplina:<span style="color: red">*</span></label>
		<form:select path="disciplina.id">
			<c:forEach items="${disciplinas}" var="disciplina" varStatus="sts">
				<form:option value="${disciplina.id}">${disciplina.nome}</form:option>
			</c:forEach>
		</form:select>
		<form:errors path="disciplina.id" cssClass="erro" />
	</p>

	<p>
		<label for="vaga.qtdVagas">Nº de Vagas:<span
			style="color: red">*</span></label>
		<form:input path="qtdVagas" value="${vaga.qtdVagas}" />
		<form:errors path="qtdVagas" cssClass="erro" />
	</p>
	<p>
		<input type="submit" value="  Enviar  " /> <input name="Cancelar"
			type="button" value="Cancelar" onclick="history.go(-1)" />
	</p>

</fieldset>