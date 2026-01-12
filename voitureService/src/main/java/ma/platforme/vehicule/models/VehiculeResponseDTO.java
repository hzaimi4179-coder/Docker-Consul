package ma.platforme.vehicule.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.platforme.vehicule.entities.UtilisateurDTO;

/**
 * DTO de réponse pour les informations complètes d'un véhicule.
 * Inclut les détails du véhicule ainsi que les informations de l'utilisateur associé.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculeResponseDTO {
    private Long id;
    private String marque;
    private String modele;
    private String immatriculation;
    private UtilisateurDTO utilisateur;
}
