package br.edu.cederj.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.cederj.model.Fase;

@Repository("faseDao")
public class FaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected final Logger logger = Logger.getAnonymousLogger();

	public Fase listById(Long id) {
		return (Fase) sessionFactory.getCurrentSession().get(Fase.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Fase> listByNameAsc() {
		return (List<Fase>) sessionFactory.getCurrentSession()
				.createCriteria(Fase.class).addOrder(Order.asc("concurso"))
				.addOrder(Order.asc("inicio")).list();
	}
	public void saveOrUpdate(Fase fase) {
		sessionFactory.getCurrentSession().saveOrUpdate(fase);
	}

	public void update(Fase fase) {
		sessionFactory.getCurrentSession().update(fase);
	}

	public void delete(Fase fase) {
		sessionFactory.getCurrentSession().delete(fase);
		sessionFactory.getCurrentSession().flush();
	}
}
