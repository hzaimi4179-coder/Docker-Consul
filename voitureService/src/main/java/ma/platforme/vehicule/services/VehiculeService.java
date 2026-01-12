package ma.platforme.vehicule.services;

import ma.platforme.vehicule.entities.Vehicule;
import ma.platforme.vehicule.entities.UtilisateurDTO;
import ma.platforme.vehicule.models.VehiculeResponseDTO;
import ma.platforme.vehicule.repositories.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service métier pour la gestion des véhicules.
 * Gère les opérations CRUD et la récupération des données utilisateur associées.
 */
@Service
public class VehiculeService {
    
    @Autowired
    private VehiculeRepository vehiculeRepository;
    
    @Autowired
    private RestTemplate clientREST;
    
    @Value("${services.utilisateur.url:http://localhost:8888/SERVICE-UTILISATEUR}")
    private String urlServiceUtilisateur;

    /**
     * Récupère tous les véhicules avec les informations de leurs utilisateurs associés.
     * @return Liste de tous les véhicules avec leurs utilisateurs
     */
    public List<VehiculeResponseDTO> recupererTousLesVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        ResponseEntity<UtilisateurDTO[]> reponse = clientREST.getForEntity(
            urlServiceUtilisateur + "/api/utilisateur", 
            UtilisateurDTO[].class
        );
        UtilisateurDTO[] utilisateurs = reponse.getBody();
        return vehicules.stream()
                .map(vehicule -> convertirEnDTO(vehicule, utilisateurs))
                .collect(Collectors.toList());
    }

    /**
     * Convertit une entité Véhicule en DTO avec les informations utilisateur.
     * @param vehicule L'entité véhicule à convertir
     * @param utilisateurs Tableau des utilisateurs disponibles
     * @return Le DTO de réponse avec les informations complètes
     */
    private VehiculeResponseDTO convertirEnDTO(Vehicule vehicule, UtilisateurDTO[] utilisateurs) {
        UtilisateurDTO utilisateurTrouve = Arrays.stream(utilisateurs)
                .filter(utilisateur -> utilisateur.getId().equals(vehicule.getIdUtilisateur()))
                .findFirst()
                .orElse(null);

        return VehiculeResponseDTO.builder()
                .id(vehicule.getId())
                .marque(vehicule.getMarque())
                .modele(vehicule.getModele())
                .immatriculation(vehicule.getImmatriculation())
                .utilisateur(utilisateurTrouve)
                .build();
    }

    /**
     * Récupère un véhicule par son identifiant avec les informations de l'utilisateur associé.
     * @param id L'identifiant du véhicule
     * @return Le DTO du véhicule avec ses informations utilisateur
     * @throws Exception Si le véhicule n'est pas trouvé
     */
    public VehiculeResponseDTO recupererParId(Long id) throws Exception {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new Exception("Identifiant véhicule invalide"));
        
        UtilisateurDTO utilisateur = clientREST.getForObject(
            urlServiceUtilisateur + "/api/utilisateur/" + vehicule.getIdUtilisateur(), 
            UtilisateurDTO.class
        );
        
        return VehiculeResponseDTO.builder()
                .id(vehicule.getId())
                .marque(vehicule.getMarque())
                .modele(vehicule.getModele())
                .immatriculation(vehicule.getImmatriculation())
                .utilisateur(utilisateur)
                .build();
    }
}
