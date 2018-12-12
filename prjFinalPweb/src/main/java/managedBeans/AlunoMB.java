package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Aluno;
import service.AlunoService;

@ManagedBean
@SessionScoped
public class AlunoMB {
	private Aluno aluno = new Aluno();
	private AlunoService service = new AlunoService();
	private Aluno checaAluno = new Aluno();
	private boolean flagConsultar = false;
	private boolean flagInserir = true;
	private boolean flagDeletar = true;
	private boolean flagAlterar = true;
	private boolean flagCancelar = true;
	private boolean flagText = true;

	public void consultar() {
		checaAluno = service.getById(Aluno.class, aluno.getCpf());
		if (checaAluno == null) {
			setFlagConsultar(true);
			setFlagText(false);
			setFlagInserir(false);
			setFlagDeletar(true);
			setFlagAlterar(true);
			setFlagCancelar(false);
		} else {
			aluno = checaAluno;
			setFlagText(false);
			setFlagConsultar(true);
			setFlagInserir(true);
			setFlagDeletar(false);
			setFlagAlterar(false);
			setFlagCancelar(false);
		}
	}

	public void salvar() {
		service.save(aluno);
		service.closeEntityManager();
		aluno = new Aluno();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}

	public void alterar() {
		service.save(aluno);
		service.closeEntityManager();
		aluno = new Aluno();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}

	public void deletar() {
		service.remove(aluno);
		aluno = new Aluno();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}

	public void cancelar() {
		aluno = new Aluno();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}

	public List<Aluno> getAlunos() {
		List<Aluno> lista;
		lista = service.getAll(Aluno.class);
		service.closeEntityManager();
		return lista;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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