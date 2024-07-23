package com.example.volapp.dijikstra;

import com.example.volapp.Entity.Aeroport;
import com.example.volapp.Entity.Avion;
import com.example.volapp.Entity.Trajectoire;
import com.example.volapp.Entity.Vol;
import com.example.volapp.Service.TrajectoireServiceImpl;
import com.example.volapp.Service.VolserviceImpl;
import java.util.*;

public class djks {
   private VolserviceImpl volService ;
    private TrajectoireServiceImpl trajectoireService;

    public djks(VolserviceImpl volService, TrajectoireServiceImpl trajectoireService) {
        this.volService = volService;
        this.trajectoireService = trajectoireService;
    }

    public void calculeTrajectoires(Aeroport aeroportDepart , Aeroport aeroportArrivee, Avion avion, List<Aeroport> aeropots){

            Vol vol=new Vol();
            vol.setAeroportDepart(aeroportDepart);
            vol.setAeroportArrivet(aeroportArrivee);
            vol.setAvion(avion);
            //vol.setDateDepart(new Date());

            Map<Integer, String> nodeNames = new HashMap<>();
            for(int i=0;i<aeropots.size();i++){
                nodeNames.put(i, aeropots.get(i).getNom());
            }

            Djikstra dijkstraAlgorithm = new Djikstra(aeropots.size());
            MatriceAeroport ma = new MatriceAeroport(aeroportDepart, aeroportArrivee);
            int key1 = getKeyByValue(nodeNames, aeroportDepart.getNom());
            int key2 = getKeyByValue(nodeNames, aeroportArrivee.getNom());
            List<List<Double>> distances = ma.distanceInterAeroport(aeropots);
            List<Integer> predecessors = dijkstraAlgorithm.dijkstra(distances, key1);
            List<String> shortestPath = dijkstraAlgorithm.getShortestPath(predecessors, key2, nodeNames);


            Chemin chemin = new Chemin();
            List<Trajectoire>trajectoires=new ArrayList<>();
           trajectoires = chemin.ListTrajectoires(aeroportDepart,aeroportArrivee, aeropots, key1, nodeNames, shortestPath);

            for (int index = 0; index < trajectoires.size(); index++) {
                this.trajectoireService.save(trajectoires.get(index));
            }
            vol.setTrajectoires(trajectoires);

            this.volService.save(vol);


        }

private  int getKeyByValue(Map<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
        if (entry.getValue().equals(value)) {
        return entry.getKey();
        }
        }
        return -1; // Retourne -1 si la valeur n'est pas trouvée dans la map
        }

        }
























