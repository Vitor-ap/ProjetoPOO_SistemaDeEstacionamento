package model;

import java.time.LocalDate;


public class Estacionamento {

	private String placa;
	private String modelo;
	private String cor;
	private LocalDate data;
	private int hrEntrada;
	private int minEntrada;
	private int hrSaida;
	private int minSaida;
	private int numOrdem;
	
	
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
	public int getHrEntrada() {
		return hrEntrada;
	}
	public void setHrEntrada(int hrEntrada) {
		this.hrEntrada = hrEntrada;
	}
	public int getMinEntrada() {
		return minEntrada;
	}
	public void setMinEntrada(int minEntrada) {
		this.minEntrada = minEntrada;
	}
	public int getHrSaida() {
		return hrSaida;
	}
	public void setHrSaida(int hrSaida) {
		this.hrSaida = hrSaida;
	}
	public int getMinSaida() {
		return minSaida;
	}
	public void setMinSaida(int minSaida) {
		this.minSaida = minSaida;
	}
	
	public int GetNumOrdem() {
		return numOrdem;
	}
	
	public void setNumOrdem(int numOrdem) {
		this.numOrdem = numOrdem;
	}
	
}
