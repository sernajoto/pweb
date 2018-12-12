package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Matricula;
import service.MatriculaService;

@ManagedBean
@SessionScoped
public class MatriculaMB {
	private Matricula matricula = new Matricula();
	private MatriculaService service = new MatriculaService();

	public void salvar() {
		service.save(matricula);
		service.closeEntityManager();
		matricula = new Matricula();
	}

	public List<Matricula> getMatriculas() {
		List<Matricula> lista;
		lista = service.getAll(Matricula.class);
		service.closeEntityManager();
		return lista;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

}
