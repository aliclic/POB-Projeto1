package aplicacao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Pessoa;

public class Deletar {
	protected ObjectContainer manager;
		
	public Deletar() {
		manager = Util.conectarBanco();
		deletar();
		Util.desconectar();
		
		System.out.println("\nfim da aplicacao");
	}
	
	public void deletar() {
		System.out.print("Deletando contato");
		Query q = manager.query();
		q.constrain(Pessoa.class);
		q.descend("nome").constrain("Caio");
		List<Pessoa> resultado = q.execute();
	
		if (resultado.size()>0) {
			Pessoa p = resultado.get(0);
			manager.delete(p);
			manager.commit();
		}	
	}
	
	public static void main(String[] args) {
		new Deletar();
	}
}
