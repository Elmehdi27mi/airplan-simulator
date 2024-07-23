package com.example.volapp.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Avion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String type;
	@Column
	private int consomation;
	@Column
	private int capaciteMaximale;
	@Column
	private int niveauKerosene;
	@Column
	private int altitudeMximale;
	@Column
	private double altitude;
	@Column
	private int vitess;
	@Column
	private int vitessMaximale;

	@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "aeroport_id")
    private Aeroport aeroport;

	public Avion() {
		// TODO Auto-generated constructor stub
	}
	public double getAltitude() {
		return altitude;
	}
	public int getAltitudeMximale() {
		return altitudeMximale;
	}
	public int getCapaciteMaximale() {
		return capaciteMaximale;
	}
	public int getConsomation() {
		return consomation;
	}
	public int getId() {
		return id;
	}
	public int getNiveauKerosene() {
		return niveauKerosene;
	}
	public String getType() {
		return type;
	}
	public int getVitess() {
		return vitess;
	}
	public int getVitessMaximale() {
		return vitessMaximale;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	public void setAltitudeMximale(int altitudeMximale) {
		this.altitudeMximale = altitudeMximale;
	}
	public void setCapaciteMaximale(int capaciteMaximale) {
		this.capaciteMaximale = capaciteMaximale;
	}
	public void setConsomation(int consomation) {
		this.consomation = consomation;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNiveauKerosene(int niveauKerosene) {
		this.niveauKerosene = niveauKerosene;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setVitess(int vitess) {
		this.vitess = vitess;
	}
	public void setVitessMaximale(int vitessMaximale) {
		this.vitessMaximale = vitessMaximale;
	}

	  public Aeroport getAeroport() { return aeroport; }

}
