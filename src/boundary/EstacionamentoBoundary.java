package boundary;

import controller.EstacionamentoController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class EstacionamentoBoundary extends Application{
	private Stage stage;
	private String imagem = "fundo.jpg";
	Estilos estilos = new Estilos();
	EstacionamentoController control = new EstacionamentoController();
	
	
	Label lblPlaca = new Label ("Placa");
	Label lblModelo = new Label ("Modelo");
	Label lblCor = new Label ("Cor");
	Label lbldata = new Label ("Data do registro");
	Label lblNumOrdem = new Label ("Num Ordem");

	Label lblHoraE = new Label("Entrada");
	Label lblHoraS = new Label("Saida");
	
	
	TextField txtPlaca = new TextField();
	TextField txtModelo = new TextField();
	TextField txtCor = new TextField();
	DatePicker txtData = new DatePicker();
	Text txtNumOrdem = new Text();
	TextField txtHoraEntrada = new TextField();
	TextField txtMinutoEntrada = new TextField();
	TextField txtHoraSaida = new TextField();
	TextField txtMinutoSaida = new TextField();
	
	GridPane formularioEstac = new GridPane();
	GridPane formularioEntrada = new GridPane();
	GridPane formularioSaida = new GridPane();

	Button btnRg = new Button("Registrar");
	Button btnPesq = new Button("Consultar");
	Button btnVoltar = new Button("Clientes");
	
	
	
	@Override
	public void start(Stage stage) throws Exception {
		Background bGround = estilos.setarPlanoDeFundo(imagem);
		
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
		
		
		
		
		btnVoltar.setOnAction(e ->{
			//etStage().close();
			//control.voltar();
		});
		
		Scene scn = new Scene(formularioEstac,1400,800);
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
