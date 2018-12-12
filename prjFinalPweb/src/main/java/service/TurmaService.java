package service;

import java.util.List;

import javax.persistence.Query;

import entidades.Turma;

public class TurmaService extends Service<Turma, String> {

	@SuppressWarnings("unchecked")
	public List<Turma> getTurmaByCurso(String sigla) {
		Query query = getEntityManager().createQuery("select o from Turma o where o.curso.sigla = :Curso");
		query.setParameter("Curso", sigla);

		return (List<Turma>) query.getResultList();
	}

	public Turma getTurmaBySigla(String sigla) {
		Query query = getEntityManager().createQuery("select o from Turma o where o.sigla = :Sigla");
		query.setParameter("Sigla", sigla);

		return (Turma) query.getSingleResult();
	}

}
