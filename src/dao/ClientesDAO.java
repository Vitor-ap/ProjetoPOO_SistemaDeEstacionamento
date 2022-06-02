package dao;



import java.util.List;

import model.Clientes;

	public interface ClientesDAO {
	    void inserir(Clientes e);
	    List<Clientes> consultar(String nome);
	}
	

