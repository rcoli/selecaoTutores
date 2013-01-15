package br.edu.cederj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.cederj.dao.PoloDao;
import br.edu.cederj.model.Polo;

@Service("poloService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PoloService {

	@Autowired
	private PoloDao poloDao;

	public PoloService() { }
	
	public Polo listarPorId(Long id) {
		return poloDao.listById(id);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void salvar(Polo e) {
		poloDao.saveOrUpdate(e);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void atualizar(Polo e) {
		poloDao.update(e);
	}
	public List<Polo> listar() {
		return poloDao.listByNameAsc();
	}
	
	public void apagar(Polo e) {
		poloDao.delete(e);
	}

}
