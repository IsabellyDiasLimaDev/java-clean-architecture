package br.com.alura.escola;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Telefone;

public class TelefoneTest {
	@Test
	void invalidDDD() {
		assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "123456789"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("", "123456789"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("1", "123456789"));

	}

	@Test
	void invalidTelephone() {
		assertThrows(IllegalArgumentException.class, () -> new Telefone("11", ""));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("11", null));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("11", "1111"));
	}

	@Test
	void validTelephoneAndDDD() {
		String ddd = "11";
		String numero = "112233445";
		Telefone telefone = new Telefone(ddd, numero);
		assertEquals(ddd, telefone.getDdd());
		assertEquals(numero, telefone.getNumero());
	}
}
