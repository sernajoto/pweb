package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Aluno;

@ManagedBean
@SessionScoped
public class AlunoMB {
	private List<Aluno> listaAlunos = new ArrayList<Aluno>();
	private Aluno aluno = new Aluno();
	
	public void salvar() {
		listaAlunos.add(aluno);
		aluno = new Aluno();
	}

	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
