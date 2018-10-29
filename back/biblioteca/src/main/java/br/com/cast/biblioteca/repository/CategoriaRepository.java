package br.com.cast.biblioteca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.biblioteca.entity.Categoria;

@Repository
public class CategoriaRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Categoria> buscarTodos() {
		StringBuilder hql = new StringBuilder();
		hql.append(" SELECT c FROM ").append(Categoria.class.getName()).append(" c ");

		Query query = em.createQuery(hql.toString());

		return query.getResultList();
	}
}
