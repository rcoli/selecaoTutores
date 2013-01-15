package br.edu.cederj.util;

import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import br.edu.cederj.model.Inscricao;


@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession implements Serializable {

	private static final long serialVersionUID = -2365776278568982492L;
	private Inscricao inscricao;

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public boolean hasUserLogged() {
		return (this.inscricao != null);
	}

	public void clearSession() {
		this.inscricao = null;
	}

}