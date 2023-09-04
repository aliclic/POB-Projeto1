package modelo;

import java.util.ArrayList;

public class Bairro {
    private String nomeBairro;
    private ArrayList<Endereco> enderecos = new ArrayList<>();
    
    public Bairro(String nomeBairro){
        this.nomeBairro = nomeBairro;
        this.enderecos = new ArrayList<>();
    }

    public String getNome() {
        return nomeBairro;
    }

    public void setNome(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }
    
    public void adicionarEndereco(Endereco endereco) {
    	enderecos.add(endereco);
    }
    
    public void removerEndereco(int id) {
    	enderecos.remove(id);
    }
    
    public ArrayList<Endereco> getEnderecos() {
    	return enderecos;
    }
    
    @Override
    public String toString() {
        return "Bairro: " + nomeBairro + ", " + "enderecos: " + enderecos.toString();
        }
}
