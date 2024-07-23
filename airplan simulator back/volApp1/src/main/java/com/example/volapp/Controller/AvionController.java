package com.example.volapp.Controller;

import com.example.volapp.Entity.Aeroport;
import com.example.volapp.Entity.Avion;
import com.example.volapp.Service.AeroportServiceIml;
import com.example.volapp.Service.AvionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/avions")
@CrossOrigin("http://localhost:3000/")
public class AvionController {
    @Autowired
    private AvionServiceImpl avionServImpl;

    @GetMapping("/avion/{id}")
    public Optional<Avion> getAvionById(@PathVariable int id)
    {
        return avionServImpl.getAvion(id);
    }
    @GetMapping("/listavions")
    public List<Avion> getAvions()
    {
        return avionServImpl.getListAvion();
    }

}
