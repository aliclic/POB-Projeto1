package aplicacao;


import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Bairro;
import modelo.Endereco;
import modelo.Pessoa;


public class Listar {
	protected ObjectContainer manager;

	public Listar(){
		manager = Util.conectarBanco();
		listar();
		Util.desconectar();
		
		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplica��o");
	}

	public void listar(){
		
		try {
		System.out.println("-------Lista de Pessoas--------");
		Query q = manager.query();
		q.constrain(Pessoa.class);
		List<Pessoa> resultados = q.execute();
		for(Pessoa p : resultados)
			System.out.println(p);
		
		System.out.println("-------Lista de Enderecos--------");
		Query q2 = manager.query();
		q2.constrain(Endereco.class);
		List<Endereco> resultados2 = q2.execute();
		for(Endereco e : resultados2)
			System.out.println(e);
		
		System.out.println("-------Lista de Bairro--------");
		Query q3 = manager.query();
		q3.constrain(Bairro.class);
		List<Bairro> resultados3 = q3.execute();
		for(Bairro b : resultados3)
			System.out.println(b);

		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("fim do programa");
	}

	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}


