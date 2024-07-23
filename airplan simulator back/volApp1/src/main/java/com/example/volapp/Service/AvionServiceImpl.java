package com.example.volapp.Service;

import com.example.volapp.Entity.Aeroport;
import com.example.volapp.Entity.Avion;
import com.example.volapp.Repository.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AvionServiceImpl implements AvionService {

    @Autowired
    private AvionRepository avion;


    @Override
    public Optional<Avion> getAvion(int id) {
        return avion.findById(id);
    }

    @Override
    public List<Avion> getListAvion() {
        // TODO Auto-generated method stub
        return avion.findAll();
    }
    @Override
    public void save(Avion a){
        avion.save(a);
    }

}
