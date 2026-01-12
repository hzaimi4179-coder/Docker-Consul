package ma.platforme.utilisateur.services;

import ma.platforme.utilisateur.entities.Utilisateur;
import ma.platforme.utilisateur.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service métier pour la gestion des utilisateurs.
 * Gère les opérations CRUD sur les utilisateurs.
 */
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    /**
     * Récupère tous les utilisateurs de la base de données.
     * @return Liste complète de tous les utilisateurs
     */
    public List<Utilisateur> recupererTousLesUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    /**
     * Récupère un utilisateur par son identifiant.
     * @param id L'identifiant unique de l'utilisateur
     * @return L'utilisateur correspondant à l'identifiant
     * @throws Exception Si l'utilisateur n'est pas trouvé
     */
    public Utilisateur recupererParId(Long id) throws Exception {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new Exception("Identifiant utilisateur invalide"));
    }

    /**
     * Ajoute un nouvel utilisateur à la base de données.
     * @param utilisateur L'utilisateur à ajouter
     */
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }
}


