package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.RepositorioAluno;

public class MatricularAluno {
	
	private final RepositorioAluno repositorioAluno;

	public MatricularAluno(RepositorioAluno repositorioAluno) {
		this.repositorioAluno = repositorioAluno;
	}
	
	public void executa(MatricularAlunoDTO dados) {
		Aluno novo = dados.criarAluno();
		repositorioAluno.matricular(novo);
	}
}
