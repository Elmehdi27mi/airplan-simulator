package com.example.volapp.dijikstra;
import com.example.volapp.Entity.Aeroport;
import com.example.volapp.Entity.Trajectoire;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class Chemin {
    public
    List<Trajectoire> ListTrajectoires(Aeroport aeroprtDepart , Aeroport aeroprtArrivee , List<Aeroport> aeroports, int src, Map<Integer, String> nodeNames, List<String> shortestPath){
        List<Trajectoire> trajectoires =new ArrayList<>();


        if (shortestPath.size() >= 2) {
            for (int i = 0; i < shortestPath.size() - 1; i++) {
                String aeroportDepartNom = shortestPath.get(i);
                String aeroportArriveeNom = shortestPath.get(i + 1);

                // Recherche des aéroports correspondants dans la liste aeroports
                Aeroport aeroportDepart = trouverAeroportParNom(aeroportDepartNom, aeroports);
                Aeroport aeroportArrivee = trouverAeroportParNom(aeroportArriveeNom, aeroports);

                // Vérifiez si les aéroports ont été trouvés
                if (aeroportDepart != null && aeroportArrivee != null) {
                    // Créer une nouvelle trajectoire
                    Trajectoire trajectoire = new Trajectoire();
                    trajectoire.setAeroportDepart(aeroportDepart);
                    trajectoire.setAeroportArrivet(aeroportArrivee);
                    trajectoire.setFlot(3);
                    double distance=Math.sqrt(Math.pow(aeroportDepart.getLocalisation().getX() - aeroportArrivee.getLocalisation().getX(), 2) +
                            Math.pow(aeroportDepart.getLocalisation().getY() - aeroportArrivee.getLocalisation().getY(), 2));

                    trajectoire.setDistance(distance);


                    // Ajouter la trajectoire à la liste
                    trajectoires.add(trajectoire);
                }
            }
        }

        return trajectoires;
    }
    // Fonction utilitaire pour trouver un aéroport par son nom
    private Aeroport trouverAeroportParNom(String nom, List<Aeroport> aeroports) {
        for (Aeroport aeroport : aeroports) {
            if (aeroport.getNom().equals(nom)) {
                return aeroport;
            }
        }
        return null; // Retourne null si l'aéroport n'est pas trouvé
    }
}
