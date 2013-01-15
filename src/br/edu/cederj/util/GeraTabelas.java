package br.edu.cederj.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.edu.cederj.model.Candidato;
import br.edu.cederj.model.Concurso;
import br.edu.cederj.model.Disciplina;
import br.edu.cederj.model.Fase;
import br.edu.cederj.model.Inscricao;
import br.edu.cederj.model.Polo;
import br.edu.cederj.model.Vaga;


public class GeraTabelas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfiguration config = new AnnotationConfiguration();
			
		config.addAnnotatedClass(Disciplina.class);
		config.addAnnotatedClass(Polo.class);
		config.addAnnotatedClass(Candidato.class);
		config.addAnnotatedClass(Concurso.class);
		config.addAnnotatedClass(Fase.class);
		config.addAnnotatedClass(Inscricao.class);
		config.addAnnotatedClass(Vaga.class);		
		
		config.configure("hibernate.cfg.xml");	

		
		new SchemaExport(config).create(true, true);		

	}

}
