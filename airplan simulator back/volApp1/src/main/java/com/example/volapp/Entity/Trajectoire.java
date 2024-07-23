package com.example.volapp.Entity;

import jakarta.persistence.*;



@Entity
@Table
public class Trajectoire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTra;

    @ManyToOne
    private Aeroport aeroportDepart ;

    @ManyToOne
    private Aeroport aeroportArrivet;
    @Column
    private Integer flot;
    @Column
    private double distance;

    public Trajectoire( Aeroport aeroportDepart, Aeroport aeroportArrivet, Integer flot, double distance) {

        this.aeroportDepart = aeroportDepart;
        this.aeroportArrivet = aeroportArrivet;
        this.flot = flot;
        this.distance = distance;
    }

    public Trajectoire() {
    }

    public int getIdTra() {
        return idTra;
    }

    public void setIdTra(int idTra) {
        this.idTra = idTra;
    }

    public Aeroport getAeroportDepart() {
        return aeroportDepart;
    }

    public void setAeroportDepart(Aeroport aeroportDepart) {
        this.aeroportDepart = aeroportDepart;
    }

    public Aeroport getAeroportArrivet() {
        return aeroportArrivet;
    }

    public void setAeroportArrivet(Aeroport aeroportArrivet) {
        this.aeroportArrivet = aeroportArrivet;
    }

    public Integer getFlot() {
        return flot;
    }

    public void setFlot(Integer flot) {
        this.flot = flot;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}

