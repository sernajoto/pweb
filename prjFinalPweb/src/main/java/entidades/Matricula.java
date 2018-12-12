package entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Matricula implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codMatricula;

	private String data;
	private int qtdeFaltas;
	private double nota;

	@OneToOne
	private Aluno aluno;

	@ManyToOne
	private Turma turma;

	@OneToOne
	private AVista aVista;

	@OneToOne
	private APrazo aPrazo;

	public Matricula() {

	}

	public Matricula(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQtdeFaltas() {
		return qtdeFaltas;
	}

	public void setQtdeFaltas(int qtdeFaltas) {
		this.qtdeFaltas = qtdeFaltas;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
		aluno.setMatricula(this);
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void emitirCarne() {

	}

	public AVista getaVista() {
		return aVista;
	}

	public void setaVista(AVista aVista) {
		this.aVista = aVista;
	}

	public APrazo getaPrazo() {
		return aPrazo;
	}

	public void setaPrazo(APrazo aPrazo) {
		this.aPrazo = aPrazo;
	}

}
