package ma.platforme.vehicule.repositories;

import ma.platforme.vehicule.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour l'accès aux données des véhicules.
 * Fournit les opérations CRUD de base via JPA.
 */
@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
