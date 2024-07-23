package com.example.volapp.Controller;

import com.example.volapp.Entity.Aeroport;
import com.example.volapp.Service.AeroportServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/aeroports")
@CrossOrigin("http://localhost:3000/")
public class AeroportController {
	@Autowired
	private AeroportServiceIml aServImpl;
	
	@GetMapping("/aeroport/{id}")
	public Optional<Aeroport> getAeroportById(@PathVariable int id)
	{
		return aServImpl.getAeroport(id);
	}
	@GetMapping("/listaeroport")
	public List<Aeroport> getAeroports()
	{
		return aServImpl.getListAeroport();
	}

}
