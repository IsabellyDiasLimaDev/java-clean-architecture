package br.com.alura.escola;

import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.alura.escola.infra.aluno.RepositorioAlunosEmMemoria;

public class EscolaApp {
	public static void main(String[] args) {
		String nome = "Fulano da silva";
		String cpf = "123.456.789-00";
		String email = "fulano@email.com";

		MatricularAluno matricularAluno = new MatricularAluno(new RepositorioAlunosEmMemoria());

		matricularAluno.executa(new MatricularAlunoDTO(nome, cpf, email));
	}

}
