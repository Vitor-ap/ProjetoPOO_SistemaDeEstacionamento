package boundary;

import java.time.format.DateTimeFormatter;

import controller.ClientesController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
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
import javafx.stage.StageStyle;
import javafx.util.converter.LocalDateStringConverter;

public class ClientesBoundary extends Application{
	Estilos estilos = new Estilos();
	ClientesController controlCl = new ClientesController();
	private Stage stage;
	private String imagem = "fundopreto.jpg";
	
	
	
	Label lblNome = new Label("Nome");
	Label lblCpf = new Label("CPF");
	Label lblPlano = new Label("Plano");
	Label lblData = new Label("Adesao");
	Label lblStatus = new Label("Status");
	
	
	
	Button btnSalvar = new Button("Salvar");
	Button btnPesq = new Button("Pesquisar");
	Button btnFechar = new Button("Voltar");
	
	TextField txtNome = new TextField();
	TextField txtCpf = new TextField();
	DatePicker txtdataAdesao = new DatePicker();

	ComboBox<String> txtPlano = new ComboBox<String>(FXCollections.observableArrayList("Mensal", "Semestral","Anual"));
	ComboBox<String> txtStatus = new ComboBox<String>(FXCollections.observableArrayList("Ativo", "Inativo"));
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Background bGround = estilos.setarPlanoDeFundo(imagem);
			

		
        Bindings.bindBidirectional(controlCl.nomeProperty(), txtNome.textProperty());
        Bindings.bindBidirectional(controlCl.cpfProperty(), txtCpf.textProperty());
        Bindings.bindBidirectional(txtPlano.valueProperty(), controlCl.planoProperty());
        Bindings.bindBidirectional(txtdataAdesao.valueProperty(), controlCl.dataAdesaoProperty());
        Bindings.bindBidirectional(txtStatus.valueProperty(), controlCl.statusProperty());
		
		
		
		BorderPane painelPrincipal = new BorderPane();
		GridPane formularioCl = new GridPane();
		
		formularioCl.add(lblNome, 0, 0);
		formularioCl.add(txtNome, 1, 0);
		formularioCl.add(lblCpf, 0, 1);
		formularioCl.add(txtCpf, 1, 1);
		formularioCl.add(lblPlano, 0, 2);
		formularioCl.add(txtPlano, 1, 2);
		txtPlano.setPrefSize(250, 40);
		formularioCl.add(lblData, 0,3);
		formularioCl.add(txtdataAdesao, 1, 3);
		formularioCl.add(lblStatus, 0, 4);
		formularioCl.add(txtStatus, 1, 4);
		txtStatus.setPrefSize(250, 40);
		
		formularioCl.add(btnSalvar,0,5);
		formularioCl.add(btnPesq,0,6);
		formularioCl.add(btnFechar,0,7);
		btnSalvar.setStyle(estilos.getEstiloBotao1());
		btnPesq.setStyle(estilos.getEstiloBotao1());
		btnFechar.setStyle(estilos.getEstiloBotao1());
		
		formularioCl.setStyle(estilos.GetEstiloSub());
		formularioCl.setHgap(30);
		formularioCl.setVgap(30);
		formularioCl.setAlignment(Pos.CENTER);
		
		painelPrincipal.setLeft(formularioCl);
		painelPrincipal.setBackground(bGround);
		painelPrincipal.setCenter(controlCl.getTable());
		
		
		btnSalvar.setOnAction(e ->{
			controlCl.adicionar();
		});
		
		
		
		btnFechar.setOnAction(e ->{
			getStage().close();
		});
		
		
		Scene scn = new Scene(painelPrincipal, 1400,800);
		stage.initStyle(StageStyle.UNDECORATED);
		//stage.setTitle("Clientes");
		stage.setScene(scn);
		stage.show();

		setStage(stage);
		
		
	}

	
	public Stage getStage() {
		return stage;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
