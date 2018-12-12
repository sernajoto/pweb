package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.AVista;
import service.AVistaService;

@ManagedBean
@SessionScoped
public class AVistaMB {
	private AVista avista = new AVista();
	private AVistaService service = new AVistaService();

	public void salvar() {
		service.save(avista);
		service.closeEntityManager();
		avista = new AVista();
	}

	public List<AVista> getAVistas() {
		List<AVista> lista;
		lista = service.getAll(AVista.class);
		service.closeEntityManager();
		return lista;
	}

	public AVista getAVista() {
		return avista;
	}

	public void setAVista(AVista avista) {
		this.avista = avista;
	}

}
