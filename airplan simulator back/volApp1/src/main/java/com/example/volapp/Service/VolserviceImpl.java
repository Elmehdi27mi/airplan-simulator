package com.example.volapp.Service;

import com.example.volapp.Entity.Vol;
import com.example.volapp.Repository.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VolserviceImpl implements VolService{

    @Autowired
    private VolRepository vol;
    public Optional<Vol> getVol(int id) {
        return vol.findById(id);
    }

    @Override
    public List<Vol> getListVols() {
        return vol.findAll();
    }

    @Override
    public void save(Vol v) {
        vol.save(v);
    }
}
