package com.example.volapp.Repository;

import com.example.volapp.Entity.Trajectoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajectoireRepository extends JpaRepository<Trajectoire,Integer> {
}
