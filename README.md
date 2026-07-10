# eureka-registry-naming-server

Ce microservice est le **Serveur d'Enregistrement et de Découverte Eureka** (Spring Cloud Netflix Eureka). Il agit comme un annuaire dynamique pour l'ensemble de l'écosystème de microservices.

## ⚙️ Rôle et Fonctionnalités

- **Annuaire de Services** : Chaque fois qu'un microservice (ex: `user-service`, `wallet-service`) démarre, il s'enregistre auprès d'Eureka avec son nom applicatif, son IP et son port.
- **Découverte Dynamique** : Les microservices et l'API Gateway interrogent Eureka pour obtenir la liste des instances actives et leurs adresses de façon à effectuer du routage et de l'équilibrage de charge (`Load Balancing`) sans avoir d'adresses codées en dur.
- **Healthcheck / Heartbeat** : Envoi périodique de signaux de vie. Si un service s'arrête anormalement, Eureka le retire de l'annuaire au bout d'un certain délai.

---

## 🔌 Configuration du Service

- **Port par défaut** : `8761`
- **Technologie** : Spring Cloud Netflix Eureka Server
- **Dashboard Eureka** : [http://localhost:8761](http://localhost:8761)

---

## 🚀 Démarrage

### Mode Local
Lancez le service avec Maven :
```bash
mvn spring-boot:run
```

### Mode Docker
Ce service est lancé automatiquement par le Docker Compose global du backend. Il dépend de la bonne santé du `config-server`.

---

## 🖥️ Tableau de Bord Eureka

Une fois le serveur démarré, vous pouvez y accéder dans votre navigateur à l'adresse suivante : [http://localhost:8761](http://localhost:8761).
L'interface vous présentera :
- La liste de toutes les instances applicatives actuellement enregistrées (ex: `authentication-service`, `spring-cloud-gateway`, etc.).
- L'état de santé de chaque instance (UP/DOWN).
- Des informations système sur l'hôte hébergeant le serveur Eureka.
