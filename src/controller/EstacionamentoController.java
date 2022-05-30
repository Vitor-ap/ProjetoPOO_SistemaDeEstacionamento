package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Estacionamento;

public class EstacionamentoController {

	//Principal principal = new Principal();
	
	/*public void voltar() {
		try {
			principal.start(new Stage());
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/       
	
	
	
	
	
	
	
	
	private TableView<Estacionamento>table = new TableView<>();
	private ObservableList<Estacionamento> estacionamento = FXCollections.observableArrayList();
	
	public StringProperty placa = new SimpleStringProperty();
	public StringProperty modelo = new SimpleStringProperty();
	private StringProperty cor = new SimpleStringProperty();
	private ObjectProperty<LocalDate> data = new SimpleObjectProperty<>();
	private IntegerProperty hrEntrada = new SimpleIntegerProperty();
	private IntegerProperty minEntrada = new SimpleIntegerProperty();
	private IntegerProperty hrSaida = new SimpleIntegerProperty();
	private IntegerProperty minSaida = new SimpleIntegerProperty();
	//private IntegerProperty numOrdem = new SimpleIntegerProperty();
	

	public StringProperty placaProperty() {
		return placa;
	}
	
	public StringProperty modeloProperty() {
		return modelo;
	}
	public StringProperty corProperty() {
		return cor;
	}
	
	public ObjectProperty<LocalDate> dataProperty() {
		return data;
	}
	
	public IntegerProperty hrEntradaProperty() {
		return hrEntrada;
	}
	
	public IntegerProperty minEntradaProperty() {
		return minEntrada;
	}
	
	public IntegerProperty hrSaidaProperty() {
		return hrSaida;
	}
	
	public IntegerProperty minSaidaProperty() {
		return minSaida;
}

	
	public EstacionamentoController() {
		TableColumn<Estacionamento, String> col1 = new TableColumn<>("Placa");
		col1.setCellValueFactory(new PropertyValueFactory<>("placa"));
		
		TableColumn<Estacionamento, String> col2 = new TableColumn<>("Modelo");
		col2.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		
		TableColumn<Estacionamento, String> col3 = new TableColumn<>("Cor");
		col3.setCellValueFactory(new PropertyValueFactory<>("cor"));
		
		
		TableColumn<Estacionamento, String> col4 = new TableColumn<>("Data");
		col4.setCellValueFactory((itemData)-> {
            LocalDate dt = itemData.getValue().getData();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return new ReadOnlyStringWrapper(dt.format(formatter));
		});
	
		//TableColumn<Estacionamento, String> col4 = new TableColumn<>("Entrada(Hr)");
		//col4.setCellValueFactory(new PropertyValueFactory<>("Entrada(Hr)"));
		
		//TableColumn<Estacionamento, String> col5 = new TableColumn<>("Entrada(Min)");
		//col5.setCellValueFactory(new PropertyValueFactory<>("Entrada(Min)"));
		
		//TableColumn<Estacionamento, String> col6 = new TableColumn<>("Saida(Hr)");
		//col6.setCellValueFactory(new PropertyValueFactory<>("Saida(Hr)"));
		
		//TableColumn<Estacionamento, String> col7 = new TableColumn<>("Saida(Hr)");
		//col7.setCellValueFactory(new PropertyValueFactory<>("Saida(Min)"));
		
		table.getColumns().addAll(col1,col2,col3,col4);
		
		table.setItems(estacionamento);
		
	}
	
	
	public void adicionar() {
		Estacionamento e = new Estacionamento();
		e.setPlaca(placa.get());
		e.setModelo(modelo.get());
		e.setCor(cor.get());
		e.setData(data.get());
		//e.setHrEntrada(hrEntrada.get());
		//e.setMinEntrada(minEntrada.get());
		//e.setHrSaida(hrSaida.get());
		//e.setMinSaida(minSaida.get());
		estacionamento.add(e);
		
		
	}
	
	public TableView<Estacionamento> getTable() {
		return table;
	}
	
	
}


