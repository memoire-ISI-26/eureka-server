package com.financedomain.eureka;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
        "eureka.client.register-with-eureka=false",
        "eureka.client.fetch-registry=false",
        "spring.cloud.config.enabled=false",
        "eureka-registry-naming-server.uriport=8761",
        "eureka-registry-naming-server.fetchregistry=false"
})
class EurekaServerConfigTest {

    @Autowired
    private Environment environment;

    @Value("${spring.application.name}")
    private String applicationName;

    @Test
    @DisplayName("Devrait charger le nom correct de l'application Eureka Server")
    void shouldHaveCorrectApplicationName() {
        assertEquals("eureka-registry-naming-server", applicationName);
    }

    @Test
    @DisplayName("Devrait vérifier la désactivation du registre Eureka en mode standalone de test")
    void shouldDisableRegisterWithEurekaInTest() {
        String registerWithEureka = environment.getProperty("eureka.client.register-with-eureka");
        assertEquals("false", registerWithEureka);
    }
}
