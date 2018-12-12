package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.APrazo;
import service.APrazoService;

@ManagedBean
@SessionScoped
public class APrazoMB {
	private APrazo aprazo = new APrazo();
	private APrazoService service = new APrazoService();

	public void salvar() {
		service.save(aprazo);
		service.closeEntityManager();
		aprazo = new APrazo();
	}

	public List<APrazo> getAPrazos() {
		List<APrazo> lista;
		lista = service.getAll(APrazo.class);
		service.closeEntityManager();
		return lista;
	}

	public APrazo getAPrazo() {
		return aprazo;
	}

	public void setAPrazo(APrazo aprazo) {
		this.aprazo = aprazo;
	}

}
