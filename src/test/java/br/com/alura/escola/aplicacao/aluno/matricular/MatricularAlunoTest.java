package br.com.alura.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.infra.aluno.RepositorioAlunosEmMemoria;

class MatricularAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
		RepositorioAlunosEmMemoria alunosEmMemoria = new RepositorioAlunosEmMemoria();
		MatricularAluno useCase = new MatricularAluno(alunosEmMemoria);

		MatricularAlunoDTO dados = new MatricularAlunoDTO("Fulano", "123.456.789-00", "fulano@email.com");
		useCase.executa(dados);
		
		Aluno alunoEncontrado = alunosEmMemoria.buscarPorCPF(new CPF("123.456.789-00"));
		
		assertEquals("Fulano", alunoEncontrado.getNome());
		assertEquals("123.456.789-00", alunoEncontrado.getCpf());
		assertEquals("fulano@email.com", alunoEncontrado.getEmail());

	}

}
