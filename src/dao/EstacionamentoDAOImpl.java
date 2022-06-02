package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Estacionamento;

public class EstacionamentoDAOImpl implements EstacionamentoDAO {

	private final static String JDBC_CLASS = "org.mariadb.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/bdestacionamento?allowMultiQueries=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "p4ssw0rd";
    private Connection con;
    
    public EstacionamentoDAOImpl() {
        try {
            Class.forName(JDBC_CLASS);
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    
	
	@Override
	public void inserir(Estacionamento e) {
		String sql = "INSERT INTO estacionamento (placa, modelo, cor, data, "
				+ "horaentrada, minentrada, horasaida, minsaida) ";
        sql += " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getPlaca());
            stmt.setString(2, e.getModelo());
            stmt.setString(3, e.getCor());
            stmt.setDate(4, java.sql.Date.valueOf(e.getData()));
            stmt.setString(5, e.getHrEntrada());
            stmt.setString(6, e.getMinEntrada());
            stmt.setString(7, e.getHrSaida());
            stmt.setString(8, e.getMinSaida());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	

	@Override
	public List<Estacionamento> consultar(String placa) {
	        List<Estacionamento> lista = new ArrayList<>();
	        String sql = "SELECT * FROM estacionamento WHERE placa LIKE '%" + placa + "'";
	        
	        try {
	            PreparedStatement stmt = con.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                Estacionamento estacionamento = new Estacionamento();
	                estacionamento.setPlaca(rs.getString("placa"));
	                estacionamento.setModelo(rs.getString("modelo"));
	                estacionamento.setCor(rs.getString("cor"));
	                estacionamento.setData(rs.getDate("data").toLocalDate());
	                estacionamento.setHrEntrada(rs.getString("horaentrada"));
	                estacionamento.setMinEntrada(rs.getString("minentrada"));
	                estacionamento.setHrSaida(rs.getString("horasaida"));
	                estacionamento.setMinSaida(rs.getString("minsaida"));
	                lista.add(estacionamento);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return lista;		
	}

}
