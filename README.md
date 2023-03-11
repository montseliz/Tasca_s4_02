# Tasca_s4_02
### Api Rest amb Spring boot

## Nivell 1

#### Exercici CRUD amb H2

Accedeix a la pàgina ->https://start.spring.io/, i genera un projecte Spring boot amb les següents característiques:

    PROJECT (gestor de dependències): Maven o Gradle. 

    LANGUAGE: Java.

    SPRING BOOT: La darrera versió estable.

    PROJECT METADATA:

    - Group: cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01

    - Artifact: S04T02N01CognomsNom

    - Name: S04T02N01CognomsNom

    - Description: S04T02N01CognomsNom

    - Package name: cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01

    PACKAGIN: Jar.

    JAVA: Mínim versió 11.

    DEPENDÈNCIES:

    - Spring Boot DevTools.

    - Spring Web.

    - Spring Data JPA. 

    - H2 Database.


Tenim una entitat anomenada "Fruita", que disposa de les següents propietats:

- int id
- String nom
- int quantitatQuilos

Aprofitant l’especificació JPA, hauràs de persistir aquesta entitat a una base de dades H2, seguint el patró MVC. Per a això, depenent del Package principal, crearàs una estructura de packages, on ubicaràs les classes que necessitis:

- cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.controllers
- cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.domain
- cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.services
- cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.repository

La classe ubicada al paquet controllers (FruitaController, per exemple), haurà de ser capaç de donar resposta a les següents peticions per actualitzar i consultar informació:

http://localhost:8080/fruita/add

http://localhost:8080/fruita/update

http://localhost:8080/fruita/delete/{id}

http://localhost:8080/fruita/getOne/{id}

http://localhost:8080/fruita/getAll

### Recursos utilitzats

- https://www.baeldung.com/spring-boot-h2-database
- https://www.bezkoder.com/spring-boot-jpa-h2-example/

    
## Nivell 2

#### Exercici CRUD amb MySQL

Accedeix a la pàgina ->https://start.spring.io/, i genera un projecte Spring boot amb les següents característiques:

    PROJECT (gestor de dependències): Maven o Gradle.

    LANGUAGE: Java.

    SPRING BOOT: La darrera versió estable.

    PROJECT METADATA:

    - Group: cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02

    - Artifact: S04T02N02CognomsNom

    - Name: S04T02N02CognomsNom

    - Description: S04T02N02CognomsNom

    - Package name: cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02

    PACKAGIN: Jar.

    JAVA: Mínim versió 11.

    DEPENDÈNCIES:

    - Spring Boot DevTools.

    - Spring Web.

    - Spring Data JPA.

    - MySQL Driver. 


Has de fer el mateix que al nivell 1, però persistint les dades a MySQL.

### Recursos utilitzats

- https://amoelcodigo.com/crud-java-sprig-mysql/
- https://javadesde0.com/crud-rest-con-spring-boot-y-jpa/


## Nivell 3

#### Exercici CRUD amb MongoDB

Accedeix a la pàgina ->https://start.spring.io/, genera un projecte Spring boot amb les següents característiques:

    PROJECT (gestor de dependències): Maven o Gradle.

    LANGUAGE: Java.

    SPRING BOOT: La darrera versió estable.

    PROJECT METADATA:

    - Group: cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03

    - Artifact: S04T02N03CognomsNom

    - Name: S04T02N03CognomsNom

    - Description: S04T02N03CognomsNom

    - Package name: cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03

    PACKAGIN: Jar.

    JAVA: Mínim versió 11.

    DEPENDÈNCIES:

    - Spring Boot DevTools.

    - Spring Web.

    - Spring Data JPA.

    - Spring Data MongoDB 

Has de fer el mateix que al nivell 1, però persistint les dades a MongoDB.

### Recursos utilitzats

- https://www.bezkoder.com/spring-boot-mongodb-crud/
- https://www.bezkoder.com/spring-boot-restcontrolleradvice/
