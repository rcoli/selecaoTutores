package br.edu.cederj.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import br.edu.cederj.model.Inscricao;


@Component
public class LogonHandler {

	@Autowired
	private UserSession userSession;

	public void login(Inscricao inscricao) {
		this.userSession.setInscricao(inscricao);
		SecurityContextHolder.getContext().setAuthentication(createAuthentication(inscricao));
	}

	public void logout() {
		this.userSession.clearSession();
        SecurityContextHolder.clearContext();
	}

	public boolean isUserLoggedIn() {
		return this.userSession.hasUserLogged();
	}

	@SuppressWarnings("deprecation")
	private Authentication createAuthentication(Inscricao inscricao) {
		List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new GrantedAuthorityImpl("ROLE_USER"));

		UserDetails userDetails = new User(inscricao.getCandidato().getCpf(), inscricao.getCandidato().getDataNascimento().toString(), true, true, true, true, auth);

		return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
	}

}