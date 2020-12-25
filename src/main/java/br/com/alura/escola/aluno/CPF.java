package br.com.alura.escola.aluno;

public class CPF {

    private String caracteres;

    public CPF(String caracteres) {
        if (caracteres == null || !caracteres.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF Invalido!");
        }
        this.caracteres = caracteres;
    }

	public String getCaracteres() {
		return caracteres;
	}

	public void setCaracteres(String caracteres) {
		this.caracteres = caracteres;
	}
    
    
}

