package entidades;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "Instrutor")
public class Instrutor extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private String formacao;
	private String areaAtuacao;

	@OneToMany(mappedBy = "instrutor")
	private ArrayList<Turma> turmas;

	public Instrutor() {
		super();
	}

	public Instrutor(String nome, String cpf) {
		super(nome, cpf);
		turmas = new ArrayList<Turma>();
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public void addTurma(Turma turma) {
		turmas.add(turma);
		turma.setInstrutor(this);
	}

}
