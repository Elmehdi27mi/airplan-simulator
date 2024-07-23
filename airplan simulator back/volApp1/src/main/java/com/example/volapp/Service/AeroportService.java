package com.example.volapp.Service;


import com.example.volapp.Entity.Aeroport;

import java.util.List;
import java.util.Optional;

public interface AeroportService {
	
	Optional<Aeroport> getAeroport(int id);
	List<Aeroport> getListAeroport();
	public void save(Aeroport aeroport);

}
