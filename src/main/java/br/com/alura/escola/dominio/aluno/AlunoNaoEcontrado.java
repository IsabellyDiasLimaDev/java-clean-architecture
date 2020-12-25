package br.com.alura.escola.dominio.aluno;

public class AlunoNaoEcontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AlunoNaoEcontrado(CPF cpf) {
		super("Aluno não encontrado com CPF: " + cpf.getCaracteres());
	}
}
