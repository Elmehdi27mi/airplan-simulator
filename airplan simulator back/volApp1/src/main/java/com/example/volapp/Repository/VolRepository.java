package com.example.volapp.Repository;

import com.example.volapp.Entity.Vol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolRepository extends JpaRepository<Vol,Integer> {
}
