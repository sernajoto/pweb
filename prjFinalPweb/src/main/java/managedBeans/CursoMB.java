package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Curso;
import service.CursoService;

@ManagedBean
@SessionScoped
public class CursoMB {
	private Curso curso = new Curso();
	private CursoService service = new CursoService();
	private Curso checaCurso = new Curso();
	private boolean flagConsultar = false;
	private boolean flagInserir = true;
	private boolean flagDeletar = true;
	private boolean flagAlterar = true;
	private boolean flagCancelar = true;
	private boolean flagText = true;

	public void salvar() {
		service.save(curso);
		service.closeEntityManager();
		curso = new Curso();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}

	public void cancelar() {
		curso = new Curso();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}

	public List<Curso> getCursos() {
		List<Curso> lista;
		lista = service.getAll(Curso.class);
		service.closeEntityManager();
		return lista;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void deletar() {
		service.remove(curso);
		curso = new Curso();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}

	public void alterar() {
		service.save(curso);
		service.closeEntityManager();
		curso = new Curso();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}

	public void consultar() {
		checaCurso = service.getById(Curso.class, curso.getSigla());
		if (checaCurso == null) {
			setFlagConsultar(true);
			setFlagText(false);
			setFlagInserir(false);
			setFlagDeletar(true);
			setFlagAlterar(true);
			setFlagCancelar(false);
		} else {
			curso = checaCurso;
			setFlagText(false);
			setFlagConsultar(true);
			setFlagInserir(true);
			setFlagDeletar(false);
			setFlagAlterar(false);
			setFlagCancelar(false);
		}
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

}