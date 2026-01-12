package ma.platforme.utilisateur;

import ma.platforme.utilisateur.entities.Utilisateur;
import ma.platforme.utilisateur.repositories.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Application principale pour le service de gestion des utilisateurs.
 * Cette application permet de gérer les informations relatives aux utilisateurs du système.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UtilisateurApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilisateurApplication.class, args);
    }

    /**
     * Initialise la base de données avec des données de test au démarrage.
     * @param utilisateurRepository Le repository pour accéder aux données utilisateur
     * @return CommandLineRunner pour exécuter l'initialisation
     */
    @Bean
    CommandLineRunner initialiserBaseDeDonnees(UtilisateurRepository utilisateurRepository) {
        return args -> {
            utilisateurRepository.save(new Utilisateur(Long.parseLong("1"), "Abla", Float.parseFloat("23")));
            utilisateurRepository.save(new Utilisateur(Long.parseLong("2"), "Kaoutar", Float.parseFloat("23")));
            utilisateurRepository.save(new Utilisateur(Long.parseLong("3"), "Hameza", Float.parseFloat("22")));
        };
    }
}


