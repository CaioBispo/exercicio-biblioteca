package br.com.cast.biblioteca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.biblioteca.entity.Autor;

@Repository
public class AutorRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Autor> buscarTodos() {
		StringBuilder hql = new StringBuilder();
		hql.append(" SELECT a FROM ").append(Autor.class.getName()).append(" a ");

		Query query = em.createQuery(hql.toString());

		return query.getResultList();
	}
}
