package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Instrutor;
import service.InstrutorService;

@ManagedBean
@SessionScoped
public class InstrutorMB {
	private Instrutor instrutor = new Instrutor();
	private InstrutorService service = new InstrutorService();
	private Instrutor checaInstrutor = new Instrutor();
	private boolean flagConsultar = false;
	private boolean flagInserir = true;
	private boolean flagDeletar = true;
	private boolean flagAlterar = true;
	private boolean flagCancelar = true;
	private boolean flagText = true;

	public void consultar() {
		checaInstrutor = service.getById(Instrutor.class, instrutor.getCpf());
		if (checaInstrutor == null) {
			setFlagConsultar(true);
			setFlagText(false);
			setFlagInserir(false);
			setFlagDeletar(true);
			setFlagAlterar(true);
			setFlagCancelar(false);

		} else {
			instrutor = checaInstrutor;
			setFlagText(false);
			setFlagConsultar(true);
			setFlagInserir(true);
			setFlagDeletar(false);
			setFlagAlterar(false);
			setFlagCancelar(false);
		}
	}

	public void salvar() {
		service.save(instrutor);
		service.closeEntityManager();
		instrutor = new Instrutor();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}

	public void alterar() {
		service.save(instrutor);
		service.closeEntityManager();
		instrutor = new Instrutor();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}

	public void deletar() {
		service.remove(instrutor);
		instrutor = new Instrutor();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}

	public void cancelar() {
		instrutor = new Instrutor();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}

	public List<Instrutor> getInstrutors() {
		List<Instrutor> lista;
		lista = service.getAll(Instrutor.class);
		service.closeEntityManager();
		return lista;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
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