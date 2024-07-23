package com.example.volapp.Repository;

import com.example.volapp.Entity.Coordonnee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoordonnerRepository extends JpaRepository<Coordonnee,Integer>{

}
