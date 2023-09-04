package modelo;

public class Endereco {
    private int id;
    private String rua;
    private int numero;
    private Bairro bairro;

    public Endereco(int id, String rua, int numero, Bairro bairro) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Endereço: " + rua + ", " + numero + ", " + bairro.getNome();
    }
}
