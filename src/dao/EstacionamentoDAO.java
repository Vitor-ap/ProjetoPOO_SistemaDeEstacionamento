package dao;

import java.util.List;

import model.Estacionamento;

	public interface EstacionamentoDAO {
	    void inserir(Estacionamento e);
	    List<Estacionamento> consultar(String placa);
	}
	