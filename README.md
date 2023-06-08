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

> Pour acceder la documentation swagger

* http://localhost:8080/swagger-ui/

* http://localhost:8080/v2/api-docs

#### Il ne reste qu'à Lancer le serveur et voilà !!!