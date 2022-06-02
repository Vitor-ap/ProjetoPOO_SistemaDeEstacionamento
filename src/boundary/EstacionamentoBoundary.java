package boundary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import controller.EstacionamentoController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.LocalDateStringConverter;

public class EstacionamentoBoundary extends Application {
	EstacionamentoController control = new EstacionamentoController();
	Estilos estilos = new Estilos();
	private Stage stage;
	private String imagem = "fundopreto2.jpg";

	Label lblPlaca = new Label("Placa");
	Label lblModelo = new Label("Modelo");
	Label lblCor = new Label("Cor");
	Label lbldata = new Label("Data do registro");

	Label lblHoraE = new Label("Entrada");
	Label lblHoraS = new Label("Saida");

	TextField txtPlaca = new TextField();
	TextField txtModelo = new TextField();
	TextField txtCor = new TextField();
	DatePicker txtData = new DatePicker(LocalDate.now());
	TextField txtHoraEntrada = new TextField();
	TextField txtMinutoEntrada = new TextField();
	TextField txtHoraSaida = new TextField();
	TextField txtMinutoSaida = new TextField();

	Button btnRg = new Button("Registrar");
	Button btnPesq = new Button("Consultar");
	Button btnFechar = new Button("Voltar");

	@Override
	public void start(Stage stage) throws Exception {
		Background bGround = estilos.setarPlanoDeFundo(imagem);


		GridPane formularioEstac = new GridPane();
		GridPane formularioEntrada = new GridPane();
		GridPane formularioSaida = new GridPane();
		BorderPane painelPrincipal = new BorderPane();

		Bindings.bindBidirectional(control.placaProperty(), txtPlaca.textProperty());
		Bindings.bindBidirectional(control.modeloProperty(), txtModelo.textProperty());
		Bindings.bindBidirectional(control.corProperty(), txtCor.textProperty());
		Bindings.bindBidirectional(txtData.valueProperty(), control.dataProperty());
		Bindings.bindBidirectional(control.hrEntradaProperty(), txtHoraEntrada.textProperty());
		Bindings.bindBidirectional(control.minEntradaProperty(),txtMinutoEntrada.textProperty());
		Bindings.bindBidirectional(control.hrSaidaProperty(),txtHoraSaida.textProperty());
		Bindings.bindBidirectional(control.minSaidaProperty(),txtMinutoSaida.textProperty());

		formularioEntrada.add(txtHoraEntrada, 0, 0);
		formularioEntrada.add(txtMinutoEntrada, 2, 0);
		formularioEntrada.add(new Label(" : "), 1, 0);
		formularioSaida.add(txtHoraSaida, 0, 0);
		formularioSaida.add(txtMinutoSaida, 2, 0);
		formularioSaida.add(new Label(" : "), 1, 0);
		txtHoraEntrada.setPrefSize(80, 60);
		txtMinutoEntrada.setPrefSize(80, 60);
		txtHoraSaida.setPrefSize(80, 60);
		txtMinutoSaida.setPrefSize(80, 60);



		formularioEstac.setStyle(estilos.GetEstiloSub());
		formularioEstac.setHgap(50);
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
		formularioEstac.add(btnRg, 4, 0);
		formularioEstac.add(btnPesq, 4, 1);
		formularioEstac.add(btnFechar, 4, 2);

		btnRg.setStyle(estilos.getEstiloBotao1());
		btnPesq.setStyle(estilos.getEstiloBotao1());
		btnFechar.setStyle(estilos.getEstiloBotao1());
		

		painelPrincipal.setTop(formularioEstac);
		painelPrincipal.setCenter(control.getTable());

		btnRg.setOnAction(e -> {
			control.adicionar();
		});
		
		btnPesq.setOnAction(e -> {
			control.pesquisar();
		});

		btnFechar.setOnAction(e ->{
			getStage().close();
		});
		
		
		
		Scene scn = new Scene(painelPrincipal, 1400, 800);
		//stage.setTitle("Registro de estacionamento");
		stage.initStyle(StageStyle.UNDECORATED);
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
