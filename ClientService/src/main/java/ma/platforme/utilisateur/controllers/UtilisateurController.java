package ma.platforme.utilisateur.controllers;

import ma.platforme.utilisateur.entities.Utilisateur;
import ma.platforme.utilisateur.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des utilisateurs.
 * Expose les endpoints pour les opérations CRUD sur les utilisateurs.
 */
@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {
    
    @Autowired
    private UtilisateurService utilisateurService;

    /**
     * Récupère la liste complète de tous les utilisateurs.
     * @return Liste de tous les utilisateurs
     */
    @GetMapping
    public List<Utilisateur> obtenirTousLesUtilisateurs() {
        return utilisateurService.recupererTousLesUtilisateurs();
    }

    /**
     * Récupère un utilisateur spécifique par son identifiant.
     * @param id L'identifiant unique de l'utilisateur
     * @return Les informations de l'utilisateur
     * @throws Exception Si l'utilisateur n'existe pas
     */
    @GetMapping("/{id}")
    public Utilisateur obtenirUtilisateurParId(@PathVariable Long id) throws Exception {
        return utilisateurService.recupererParId(id);
    }

    /**
     * Crée un nouvel utilisateur dans le système.
     * @param utilisateur Les informations de l'utilisateur à créer
     */
    @PostMapping
    public void creerUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.ajouterUtilisateur(utilisateur);
    }
}


