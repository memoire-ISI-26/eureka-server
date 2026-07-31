package com.financedomain.eureka;

import com.netflix.eureka.EurekaServerContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = {
        "eureka.client.register-with-eureka=false",
        "eureka.client.fetch-registry=false",
        "spring.cloud.config.enabled=false",
        "eureka-registry-naming-server.uriport=8761",
        "eureka-registry-naming-server.fetchregistry=false"
})
class EurekaRegistryNamingServerApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired(required = false)
    private EurekaServerContext eurekaServerContext;

    @Test
    @DisplayName("Vérifie le chargement du contexte Spring Boot et l'initialisation du serveur Eureka")
    void contextLoads() {
        assertNotNull(applicationContext, "Le contexte Spring ne doit pas être nul.");
        assertThat(eurekaServerContext).isNotNull();
    }
}
