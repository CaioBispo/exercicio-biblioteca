package br.com.cast.biblioteca.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.biblioteca.entity.Livro;

@Repository
public class LivroRepository {

	@PersistenceContext
	private EntityManager em;

	public void inserir(Livro livro) {
		livro.setId(UUID.randomUUID().toString());
		em.persist(livro);
	}

	public void alterar(Livro livro) {
		em.merge(livro);
	}

	public Livro buscarPorId(String id) {
		StringBuilder hql = new StringBuilder();

		hql.append("SELECT l FROM ").append(Livro.class.getName()).append(" l ")
		   .append(" INNER JOIN FETCH l.autor a ")
		   .append(" INNER JOIN FETCH l.categoria c ")
		   .append(" WHERE l.id = :id ");

		Query query = em.createQuery(hql.toString());
		query.setParameter("id", id);

		try {
			return (Livro) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<Livro> buscarTodos() {

		StringBuilder hql = new StringBuilder();
		hql.append(" SELECT l FROM ").append(Livro.class.getName()).append(" l ")
		   .append(" INNER JOIN FETCH l.autor a ")
		   .append(" INNER JOIN FETCH l.categoria c ");

		Query query = em.createQuery(hql.toString());
		return query.getResultList();

	}

	@SuppressWarnings("rawtypes")
	public Livro buscarPorIdTitulo(String id, String titulo) {
		Map<String, Object> params = new HashMap<>();

		StringBuilder hql = new StringBuilder();
		hql.append(" SELECT l FROM ").append(Livro.class.getName()).append(" l ")
		   .append(" WHERE UPPER(l.titulo) = :titulo ");

		params.put("titulo", titulo.trim().toUpperCase());

		if (id != null) {
			hql.append(" AND l.id != :id ");
			params.put("id", id);
		}

		Query query = em.createQuery(hql.toString());

		for (Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		List resultList = query.getResultList();

		if (resultList.size() != 0)
			return (Livro) resultList.get(0);
		return null;
	}

	public void excluir(Livro livro) {
		em.remove(livro);
	}
}
