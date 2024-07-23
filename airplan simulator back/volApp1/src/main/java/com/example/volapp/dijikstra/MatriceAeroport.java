package com.example.volapp.dijikstra;

import com.example.volapp.Entity.Aeroport;

import java.util.ArrayList;
import java.util.List;

public class MatriceAeroport {
    private Aeroport aeroportdepart;
    private Aeroport aeroportarrivee;

    public MatriceAeroport(Aeroport aeroportdepart, Aeroport aeroportarrivee) {
        super();
        this.aeroportdepart = aeroportdepart;
        this.aeroportarrivee = aeroportarrivee;
    }

    public Aeroport getAeroportdepart() {
        return aeroportdepart;
    }

    public void setAeroportdepart(Aeroport aeroportdepart) {
        this.aeroportdepart = aeroportdepart;
    }

    public Aeroport getAeroportarrivee() {
        return aeroportarrivee;
    }

    public void setAeroportarrivee(Aeroport aeroportarrivee) {
        this.aeroportarrivee = aeroportarrivee;
    }

    public List<List<Double>> distanceInterAeroport(List<Aeroport> aeroports) {
        List<List<Double>> distances = new ArrayList<>();
        Double distance;

        for (int i = 0; i < aeroports.size(); i++) {
            List<Double> distanceInterAeroport = new ArrayList<>();

            for (int j = 0; j < aeroports.size(); j++) {
                distance = Math.sqrt(Math.pow(aeroports.get(i).getLocalisation().getX() - aeroports.get(j).getLocalisation().getX(), 2) +
                        Math.pow(aeroports.get(i).getLocalisation().getY() - aeroports.get(j).getLocalisation().getY(), 2));
                if(distance>Math.sqrt(Math.pow(aeroportdepart.getLocalisation().getX()-aeroportarrivee.getLocalisation().getX(), 2)+
                        Math.pow(aeroportdepart.getLocalisation().getY()-aeroportarrivee.getLocalisation().getY(), 2)	)) {
                    distance=distance*0;
                }
                if((aeroports.get(i).getId_Aeroport()==aeroportdepart.getId_Aeroport())&&(aeroports.get(j).getId_Aeroport()==aeroportarrivee.getId_Aeroport())) {
                    distance=distance*12220;
                }

                distanceInterAeroport.add(distance);
            }
            distances.add(distanceInterAeroport);
        }
        return distances;
    }



}
