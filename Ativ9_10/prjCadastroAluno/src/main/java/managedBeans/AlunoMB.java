package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Aluno;

@ManagedBean
@SessionScoped
public class AlunoMB {
	private Aluno aluno = new Aluno();
	private EntityManagerFactory emf;

	public AlunoMB() {
		emf = Persistence.createEntityManagerFactory("prjCadastroAlunoDB");
	}

	public void salvar() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		em.close();
		aluno = new Aluno();
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> getListaAlunos() {
		List<Aluno> listaAlunos;
		EntityManager em = emf.createEntityManager();
		listaAlunos = em.createQuery("Select a from Aluno a").getResultList();
		return listaAlunos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
