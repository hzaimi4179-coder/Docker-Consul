package ma.platforme.vehicule.controllers;

import ma.platforme.vehicule.models.VehiculeResponseDTO;
import ma.platforme.vehicule.services.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des véhicules.
 * Expose les endpoints pour la récupération des informations véhicules.
 */
@RestController
@RequestMapping("/api/vehicule")
public class VehiculeController {
    
    @Autowired
    private VehiculeService vehiculeService;

    /**
     * Récupère la liste complète de tous les véhicules.
     * @return Liste de tous les véhicules avec leurs informations utilisateur
     */
    @GetMapping
    public List<VehiculeResponseDTO> obtenirTousLesVehicules() {
        return vehiculeService.recupererTousLesVehicules();
    }

    /**
     * Récupère un véhicule spécifique par son identifiant.
     * @param id L'identifiant unique du véhicule
     * @return Les informations complètes du véhicule
     * @throws Exception Si le véhicule n'existe pas
     */
    @GetMapping("/{id}")
    public VehiculeResponseDTO obtenirVehiculeParId(@PathVariable Long id) throws Exception {
        return vehiculeService.recupererParId(id);
    }
}
