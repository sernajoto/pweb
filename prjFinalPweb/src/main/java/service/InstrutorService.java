package service;

import javax.persistence.Query;

import entidades.Instrutor;

public class InstrutorService extends Service<Instrutor, String> {

	public Instrutor getInstrutorByNome(String nome) {
		Query query = getEntityManager().createQuery("select o from Instrutor o where o.nome = :nome");
		query.setParameter("nome", nome);

		return (Instrutor) query.getSingleResult();
	}
}
