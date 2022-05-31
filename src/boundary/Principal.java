package boundary;

import controller.PrincipalController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Principal extends Application {


	Estilos estilos = new Estilos();
	PrincipalController p = new PrincipalController();

	private Stage stage;
	private String imagem = "predioeaudi2.jpg";
	
//criacao das Labels	
	private Label titulo = new Label("        Gerenciador de Estacionamento        ");
	
//Criacao dos Botoes	
	
	
	private Button btnMenuEstac = new Button("Controle de estacionamento");
	private Button btnMenuCl =   new Button("Cadastro dos clientes");
	private Button btnFechar =   new Button("Fechar");

 	
	@Override
	public void start(Stage stage) throws Exception {
		
		//paineis
		GridPane principal = new GridPane();

		Background bGround = estilos.setarPlanoDeFundo(imagem);
		

		btnMenuEstac.setStyle(estilos.getEstiloBotao1());
		btnFechar.setStyle(estilos.getEstiloBotao1());
		btnMenuCl.setStyle(estilos.getEstiloBotao1());
		
		
		
		btnMenuEstac.setOnAction(e->{
			p.acessaEstac();
		});

		
		btnMenuCl.setOnAction(e->{
			p.acessaClientes();
		});
		
		btnFechar.setOnAction(e->{
			getStage().close();
		});
				
		
		principal.setHgap(100);
		principal.setVgap(70);
		principal.setBackground(bGround);
		principal.add(titulo, 0, 6, 3, 6);
		principal.add(btnMenuEstac, 2,2);
		principal.add(btnMenuCl, 2, 4);
		principal.add(btnFechar, 2, 6);
		titulo.setStyle(estilos.GetEstitloTitulo());
		titulo.setEffect(new Lighting());

		
		Scene scn = new Scene(principal, 1400, 800);
		stage.setMaximized(false);
		
		
		stage.setResizable(false);
		
		stage.setScene(scn);
		stage.setTitle("Estacionamento");
		stage.show();
		setStage(stage);
		
	}
	
	public static void main(String[] args) {
		Application.launch(Principal.class, args);	}
	
	
		public  Stage getStage() {
			return stage;
		
	}
	
		public void setStage(Stage stage) {
			this.stage = stage;
		}
	
}
