package br.com.alura.escola;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.CPF;

public class CPFTest {

	@Test
	void invalidCPF() {
		assertThrows(IllegalArgumentException.class, () -> new CPF(null));
		assertThrows(IllegalArgumentException.class, () -> new CPF(""));
		assertThrows(IllegalArgumentException.class, () -> new CPF("12345678900"));
	}
	
	@Test
	void validCPF() {
		String ncpf = "111.222.333-44";
		CPF cpf = new CPF(ncpf);
		
		assertEquals(ncpf, cpf.getCaracteres());
	}

}
