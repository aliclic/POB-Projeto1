package aplicacao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Bairro;
import modelo.Pessoa;


public class Consultar {
	protected ObjectContainer manager;

	public Consultar(){
		manager = Util.conectarBanco();
		consultar();
		Util.desconectar();
		
		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplica��o");
	}

	public void consultar(){
		System.out.println("\n---Quais as pessoas com grau de amizade 2");
		
		Query q = manager.query();
		q.constrain(Pessoa.class);
		q.descend("grauAmizade").constrain(2);
		List<Pessoa> result = q.execute();
		for (Pessoa p : result) {
			System.out.println(p);
		}
		
		System.out.println("\n---quais as pessoas que moram no bairro de nome Centro");
		Query q2 = manager.query();
		q2.constrain(Pessoa.class);
		q2.descend("endereco").descend("bairro").descend("nomeBairro").constrain("Centro");
		List<Pessoa> result2 = q2.execute();
		for (Pessoa p : result2) {
			System.out.println(p);
		}
		
		System.out.println("\n---quais os bairros que tem mais de 2 endereços");
		Query q3 = manager.query();
		q3.constrain(Bairro.class);
		q3.constrain( new Filtro() );
		List<Bairro> result3 = q3.execute();
		for (Bairro b : result3) {
			System.out.println(b);
		}
		
	}
	
	public static void main(String[] args) {
		new Consultar();
	}
}


class Filtro implements Evaluation {
	public void evaluate(Candidate candidate) {
			Bairro b = (Bairro) candidate.getObject();
			if(b.getEnderecos().size() > 2)
				candidate.include(true);

			else

				candidate.include(false);
	}
}
