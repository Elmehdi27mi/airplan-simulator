package com.example.volapp.Service;

import com.example.volapp.Entity.Trajectoire;
import com.example.volapp.Repository.TrajectoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TrajectoireServiceImpl implements TrajectoireService{
   @Autowired
   private TrajectoireRepository trajet;
    public Optional<Trajectoire> getTrajectoire(int id) {
        return trajet.findById(id);
    }

    @Override
    public List<Trajectoire> getListTrajectoirs() {
        return trajet.findAll();
    }

    @Override
    public void save(Trajectoire trajectoire) {
        trajet.save(trajectoire);

    }
}
