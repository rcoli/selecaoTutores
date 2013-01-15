package br.edu.cederj.dao;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.cederj.model.Inscricao;

@Repository("inscricaoDao")
public class InscricaoDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected final Logger logger = Logger.getAnonymousLogger();

	public Inscricao login(String cpf, Date dataNascimento) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Inscricao.class);
		criteria.createAlias("candidato", "candidato");
		
		return  (Inscricao) criteria
					.add(Restrictions.eq("candidato.cpf", cpf))
					/*.add(Restrictions.eq("candidato.dataNascimento", dataNascimento))*/
					.uniqueResult();
	}
	
	
	public Inscricao listById(Long id) {
		return (Inscricao) sessionFactory.getCurrentSession().get(Inscricao.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Inscricao> listByNameAsc() {
		return (List<Inscricao>) sessionFactory.getCurrentSession()
				.createCriteria(Inscricao.class).addOrder(Order.desc("id"))
				.list();
	}

	public void saveOrUpdate(Inscricao inscricao) {
		sessionFactory.getCurrentSession().saveOrUpdate(inscricao);
	}

	public void update(Inscricao inscricao) {
		sessionFactory.getCurrentSession().update(inscricao);
	}

	public void delete(Inscricao inscricao) {
		sessionFactory.getCurrentSession().delete(inscricao);
		sessionFactory.getCurrentSession().flush();
	}
}
