package br.edu.cederj.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.cederj.model.Vaga;

@Repository("vagaDao")
public class VagaDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected final Logger logger = Logger.getAnonymousLogger();

	public Vaga listById(Long id) {
		return (Vaga) sessionFactory.getCurrentSession().get(Vaga.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Vaga> listByNameAsc() {
		return (List<Vaga>) sessionFactory.getCurrentSession()
				.createCriteria(Vaga.class).addOrder(Order.asc("polo"))
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Vaga> listByDisciplinaAsc() {
		return (List<Vaga>) sessionFactory.getCurrentSession()
				.createCriteria(Vaga.class).addOrder(Order.asc("disciplina"))
				.addOrder(Order.asc("polo"))
				.list();
	}

	public void saveOrUpdate(Vaga vaga) {
		sessionFactory.getCurrentSession().saveOrUpdate(vaga);
	}

	public void update(Vaga vaga) {
		sessionFactory.getCurrentSession().update(vaga);
	}

	public void delete(Vaga vaga) {
		sessionFactory.getCurrentSession().delete(vaga);
		sessionFactory.getCurrentSession().flush();
	}
}
