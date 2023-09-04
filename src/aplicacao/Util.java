
package aplicacao;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

import modelo.Bairro;
import modelo.Endereco;
import modelo.Pessoa;

public class Util {
	private static ObjectContainer manager;

	public static ObjectContainer conectarBanco(){
		if (manager != null)
			return manager;		
		
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);  
		
		config.common().objectClass(Pessoa.class).cascadeOnDelete(false);;
		config.common().objectClass(Pessoa.class).cascadeOnUpdate(true);;
		config.common().objectClass(Pessoa.class).cascadeOnActivate(true);
		config.common().objectClass(Endereco.class).cascadeOnDelete(false);;
		config.common().objectClass(Endereco.class).cascadeOnUpdate(true);;
		config.common().objectClass(Endereco.class).cascadeOnActivate(true);
		config.common().objectClass(Bairro.class).cascadeOnDelete(false);;
		config.common().objectClass(Bairro.class).cascadeOnUpdate(true);;
		config.common().objectClass(Bairro.class).cascadeOnActivate(true);
		
		
		manager = Db4oEmbedded.openFile(config, "banco.db4o");
		return manager;
	}

	public static void desconectar() {
		if(manager!=null) {
			manager.close();
			manager=null;
		}
	}
	
	
}
