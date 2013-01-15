package br.edu.cederj.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.cederj.dao.InscricaoDao;
import br.edu.cederj.model.Candidato;
import br.edu.cederj.model.Inscricao;
import br.edu.cederj.model.Vaga;
import br.edu.cederj.util.LogonHandler;

@Service("inscricaoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InscricaoService {

	@Autowired
	private InscricaoDao inscricaoDao;

	@Autowired
	private LogonHandler longonHandler;

	public InscricaoService() {
	}

	public Inscricao listarPorId(Long id) {
		return inscricaoDao.listById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void salvar(Inscricao e) {
		inscricaoDao.saveOrUpdate(e);
		// e.setCandidato(e.getCandidato());
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void atualizar(Inscricao e) {
		inscricaoDao.update(e);
	}

	public List<Inscricao> listar() {
		return inscricaoDao.listByNameAsc();
	}

	public void apagar(Inscricao e) {
		inscricaoDao.delete(e);
	}

	public Inscricao login(String j_username, Date j_password) {

		Inscricao inscricao = inscricaoDao.login(j_username, j_password);

		if (inscricao != null) {
			this.longonHandler.login(inscricao);
			return inscricao;
		} else {
			Inscricao i = new Inscricao();
			Candidato c = new Candidato();
						
			c.setCpf(j_username);
			c.setDataNascimento(j_password);			

			i.setCandidato(c);
			this.longonHandler.login(i);
			
			return i;

		}

	}

	public void logout() {
		this.longonHandler.logout();
		
	}

}
