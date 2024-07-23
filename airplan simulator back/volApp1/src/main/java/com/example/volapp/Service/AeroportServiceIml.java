package com.example.volapp.Service;

import java.util.List;
import java.util.Optional;

import com.example.volapp.Entity.Aeroport;
import com.example.volapp.Repository.AeroportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AeroportServiceIml implements AeroportService{

	@Autowired
	private AeroportRepository aRepo;

	
	@Override
	public Optional<Aeroport> getAeroport(int id) {
		return aRepo.findById(id);
	}

	@Override
	public List<Aeroport> getListAeroport() {
		// TODO Auto-generated method stub
		return aRepo.findAll();
	}
	@Override
	public void save(Aeroport aeroport){
		aRepo.save(aeroport);
	}
}
