package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Curso;
import entidades.Instrutor;
import entidades.Turma;
import service.CursoService;
import service.InstrutorService;
import service.TurmaService;

@ManagedBean
@SessionScoped
public class AlocarInstrutorMB {
	private Instrutor instrutor = new Instrutor();
	private InstrutorService instrutorService = new InstrutorService();
	private Turma turma = new Turma();
	private TurmaService turmaService = new TurmaService();
	private boolean situacao = false;
	private boolean flagAlocar = true;
	private boolean flagLiberar = true;
	private boolean flagCancelar = true;
	private CursoService cursoService = new CursoService();
	private Curso curso;
	private String resultado;

	public List<Curso> getCursos() {
		List<Curso> list = cursoService.getAll(Curso.class);
		cursoService.closeEntityManager();
		return list;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void cancelar() {
		turma = new Turma();
		curso = new Curso();
		instrutor = new Instrutor();
		setFlagAlocar(true);
		setFlagLiberar(true);
	}

	public void alocar() {
		turma.setInstrutor(instrutor);
		salvar();
	}

	public void liberar() {
		turma.setInstrutor(null);
		salvar();
	}

	public void salvar() {
		turmaService.save(turma);
		turmaService.closeEntityManager();
		turma = new Turma();
	}

	public List<Turma> getTurmas() {
		if (curso == null) {
			return null;
		} else {
			List<Turma> list = turmaService.getTurmaByCurso(curso.getSigla());
			turmaService.closeEntityManager();
			return list;
		}
	}

	public List<Instrutor> getInstrutores() {
		List<Instrutor> list = instrutorService.getAll(Instrutor.class);
		instrutorService.closeEntityManager();
		return list;
	}

	public Turma getTurma() {
		return turma;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		if (turma.getInstrutor() == null) {
			this.situacao = false;
		} else {
			this.situacao = true;
		}
	}

	public void init() {
		if (turma.getInstrutor() == null) {
			this.situacao = false;
			setFlagAlocar(false);
			setFlagLiberar(true);
			setResultado("Liberada");
		} else {
			this.situacao = true;
			setFlagAlocar(true);
			setFlagLiberar(false);
			setResultado("Alocada");
		}
	}

	public boolean getFlagAlocar() {
		return flagAlocar;
	}

	public void setFlagAlocar(boolean flagAlocar) {
		this.flagAlocar = flagAlocar;
	}

	public boolean getFlagLiberar() {
		return flagLiberar;
	}

	public void setFlagLiberar(boolean flagLiberar) {
		this.flagLiberar = flagLiberar;
	}

	public boolean getFlagCancelar() {
		return flagCancelar;
	}

	public void setFlagCancelar(boolean flagCancelar) {
		this.flagCancelar = flagCancelar;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
