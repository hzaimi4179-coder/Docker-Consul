package ma.platforme.vehicule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Application principale pour le service de gestion des véhicules.
 * Cette application permet de gérer les informations relatives aux véhicules
 * et de les associer aux utilisateurs du système.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class VehiculeApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehiculeApplication.class, args);
    }

    /**
     * Configuration du client REST pour les communications inter-services.
     * Configure les timeouts pour éviter les blocages lors des appels distants.
     */
    @Bean
    public RestTemplate configurerClientREST() {
        RestTemplate clientREST = new RestTemplate();
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);
        clientREST.setRequestFactory(factory);
        return clientREST;
    }
}
