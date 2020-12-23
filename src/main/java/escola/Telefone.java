package escola;

public class Telefone {
	
	private String ddd;
	private String numero;
	
	public Telefone(String ddd, String numero) {
		if (ddd == null || numero == null || ddd.length() < 2 || numero.length() < 9) {
			throw new IllegalArgumentException("Telefone inválido");
		}
		this.ddd = ddd;
		this.numero = numero;
	}
}
