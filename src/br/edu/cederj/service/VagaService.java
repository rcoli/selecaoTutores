package br.edu.cederj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.cederj.dao.VagaDao;
import br.edu.cederj.model.Vaga;

@Service("vagaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VagaService {

	@Autowired
	private VagaDao vagaDao;

	public VagaService() { }
	
	public Vaga listarPorId(Long id) {
		return vagaDao.listById(id);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void salvar(Vaga e) {
		vagaDao.saveOrUpdate(e);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void atualizar(Vaga e) {
		vagaDao.update(e);
	}
	public List<Vaga> listar() {
		return vagaDao.listByNameAsc();
	}
	public List<Vaga> listarPorVaga() {
		return vagaDao.listByDisciplinaAsc();
	}
	
	public void apagar(Vaga e) {
		vagaDao.delete(e);
	}

}
