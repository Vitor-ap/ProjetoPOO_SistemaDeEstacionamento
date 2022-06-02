package model;

import java.time.LocalDate;


public class Estacionamento {

	private String placa;
	private String modelo;
	private String cor;
	private LocalDate data;
	private String hrEntrada;
	private String minEntrada;
	private String hrSaida;
	private String minSaida;
	private String numOrdem;
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getHrEntrada() {
		return hrEntrada;
	}
	public void setHrEntrada(String hrEntrada) {
		this.hrEntrada = hrEntrada;
	}
	public String getMinEntrada() {
		return minEntrada;
	}
	public void setMinEntrada(String minEntrada) {
		this.minEntrada = minEntrada;
	}
	public String getHrSaida() {
		return hrSaida;
	}
	public void setHrSaida(String hrSaida) {
		this.hrSaida = hrSaida;
	}
	public String getMinSaida() {
		return minSaida;
	}
	public void setMinSaida(String minSaida) {
		this.minSaida = minSaida;
	}
	
	public String GetNumOrdem() {
		return numOrdem;
	}
	
	public void setNumOrdem(String numOrdem) {
		this.numOrdem = numOrdem;
	}
	
}
