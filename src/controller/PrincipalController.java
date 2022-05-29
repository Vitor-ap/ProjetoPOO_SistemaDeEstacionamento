package controller;

import boundary.ClientesBoundary;
import boundary.EstacionamentoBoundary;
import javafx.stage.Stage;

public class PrincipalController {

	EstacionamentoBoundary estacionamento = new EstacionamentoBoundary();
	ClientesBoundary clientes = new ClientesBoundary();

	public void acessaEstac() {
		try {
			estacionamento.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	public void acessaClientes() {
		try {
			clientes.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	
}


