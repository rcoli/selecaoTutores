package br.edu.cederj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.cederj.dao.DisciplinaDao;
import br.edu.cederj.model.Disciplina;

@Service("disciplinaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DisciplinaService {

	@Autowired
	private DisciplinaDao disciplinaDao;

	public DisciplinaService() { }
	
	public Disciplina listarPorId(Long id) {
		return disciplinaDao.listById(id);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void salvar(Disciplina e) {
		disciplinaDao.saveOrUpdate(e);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void atualizar(Disciplina e) {
		disciplinaDao.update(e);
	}
	public List<Disciplina> listar() {
		return disciplinaDao.listByNameAsc();
	}
	@Transactional
	public void apagar(Disciplina e) {
		disciplinaDao.delete(e);
	}

}
