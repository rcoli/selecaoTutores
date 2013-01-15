package br.edu.cederj.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.cederj.model.Disciplina;

@Repository("disciplinaDao")
public class DisciplinaDao {

	@Autowired
	private SessionFactory sessionFactory;	
	
	public Disciplina listById(Long id){
		return (Disciplina) sessionFactory.getCurrentSession().get(Disciplina.class, id);		
	}	
	@SuppressWarnings("unchecked")
	public List<Disciplina> listByNameAsc() {
		return (List<Disciplina>) sessionFactory.getCurrentSession()
				.createCriteria(Disciplina.class).addOrder(Order.asc("nome")).list();
	}
	public void saveOrUpdate(Disciplina disciplina) {
		sessionFactory.getCurrentSession().saveOrUpdate(disciplina);
	}
	public void update(Disciplina disciplina) {
		sessionFactory.getCurrentSession().update(disciplina);
	}
	
	public void delete(Disciplina disciplina) {
		 sessionFactory.getCurrentSession().delete(disciplina);
	}
}
