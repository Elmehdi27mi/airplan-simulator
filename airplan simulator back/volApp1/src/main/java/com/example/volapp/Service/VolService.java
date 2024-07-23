package com.example.volapp.Service;

import com.example.volapp.Entity.Aeroport;
import com.example.volapp.Entity.Vol;

import java.util.List;
import java.util.Optional;

public interface VolService {
    Optional<Vol> getVol(int id);
    List<Vol> getListVols();
    public void save(Vol vol);
}
