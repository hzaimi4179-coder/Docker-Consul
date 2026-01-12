package ma.platforme.utilisateur.repositories;

import ma.platforme.utilisateur.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour l'accès aux données des utilisateurs.
 * Fournit les opérations CRUD de base via JPA.
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}


