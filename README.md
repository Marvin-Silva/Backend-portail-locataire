># Portail-Locataire API

Pour utiliser l'application il faut d'abord respecter quelques pré-requis

## Installer
* Java 11 ou 17
* IDE tels que Intellij ou Eclipse
* Git
* MySQL

## Lancer le projet
* Cloner le projet
* Uploader le dump sql dans workbench present à la racine du projet

Renseigner l'application properties

>Configuration Standard
* spring.datasource.url=jdbc:mysql://localhost:3306/rentals ....

> Ajouter l'environnement de variable
* ${MYSQL_PWD}

> Ajouter les clés pour chiffrer le token
* rsa.privateKey=classpath:certs/private
* rsa.publicKey=classpath:certs/public.pub

### Dependencies

>Spring Web

* spring-boot-starter-web

>Security

* spring-boot-starter-oauth2-resource-server
* spring-boot-starter-security

>Base de données

* spring-boot-starter-data-jpa
* mysql-connector-j

>Utility
* org.projectlombok

>Swagger

* springfox-boot-starter
* springfox-swagger-ui

>Token

* jjwt-api
* jjwt-impl
* jjwt-jackson
### Routes

> Auth-Controller
    
* POST: /api/auth/login - Login application for users
* GET: 	/api/auth/me - Get information from authenticated user
* POST: /api/auth/register - Create a user account

> Rental-Controller

* GET: /api/rentals - Get rentals registered
* POST: /api/rentals - Build a new rentals
* GET: /api/rentals/{id} - Specify the rentals to get
* PUT: /api/rentals/{id} - Update rentals information

> User-Controller

* POST: /api/messages - Send messages to rentals owner
* GET: /api/user/{id} - Specify user to get

### Swagger
> Pour acceder la documentation swagger

* http://localhost:8080/swagger-ui/

* http://localhost:8080/v2/api-docs

#### Il ne reste qu'à Lancer le serveur et voilà !!!