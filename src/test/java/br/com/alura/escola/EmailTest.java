package br.com.alura.escola;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Email;

public class EmailTest {

	@Test
	void invalidEmail() {
		assertThrows(IllegalArgumentException.class, () -> new Email(null));
		assertThrows(IllegalArgumentException.class, () -> new Email(""));
		assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
	}
	
	@Test
	void validEmail() {
		Email email = new Email("fulano@gmail.com");
		assertEquals("fulano@gmail.com", email.getEndereco());
	}
}
