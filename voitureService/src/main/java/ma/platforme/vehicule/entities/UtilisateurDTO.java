package ma.platforme.vehicule.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO représentant un utilisateur pour les communications inter-services.
 * Cette classe est utilisée pour transférer les données utilisateur depuis le service utilisateur.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDTO {
    private Long id;
    private String nom;
    private Integer age;
}
