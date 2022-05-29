package controller;

import boundary.EstacionamentoBoundary;
import javafx.stage.Stage;

public class ClientesController {

	
	EstacionamentoBoundary estacionamento = new EstacionamentoBoundary();


	public void acessaEstac() {
		try {
			estacionamento.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	

	
}
