package br.edu.cederj.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.cederj.model.Polo;

@Repository("poloDao")
public class PoloDao {

	@Autowired
	private SessionFactory sessionFactory;	
	
	protected final Logger logger = Logger.getAnonymousLogger();
	
	public Polo listById(Long id){
		return (Polo) sessionFactory.getCurrentSession().get(Polo.class, id);		
	}	
	@SuppressWarnings("unchecked")
	public List<Polo> listByNameAsc() {
		return (List<Polo>) sessionFactory.getCurrentSession()
				.createCriteria(Polo.class).addOrder(Order.asc("poloTitulo")).list();
	}
	public void saveOrUpdate(Polo polo) {
		sessionFactory.getCurrentSession().saveOrUpdate(polo);
	}
	public void update(Polo polo) {
		sessionFactory.getCurrentSession().update(polo);
	}
	
	public void delete(Polo polo) {
		logger.info("Deletando Polo");
		logger.info(Long.toString(polo.getId()));
		logger.info(polo.getPoloTitulo());
		
		 sessionFactory.getCurrentSession().delete(polo);
		 sessionFactory.getCurrentSession().flush();
		 logger.info(polo.getPoloSigla());
	}
}
