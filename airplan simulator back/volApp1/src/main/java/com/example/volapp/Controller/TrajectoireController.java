package com.example.volapp.Controller;

import com.example.volapp.Entity.Trajectoire;
import com.example.volapp.Service.TrajectoireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trajectoires")
@CrossOrigin("http://localhost:3000/")
public class TrajectoireController {
    @Autowired
    private TrajectoireServiceImpl trajetServImpl;

    @GetMapping("/trajectoire/{id}")
    public Optional<Trajectoire> getTrajectoireById(@PathVariable int id)
    {
        return trajetServImpl.getTrajectoire(id);
    }
    @GetMapping("/listtrajectoires")
    public List<Trajectoire> getTrajectoires()
    {
        return trajetServImpl.getListTrajectoirs();
    }

}
