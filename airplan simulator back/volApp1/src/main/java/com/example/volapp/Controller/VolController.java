package com.example.volapp.Controller;

import com.example.volapp.Entity.Aeroport;
import com.example.volapp.Entity.Avion;
import com.example.volapp.Entity.Trajectoire;
import com.example.volapp.Entity.Vol;
import com.example.volapp.Service.AeroportServiceIml;
import com.example.volapp.Service.TrajectoireServiceImpl;
import com.example.volapp.Service.VolserviceImpl;
import com.example.volapp.dijikstra.djks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vols")
@CrossOrigin("http://localhost:3000/")
public class VolController {
    @Autowired
    private VolserviceImpl volServImpl;

    @Autowired
    private AeroportServiceIml aeroportServiceIml ;
    @Autowired
    private TrajectoireServiceImpl trajectoireService;



    @GetMapping("/vol/{id}")
    public Optional<Vol> getVolById(@PathVariable int id)
    {
        return volServImpl.getVol(id);
    }
    @GetMapping("/listvol")
    public List<Vol> getVols()
    {
        return volServImpl.getListVols();
    }

    @PostMapping("/vol")
    public void addVol(@RequestBody Vol vol){
        vol.addTrajectoire(new Trajectoire(vol.getAeroportDepart(),vol.getAeroportArrivet(),2,2));

        List<Aeroport> aeroports=aeroportServiceIml.getListAeroport();
        djks d=new djks( volServImpl,  trajectoireService);
        d.calculeTrajectoires(vol.getAeroportDepart(),vol.getAeroportArrivet(),vol.getAvion(),aeroports);
    }
}
