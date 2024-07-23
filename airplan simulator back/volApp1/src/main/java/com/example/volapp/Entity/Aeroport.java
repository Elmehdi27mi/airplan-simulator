package com.example.volapp.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="aeroport")
public class Aeroport {

	@Id
	private int id_Aeroport;
	@Column
	private String nom;
	@Column
	private int nombrePiste;
	@Column
	private int attenteSol;
	@Column
	private int accesPiste;
	@Column
	private int delaiAnticollision;
	@Column
	private int boucleAttente;

	@OneToOne
    @JoinColumn
	private Coordonnee localisation;

	@JsonManagedReference
    @OneToMany(mappedBy = "aeroport", cascade = CascadeType.ALL)
    private List<Avion> avions;

	public Aeroport() {
		// TODO Auto-generated constructor stub
	}
	public int getAccesPiste() {
		return accesPiste;
	}
	public int getAttenteSol() {
		return attenteSol;
	}
	public int getBoucleAttente() {
		return boucleAttente;
	}
	public int getDelaiAnticollision() {
		return delaiAnticollision;
	}
	public int getId_Aeroport() {
		return id_Aeroport;
	}


	  public Coordonnee getLocalisation() { return localisation; }

	public String getNom() {
		return nom;
	}
	public int getNombrePiste() {
		return nombrePiste;
	}
	public void setAccesPiste(int accesPiste) {
		this.accesPiste = accesPiste;
	}
	public void setAttenteSol(int attenteSol) {
		this.attenteSol = attenteSol;
	}
	public void setBoucleAttente(int boucleAttente) {
		this.boucleAttente = boucleAttente;
	}
	public void setDelaiAnticollision(int delaiAnticollision) {
		this.delaiAnticollision = delaiAnticollision;
	}


	  public void setLocalisation(Coordonnee localisation) { this.localisation =
	  localisation; }

	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setNombrePiste(int nombrePiste) {
		this.nombrePiste = nombrePiste;
	}

	  public List<Avion> getAvions() { return avions; }



}
