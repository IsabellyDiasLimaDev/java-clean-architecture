package escola;

public class Email {

    // Value object

    private String endereco;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
            throw new IllegalArgumentException("E-mail invalido!!");
        }
        this.setEndereco(endereco);
    }

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
