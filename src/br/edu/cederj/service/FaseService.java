package br.edu.cederj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.cederj.dao.FaseDao;
import br.edu.cederj.model.Fase;

@Service("faseService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FaseService {

	@Autowired
	private FaseDao faseDao;

	public FaseService() { }
	
	public Fase listarPorId(Long id) {
		return faseDao.listById(id);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void salvar(Fase e) {
		faseDao.saveOrUpdate(e);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void atualizar(Fase e) {
		faseDao.update(e);
	}
	public List<Fase> listar() {
		return faseDao.listByNameAsc();
	}
	
	public void apagar(Fase e) {
		faseDao.delete(e);
	}

}
