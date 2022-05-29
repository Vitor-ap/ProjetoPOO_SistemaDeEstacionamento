package boundary;

import controller.ClientesController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClientesBoundary extends Application{
	Estilos estilos = new Estilos();
	ClientesController controlCl = new ClientesController();
	private Stage stage;
	private String imagem = "clientes2.jpg";
	
	
	
	@Override
	public void start(Stage stage) throws Exception {
		Background bGround = estilos.setarPlanoDeFundo(imagem);
		
	
		Label lblNome = new Label("Nome");
		Label lblCpf = new Label("CPF");
		Label lblPlano = new Label("Plano");
		Label lblData = new Label("Adesao");
		Label lblStatus = new Label("Status");
		
		
		
		Button btnSalvar = new Button("Salvar");
		Button btnPesq = new Button("Pesquisar");
		Button btnEstac = new Button("Estacionamento");
		
		TextField txtNome = new TextField();
		TextField txtCpf = new TextField();
		DatePicker data = new DatePicker();
		
		ObservableList<String> listPlano = FXCollections.observableArrayList("Mensal", "Semestral","Anual");
		final ComboBox plano = new ComboBox(listPlano);
		plano.setPrefSize(250, 40);
		
		ObservableList<String> listStatus = FXCollections.observableArrayList("Ativo", "Inativo");
		final ComboBox status = new ComboBox(listStatus);
		status.setPrefSize(250, 40);
		
		BorderPane painelPrincipal = new BorderPane();
		GridPane formularioCl = new GridPane();
		
		formularioCl.add(lblNome, 0, 0);
		formularioCl.add(txtNome, 1, 0);
		formularioCl.add(lblCpf, 0, 1);
		formularioCl.add(txtCpf, 1, 1);
		formularioCl.add(lblPlano, 0, 2);
		formularioCl.add(plano, 1, 2);
		formularioCl.add(lblData, 0,3);
		formularioCl.add(data, 1, 3);
		formularioCl.add(lblStatus, 0, 4);
		formularioCl.add(status, 1, 4);
		formularioCl.add(btnSalvar,0,5);
		formularioCl.add(btnPesq,0,6);
		formularioCl.add(btnEstac,0,7);
		
		
		formularioCl.setStyle(estilos.GetEstiloSub());
		formularioCl.setHgap(30);
		formularioCl.setVgap(30);
		
		painelPrincipal.setLeft(formularioCl);
		painelPrincipal.setBackground(bGround);
		
		
		
		
		btnEstac.setOnAction(e ->{
			controlCl.acessaEstac();
		});
		
		
		Scene scn = new Scene(painelPrincipal, 1400,800);
		
		stage.setTitle("Clientes");
		stage.setScene(scn);
		stage.show();
		stage.setMaximized(false);
		stage.setResizable(false);
		setStage(stage);
		
		
	}

	
	public Stage getStage() {
		return stage;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
