package com.example.volapp.Service;

import com.example.volapp.Entity.Aeroport;
import com.example.volapp.Entity.Avion;

import java.util.List;
import java.util.Optional;

public interface AvionService {
    Optional<Avion> getAvion(int id);
    List<Avion> getListAvion();
    public void save(Avion avion);


}
