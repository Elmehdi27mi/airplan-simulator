package com.example.volapp.Repository;


import com.example.volapp.Entity.Aeroport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeroportRepository extends JpaRepository<Aeroport, Integer> {

}
