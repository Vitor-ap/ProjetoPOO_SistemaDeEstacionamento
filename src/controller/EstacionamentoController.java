package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import boundary.Estilos;
import dao.EstacionamentoDAO;
import dao.EstacionamentoDAOImpl;
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
import model.Estacionamento;

public class EstacionamentoController {
	Estilos estilos = new Estilos();
	
	
	private EstacionamentoDAO dao = new EstacionamentoDAOImpl();
	private TableView<Estacionamento>table = new TableView<>();
	private ObservableList<Estacionamento> estacionamento = FXCollections.observableArrayList();
	
	private StringProperty placa = new SimpleStringProperty();
	private StringProperty modelo = new SimpleStringProperty();
	private StringProperty cor = new SimpleStringProperty();
	private ObjectProperty<LocalDate> data = new SimpleObjectProperty<>();
	private StringProperty hrEntrada = new SimpleStringProperty();
	private StringProperty minEntrada = new SimpleStringProperty();
	private StringProperty hrSaida = new SimpleStringProperty();
	private StringProperty minSaida = new SimpleStringProperty();
	

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
	
	public StringProperty hrEntradaProperty() {
		return hrEntrada;
	}
	
	public StringProperty minEntradaProperty() {
		return minEntrada;
	}
	
	public StringProperty hrSaidaProperty() {
		return hrSaida;
	}
	
	public StringProperty minSaidaProperty() {
		return minSaida;
}

	
	@SuppressWarnings("unchecked")
	public EstacionamentoController() {
		TableColumn<Estacionamento, String> col1 = new TableColumn<>("PLACA");
		col1.setCellValueFactory(new PropertyValueFactory<>("placa"));
		
		TableColumn<Estacionamento, String> col2 = new TableColumn<>("MODELO");
		col2.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		
		TableColumn<Estacionamento, String> col3 = new TableColumn<>("COR");
		col3.setCellValueFactory(new PropertyValueFactory<>("cor"));
		
		
		TableColumn<Estacionamento, String> col4 = new TableColumn<>("DATA");
		col4.setCellValueFactory((itemData)-> {
            LocalDate dt = itemData.getValue().getData();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return new ReadOnlyStringWrapper(dt.format(formatter));
		});
	
		TableColumn<Estacionamento, String> col5 = new TableColumn<>("HRENTRADA");
		col5.setCellValueFactory(new PropertyValueFactory<>("hrEntrada"));
		
		TableColumn<Estacionamento, String> col6 = new TableColumn<>("MINENTRADA");
		col6.setCellValueFactory(new PropertyValueFactory<>("minEntrada"));
		
		TableColumn<Estacionamento, String> col7 = new TableColumn<>("HRSAIDA");
		col7.setCellValueFactory(new PropertyValueFactory<>("hrSaida"));
		
		TableColumn<Estacionamento, String> col8 = new TableColumn<>("MINSAIDA");
		col8.setCellValueFactory(new PropertyValueFactory<>("minSaida"));
		
		table.getColumns().addAll(col1,col2,col3,col4,col5,col6,col7,col8);
		
		col1.setPrefWidth(175);
		col2.setPrefWidth(175);
		col3.setPrefWidth(175);
		col4.setPrefWidth(175);
		col5.setPrefWidth(175);
		col6.setPrefWidth(175);
		col7.setPrefWidth(175);
		col8.setPrefWidth(175);
		table.setStyle(estilos.GetEstiloSub());
		table.setItems(estacionamento);
		
	}
	
	
	public void adicionar() {
		Estacionamento e = new Estacionamento();
		e.setPlaca(placa.get());
		e.setModelo(modelo.get());
		e.setCor(cor.get());
		e.setData(data.get());
		e.setHrEntrada(hrEntrada.get());
		e.setMinEntrada(minEntrada.get());
		e.setHrSaida(hrSaida.get());
		e.setMinSaida(minSaida.get());
		estacionamento.add(e);
		JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
		dao.inserir(e);
		esvaziarEstac();
	}
	
	public void pesquisar() {
	List<Estacionamento> lista = dao.consultar(placa.get());
    estacionamento.clear();
    estacionamento.addAll(lista);
    esvaziarEstac();
	}
	
	
	public void esvaziarEstac() {
	  placa.set("");
	    modelo.set("");
	    cor.set("");
	    data.set(LocalDate.now());
	    hrEntrada.set("");
	    minEntrada.set("");
	    hrSaida.set("");
	    minSaida.set("");
	}
	
	public TableView<Estacionamento> getTable() {
		return table;
	}
	
	
}


