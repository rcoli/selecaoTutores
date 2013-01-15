package br.edu.cederj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.cederj.dao.ConcursoDao;
import br.edu.cederj.model.Concurso;

@Service("concursoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ConcursoService {

	@Autowired
	private ConcursoDao concursoDao;

	public ConcursoService() { }
	
	public Concurso listarPorId(Long id) {
		return concursoDao.listById(id);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void salvar(Concurso e) {
		concursoDao.saveOrUpdate(e);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void atualizar(Concurso e) {
		concursoDao.update(e);
	}
	public List<Concurso> listar() {
		return concursoDao.listByNameAsc();
	}	
	public void apagar(Concurso e) {
		concursoDao.delete(e);
	}
}
