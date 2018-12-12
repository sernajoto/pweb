package service;

import javax.persistence.Query;

import entidades.Curso;

public class CursoService extends Service<Curso, String> {

	public Curso getCursoByNome(String nome) {
		Query query = getEntityManager().createQuery("select o from Curso o where o.nome = :nome");
		query.setParameter("nome", nome);

		return (Curso) query.getSingleResult();
	}

}
