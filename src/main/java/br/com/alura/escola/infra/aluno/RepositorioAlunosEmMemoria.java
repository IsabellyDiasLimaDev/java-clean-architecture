package br.com.alura.escola.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoNaoEcontrado;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.RepositorioAluno;

public class RepositorioAlunosEmMemoria implements RepositorioAluno{

	private List<Aluno> matriculados = new ArrayList<>();
	
	@Override
	public void matricular(Aluno aluno) {
		this.matriculados.add(aluno);
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		return this.matriculados.stream()
				.filter(a -> a.getCpf().equals(cpf.getCaracteres()))
				.findFirst()
				.orElseThrow(() -> new AlunoNaoEcontrado(cpf));
	}

	@Override
	public List<Aluno> listarTodosoOsAlunosMatriculados() {
		return this.matriculados;
	}

	

}
