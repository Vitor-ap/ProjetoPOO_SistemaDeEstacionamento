package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import boundary.EstacionamentoBoundary;
import boundary.Estilos;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Clientes;

public class ClientesController {
	
	Estilos estilos = new Estilos();
	private TableView<Clientes> table = new TableView<>();
	private ObservableList<Clientes> clientes = FXCollections.observableArrayList();
	
	EstacionamentoBoundary estacionamento = new EstacionamentoBoundary();

	private StringProperty nome = new SimpleStringProperty();
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty plano = new SimpleStringProperty();
	private ObjectProperty<LocalDate> dataAdesao = new SimpleObjectProperty<>();
	private StringProperty status = new SimpleStringProperty();
	
	public StringProperty nomeProperty() {
		return nome;
	}
	
	public StringProperty cpfProperty() {
		return cpf;
	}
	
	
	public StringProperty planoProperty() {
		return plano;
	}
	
	public ObjectProperty<LocalDate> dataAdesaoProperty(){
		return dataAdesao;
	}
	
	public StringProperty statusProperty() {
		return status;
	}

	
	
	public ClientesController() {
		TableColumn<Clientes, String> col1 = new TableColumn<>("NOME");
		col1.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		TableColumn<Clientes, String> col2 = new TableColumn<>("CPF");
		col2.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		
		TableColumn<Clientes, String> col3 = new TableColumn<>("PLANO");
		col3.setCellValueFactory(new PropertyValueFactory<>("plano"));
		
		TableColumn<Clientes, String> col4 = new TableColumn<>("DATA DE ADESAO");
		col4.setCellValueFactory((itemData)-> {
            LocalDate dt = itemData.getValue().getDataAdesao();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return new ReadOnlyStringWrapper(dt.format(formatter));
		});
		
		TableColumn<Clientes, String> col5 = new TableColumn<>("STATUS");
		col5.setCellValueFactory(new PropertyValueFactory<>("status"));
	
		table.getColumns().addAll(col1, col2, col3, col4, col5);
		
		col1.setPrefWidth(190);
		col2.setPrefWidth(190);
		col3.setPrefWidth(190);
		col4.setPrefWidth(190);
		col5.setPrefWidth(190);

		table.setStyle(estilos.GetEstiloSub());
		
		table.setItems(clientes);
		table.setEditable(true);
		
	}
	
	
	public void adicionar() {
		Clientes c = new Clientes();
		c.setNome(nome.get());
		c.setCpf(cpf.get());
		c.setPlano(plano.get());
		c.setDataAdesao(dataAdesao.get());
		c.setStatus(status.get());
		clientes.add(c);
	}
	
	
	
	public TableView <Clientes>getTable() {
        return table;
	}

	
	
	public void acessaEstac() {
		try {
			estacionamento.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
