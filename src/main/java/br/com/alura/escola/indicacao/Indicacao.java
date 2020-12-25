package br.com.alura.escola.indicacao;

import java.time.LocalDateTime;

import br.com.alura.escola.aluno.Aluno;

public class Indicacao {
	
	private Aluno indicado;
	private Aluno indicante;
	private LocalDateTime dataIndicacao;
	
	public Indicacao(Aluno indicado, Aluno indicante) {
		super();
		this.indicado = indicado;
		this.indicante = indicante;
		this.dataIndicacao = LocalDateTime.now();
	}
	
	

}
