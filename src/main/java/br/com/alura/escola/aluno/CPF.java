package escola;

public class CPF {

    private String caracteres;

    public CPF(String caracteres) {
        if (caracteres == null || !caracteres.matches("([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})")) {
            throw new IllegalArgumentException("CPF Invalido!");
        }
        this.caracteres = caracteres;
    }
}
