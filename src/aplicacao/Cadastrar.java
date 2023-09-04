package aplicacao;


import com.db4o.ObjectContainer;

import modelo.Bairro;
import modelo.Endereco;
import modelo.Pessoa;



public class Cadastrar {
	protected ObjectContainer manager;

	public Cadastrar(){
		manager = Util.conectarBanco();
		cadastrar();
		Util.desconectar();
		
		System.out.println("fim da aplicacao");
	}

	public void cadastrar(){
		System.out.println("Cadastrando...");

        Bairro bairro1 = new Bairro("Centro");
        Bairro bairro2 = new Bairro("Mangabeira");
        Bairro bairro3 = new Bairro("JoseAmerico");


        Endereco endereco1 = new Endereco(1, "Exemplo1",111, bairro1);
        Endereco endereco4 = new Endereco(4, "Exemplo4",444, bairro1);
        Endereco endereco2 = new Endereco(2, "Exemplo2",222, bairro2);
        Endereco endereco3 = new Endereco(3, "Exemplo3",333, bairro3);
        Endereco endereco5 = new Endereco(5, "Exemplo5",555, bairro1);

        bairro3.adicionarEndereco(endereco3);
        bairro1.adicionarEndereco(endereco1);
        bairro2.adicionarEndereco(endereco2);
        bairro3.adicionarEndereco(endereco3);
        bairro1.adicionarEndereco(endereco4);
        bairro1.adicionarEndereco(endereco5);

        
        Pessoa pessoa1 =  new Pessoa("Gustavo", endereco1, 1, "2002-03-10");
        Pessoa pessoa2 =  new Pessoa("Alic", endereco2, 2, "2002-03-10");
        Pessoa pessoa3 =  new Pessoa("Caio", endereco3, 3, "2000-03-10");
		manager.store(pessoa1);
		manager.store(pessoa2);
		manager.store(pessoa3);
		manager.commit();
        
	}

	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


