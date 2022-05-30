package boundary;

import java.time.format.DateTimeFormatter;

import controller.EstacionamentoController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;



public class EstacionamentoBoundary extends Application{
	EstacionamentoController control = new EstacionamentoController();
	Estilos estilos = new Estilos();
	private Stage stage;
	private String imagem = "fundo.jpg";
	
	
	
	
	Label lblPlaca = new Label ("Placa");
	Label lblModelo = new Label ("Modelo");
	Label lblCor = new Label ("Cor");
	Label lbldata = new Label ("Data do registro");


	Label lblHoraE = new Label("Entrada");
	Label lblHoraS = new Label("Saida");
	
	
	TextField txtPlaca = new TextField();
	TextField txtModelo = new TextField();
	TextField txtCor = new TextField();
	TextField txtData = new TextField();
	TextField txtHoraEntrada = new TextField();
	TextField txtMinutoEntrada = new TextField();
	TextField txtHoraSaida = new TextField();
	TextField txtMinutoSaida = new TextField();
	
	
	
	Button btnRg = new Button("Registrar");
	Button btnPesq = new Button("Consultar");
	Button btnVoltar = new Button("Clientes");
	
	
	
	@Override
	public void start(Stage stage) throws Exception {
		Background bGround = estilos.setarPlanoDeFundo(imagem);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateStringConverter ldc =
               new LocalDateStringConverter(formatter, null);
        
      
        GridPane formularioEstac = new GridPane();
    	GridPane formularioEntrada = new GridPane();
    	GridPane formularioSaida = new GridPane();
    	BorderPane painelPrincipal = new BorderPane();

        
		Bindings.bindBidirectional(control.placaProperty(), txtPlaca.textProperty());
		Bindings.bindBidirectional(control.modeloProperty(), txtModelo.textProperty());
		Bindings.bindBidirectional(control.corProperty(), txtCor.textProperty());
		Bindings.bindBidirectional(txtData.textProperty(), control.dataProperty(), ldc);
		
		
		
		formularioEntrada.add(txtHoraEntrada, 0, 0);
		formularioEntrada.add(txtMinutoEntrada, 2, 0);
		formularioEntrada.add(new Label(" : "), 1, 0);
		formularioSaida.add(txtHoraSaida, 0, 0);
		formularioSaida.add(txtMinutoSaida, 2, 0);
		formularioSaida.add(new Label(" : "), 1, 0);
		txtHoraEntrada.setPrefSize(80, 60);
		txtMinutoEntrada.setFont(estilos.getFontTxt());
		txtHoraSaida.setPrefSize(80, 60);
		txtMinutoSaida.setFont(estilos.getFontTxt());
		
		
		formularioEstac.setStyle(estilos.GetEstiloSub());
		formularioEstac.setHgap(10);
		formularioEstac.setVgap(10);
		formularioEstac.add(lblPlaca, 0, 0);
		formularioEstac.add(txtPlaca, 1, 0);
		formularioEstac.add(lblModelo, 2, 0);
		formularioEstac.add(txtModelo, 3, 0);
		formularioEstac.add(lblCor, 0, 1);
		formularioEstac.add(txtCor, 1, 1);
		formularioEstac.add(lbldata, 2, 1);
		formularioEstac.add(txtData, 3, 1);
		formularioEstac.add(lblHoraE, 0, 2);
		formularioEstac.add(formularioEntrada, 1, 2);
		formularioEstac.add(lblHoraS, 2, 2);
		formularioEstac.add(formularioSaida, 3, 2);
		formularioEstac.add(btnRg, 1, 3);
		formularioEstac.add(btnPesq, 2, 3);
		formularioEstac.add(btnVoltar, 3, 3);
		
		painelPrincipal.setTop(formularioEstac);
		painelPrincipal.setCenter(control.getTable());
		
		
		
		btnRg.setOnAction(e ->{
			control.adicionar();
		});
		
		btnVoltar.setOnAction(e ->{
			//etStage().close();
			//control.voltar();
		});
		
		
		
		
		
		Scene scn = new Scene(painelPrincipal,1400,800);
		stage.setTitle("Registro de estacionamento");
		stage.setScene(scn);
		formularioEstac.setBackground(bGround);
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
