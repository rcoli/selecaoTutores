package br.edu.cederj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class GenericController
{
	protected List<String> mensagensErro = new ArrayList<String>();
	protected List<String> mensagensAlerta = new ArrayList<String>();
	protected List<String> mensagensSucesso = new ArrayList<String>();
	
	@Resource(name = "messageSource")
    private MessageSource messageSource;
	
	protected void limparMensagens()
	{ 
		mensagensErro = new ArrayList<String>();
		mensagensAlerta = new ArrayList<String>();
		mensagensSucesso = new ArrayList<String>();
	}
	
	protected Map<String,Object> obterObjetosGlobais()
	{
		Map<String,Object> objetos = new HashMap<String, Object>();
		
		objetos.put("mensagensErro", mensagensErro);
		objetos.put("mensagensAlerta", mensagensAlerta);
		objetos.put("mensagensSucesso", mensagensSucesso);
		
		return objetos;
	}

	protected String getMessage(String key)
	{
		Locale locale = LocaleContextHolder.getLocale();                        
		return messageSource.getMessage(key, new Object[0], locale);
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	protected Boolean existeMensagem(){
		return (!mensagensErro.isEmpty() || !mensagensAlerta.isEmpty() || !mensagensSucesso.isEmpty());
	}
	
	protected Boolean existeMensagemComErro(){
		return (!mensagensErro.isEmpty());
	}
}
