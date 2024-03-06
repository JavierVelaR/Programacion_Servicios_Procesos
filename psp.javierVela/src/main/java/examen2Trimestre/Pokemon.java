package examen2Trimestre;

import java.io.Serializable;

public class Pokemon implements Serializable{
	private String nombre;
	private double vida;
	private int ataque;
	private int defensa;

	public Pokemon(String nombre, double vida, int ataque, int defensa) {
		super();
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getVida() {
		return vida;
	}
	public void setVida(double vida) {
		this.vida = vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	@Override
	public String toString() {
		return "Nombre: " + nombre + "\n\tVida: " + vida + "\n\tAtaque: " + ataque + "\n\tDefensa: " + defensa;
	}

	
}
