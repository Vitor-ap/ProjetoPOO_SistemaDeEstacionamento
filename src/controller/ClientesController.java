package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import boundary.EstacionamentoBoundary;
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

	private TableView<Clientes> table = new TableView<>();
	private ObservableList<Clientes> clientes = FXCollections.observableArrayList();
	
	EstacionamentoBoundary estacionamento = new EstacionamentoBoundary();

	public StringProperty nome = new SimpleStringProperty("");
	public StringProperty cpf = new SimpleStringProperty("");
	public StringProperty plano = new SimpleStringProperty("");
	public ObjectProperty<LocalDate> dataAdesao = new SimpleObjectProperty<>();
	public StringProperty status = new SimpleStringProperty("");
	
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
		TableColumn<Clientes, String> col1 = new TableColumn<>("Nome");
		col1.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		TableColumn<Clientes, String> col2 = new TableColumn<>("Cpf");
		col2.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		
		TableColumn<Clientes, String> col3 = new TableColumn<>("Plano");
		col3.setCellValueFactory(new PropertyValueFactory<>("plano"));
		
		TableColumn<Clientes, String> col4 = new TableColumn<>("Data Adesao");
		col4.setCellValueFactory((itemData)-> {
            LocalDate dt = itemData.getValue().getDataAdesao();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return new ReadOnlyStringWrapper(dt.format(formatter));
		});
		
		TableColumn<Clientes, String> col5 = new TableColumn<>("Status");
		col5.setCellValueFactory(new PropertyValueFactory<>("status"));
	
		table.getColumns().addAll(col1, col2, col3, col4, col5);
		
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
