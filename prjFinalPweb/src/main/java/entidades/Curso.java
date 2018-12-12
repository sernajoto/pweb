package entidades;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String sigla;
	private String nome;
	private int cargaHoraria;
	private double valor;
	private String dataVigencia;
	private double valorHoraInstrutor;
	private String programa;

	@OneToMany(mappedBy = "curso")
	private ArrayList<Turma> turmas = new ArrayList<Turma>();

	public Curso() {

	}

	public Curso(String sigla, String nome) {
		this.sigla = sigla;
		this.nome = nome;
		turmas = new ArrayList<Turma>();
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(String dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public double getValorHoraInstrutor() {
		return valorHoraInstrutor;
	}

	public void setValorHoraInstrutor(double valorHoraInstrutor) {
		this.valorHoraInstrutor = valorHoraInstrutor;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public void addTurma(Turma turma) {
		turmas.add(turma);
		turma.setCurso(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fornecedor [sigla=" + sigla + "]";
	}

}
