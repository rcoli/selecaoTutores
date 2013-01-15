package br.edu.cederj.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.cederj.model.Concurso;

@Repository("concursoDao")
public class ConcursoDao {

	@Autowired
	private SessionFactory sessionFactory;	
	
	protected final Logger logger = Logger.getAnonymousLogger();
	
	public Concurso listById(Long id){
		return (Concurso) sessionFactory.getCurrentSession().get(Concurso.class, id);		
	}	
	@SuppressWarnings("unchecked")
	public List<Concurso> listByNameAsc() {
		return (List<Concurso>) sessionFactory.getCurrentSession()
				.createCriteria(Concurso.class).addOrder(Order.desc("ano")).list();
	}
	public void saveOrUpdate(Concurso concurso) {
		sessionFactory.getCurrentSession().saveOrUpdate(concurso);
	}
	public void update(Concurso concurso) {
		sessionFactory.getCurrentSession().update(concurso);
	}
	
	public void delete(Concurso concurso) {
		/*logger.info("Deletando Concurso");
		logger.info(Long.toString(concurso.getId()));
		logger.info(concurso.getConcursoTitulo());*/
		
		 sessionFactory.getCurrentSession().delete(concurso);
		 sessionFactory.getCurrentSession().flush();
		 /*logger.info(concurso.getConcursoSigla());*/
	}
}
