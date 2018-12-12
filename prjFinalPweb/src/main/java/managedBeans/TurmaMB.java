package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Curso;
import entidades.Turma;
import service.CursoService;
import service.TurmaService;

@ManagedBean
@SessionScoped
public class TurmaMB {
	private Turma turma = new Turma();
	private TurmaService service = new TurmaService();
	private Turma checaTurma = new Turma();
	private boolean flagConsultar = true;
	private boolean flagInserir = true;
	private boolean flagDeletar = true;
	private boolean flagAlterar = true;
	private boolean flagCancelar = true;
	private boolean flagText = true;
	private boolean flagTextSigla = true;
	private boolean flagSelecionado = false;
	private CursoService cursoService = new CursoService();
	private Curso curso;

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

	public void selecionado() {
		setFlagTextSigla(false);
		setFlagSelecionado(true);
		setFlagConsultar(false);
		setFlagText(true);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(false);
	}

	public void consultar() {
		checaTurma = service.getById(Turma.class, turma.getSiglaTurma());
		if (checaTurma == null) {
			setFlagConsultar(true);
			setFlagText(false);
			setFlagInserir(false);
			setFlagDeletar(true);
			setFlagAlterar(true);
			setFlagCancelar(false);
		} else {
			turma = checaTurma;
			setFlagText(false);
			setFlagConsultar(true);
			setFlagInserir(true);
			setFlagDeletar(false);
			setFlagAlterar(false);
			setFlagCancelar(false);
		}
	}

	public void salvar() {
		service.save(turma);
		service.closeEntityManager();
		turma = new Turma();
		setFlagConsultar(true);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
		setFlagTextSigla(true);
		setFlagSelecionado(false);
	}

	public void alterar() {
		service.save(turma);
		service.closeEntityManager();
		turma = new Turma();
		setFlagConsultar(true);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
		setFlagTextSigla(true);
		setFlagSelecionado(false);
	}

	public void deletar() {
		service.remove(turma);
		turma = new Turma();
		setFlagConsultar(true);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
		setFlagTextSigla(true);
		setFlagSelecionado(false);
	}

	public void cancelar() {
		turma = new Turma();
		setFlagConsultar(true);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
		setFlagTextSigla(true);
		setFlagSelecionado(false);
	}

	public List<Turma> getTurmas() {
		List<Turma> lista;
		lista = service.getAll(Turma.class);
		service.closeEntityManager();
		return lista;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public boolean getFlagInserir() {
		return flagInserir;
	}

	public void setFlagInserir(boolean flagInserir) {
		this.flagInserir = flagInserir;
	}

	public boolean getFlagConsultar() {
		return flagConsultar;
	}

	public void setFlagConsultar(boolean flagConsultar) {
		this.flagConsultar = flagConsultar;
	}

	public boolean getFlagDeletar() {
		return flagDeletar;
	}

	public void setFlagDeletar(boolean flagDeletar) {
		this.flagDeletar = flagDeletar;
	}

	public boolean getFlagAlterar() {
		return flagAlterar;
	}

	public void setFlagAlterar(boolean flagAlterar) {
		this.flagAlterar = flagAlterar;
	}

	public boolean getFlagText() {
		return flagText;
	}

	public void setFlagText(boolean flagText) {
		this.flagText = flagText;
	}

	public boolean getFlagCancelar() {
		return flagCancelar;
	}

	public void setFlagCancelar(boolean flagCancelar) {
		this.flagCancelar = flagCancelar;
	}

	public boolean getFlagSelecionado() {
		return flagSelecionado;
	}

	public void setFlagSelecionado(boolean flagSelecionado) {
		this.flagSelecionado = flagSelecionado;
	}

	public boolean getFlagTextSigla() {
		return flagTextSigla;
	}

	public void setFlagTextSigla(boolean flagTextSigla) {
		this.flagTextSigla = flagTextSigla;
	}

}