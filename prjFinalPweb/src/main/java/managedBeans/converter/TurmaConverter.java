package managedBeans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import entidades.Turma;
import service.TurmaService;

@FacesConverter("converterTurma")
public class TurmaConverter implements Converter {

	private TurmaService servico = new TurmaService();

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		Turma f = null;
		if (value != null && !value.equals("")) {
			f = servico.getTurmaBySigla(value);
		}

		servico.closeEntityManager();

		return f;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object turma) {
		if (turma == null || turma.equals("")) {
			return null;
		} else {
			return ((Turma) turma).getDescricao();
		}
	}

}
