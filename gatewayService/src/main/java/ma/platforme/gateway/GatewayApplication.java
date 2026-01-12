package ma.platforme.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

/**
 * Application principale pour le service gateway.
 * Cette application agit comme point d'entrée unique pour tous les services
 * et gère le routage dynamique basé sur la découverte de services Consul.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * Configure le localisateur de routes dynamique pour le gateway.
     * Permet la découverte automatique des services via Consul.
     * @param reactiveDiscoveryClient Le client de découverte réactif
     * @param discoveryLocatorProperties Les propriétés de configuration du localisateur
     * @return Le localisateur de routes configuré
     */
    @Bean
    DiscoveryClientRouteDefinitionLocator configurerRoutesDynamiques(
            ReactiveDiscoveryClient reactiveDiscoveryClient,
            DiscoveryLocatorProperties discoveryLocatorProperties) {
        return new DiscoveryClientRouteDefinitionLocator(
            reactiveDiscoveryClient, 
            discoveryLocatorProperties
        );
    }
}


