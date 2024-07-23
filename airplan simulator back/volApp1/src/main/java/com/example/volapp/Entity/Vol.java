package com.example.volapp.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Aeroport aeroportDepart ;


    @ManyToOne
    private Aeroport aeroportArrivet;

    @Column
    private Date dateDepart ;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    private Avion avion;

    @OneToMany(cascade = CascadeType.ALL)

    private List<Trajectoire> trajectoires;
    public Vol() {
    }

    public List<Trajectoire> getTrajectoires() {
        return trajectoires;
    }

    public void setTrajectoires(List<Trajectoire> trajectoires) {
        this.trajectoires = trajectoires;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Vol(Aeroport aeroportDepart, Aeroport aeroportArrivet, Date dateDepart) {
        this.aeroportDepart = aeroportDepart;
        this.aeroportArrivet = aeroportArrivet;
        this.dateDepart = dateDepart;
    }
    public void addTrajectoire(Trajectoire trajectoire){
        if (trajectoires==null){
            trajectoires=new ArrayList<>();
        }
        trajectoires.add(trajectoire);
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

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
