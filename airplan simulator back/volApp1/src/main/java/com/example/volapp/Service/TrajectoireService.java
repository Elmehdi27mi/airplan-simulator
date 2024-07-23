package com.example.volapp.Service;

import com.example.volapp.Entity.Aeroport;
import com.example.volapp.Entity.Trajectoire;

import java.util.List;
import java.util.Optional;

public interface TrajectoireService {
    Optional<Trajectoire> getTrajectoire(int id);
    List<Trajectoire> getListTrajectoirs();
    public void save(Trajectoire trajectoire);
}
