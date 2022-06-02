package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Clientes;

public class ClientesDAOImpl implements ClientesDAO {

	private final static String JDBC_CLASS = "org.mariadb.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/bdestacionamento?allowMultiQueries=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "p4ssw0rd";
    private Connection con;
    
    public ClientesDAOImpl() {
        try {
            Class.forName(JDBC_CLASS);
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    
	
	@Override
	public void inserir(Clientes c) {
		String sql = "INSERT INTO clientes (nome, cpf, plano, adesao, status)";
        sql += " VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getPlano());
            stmt.setDate(4, java.sql.Date.valueOf(c.getDataAdesao()));
            stmt.setString(5, c.getStatus());
            System.out.println("Inserido");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	

	@Override
	public List<Clientes> consultar(String nome) {
	        List<Clientes> lista = new ArrayList<>();
	        String sql = "SELECT * FROM clientes WHERE nome LIKE '" + nome + "%'";

	        
	        try {
	            PreparedStatement stmt = con.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                Clientes clientes = new Clientes();
	                clientes.setNome(rs.getString("nome"));
	                clientes.setCpf(rs.getString("cpf"));
	                clientes.setPlano(rs.getString("plano"));
	                clientes.setDataAdesao(rs.getDate("adesao").toLocalDate());
	                clientes.setStatus(rs.getString("status"));
	                lista.add(clientes);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return lista;	
	        
	}

}
