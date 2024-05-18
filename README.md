<h1>Compte rendu du backend de Ebanking</h1>

<h3>Introduction :</h3>
<p>Ce travail est une mise en place d'un projet de banque électronique où le client, son compte courant et épargne, ainsi que l'historique de ses opérations, sont gérés en utilisant JEE Spring Boot avec une architecture MVC. La partie backend comprend les Entités, les Répertoires, les DTOs, les Mappers, les Services et les RestControllers.

On souhaite créer une application qui permet de gérer des comptes bancaires. Chaque compte appartient à un client. Un compte peut subir plusieurs opérations de type DEBIT ou CREDIT. Il existe deux types de comptes : comptes courants et comptes épargne.</p>


<h3>Single Table  </h3>
<p>Dans la stratégie Single Table, toutes les classes de la hiérarchie d'héritage sont mappées sur une seule table. Une colonne discriminante (discriminator column) est utilisée pour distinguer les différentes sous-classes. Cette colonne contient un identifiant unique pour chaque type d'entité, ce qui permet de savoir à quelle sous-classe appartient chaque ligne de la table.</p>
<img src="./captures/img.png">

<h3>Liste des operations </h3>
<p>Client et Compte : Un client peut avoir plusieurs comptes, d'où la relation @OneToMany entre Client et Compte.
Compte et Operation : Un compte peut avoir plusieurs opérations, d'où la relation @OneToMany entre Compte et Operation.</p>
<img src="./captures/img_1.png">


<h3>Test des fonctionnalites BY Postman </h3>
<h4>Get customers </h4>
<img src="./captures/img_2.png">

<h4>Get customers by Id </h4>
<img src="./captures/img_3.png">

<h4>Get accounts </h4>
<img src="./captures/img_4.png">

<h4>Get accounts By Id  </h4>
<img src="./captures/img_5.png">

<h4>Ajouter Un debit </h4>
<img src="./captures/img_6.png">

<h4>En résumé, cette approche permet de :

Centraliser la gestion des entités : En utilisant une seule table pour les différents types de comptes, nous facilitons la gestion et les modifications futures.
<br>
Assurer la cohérence des données : Les relations entre les entités garantissent que chaque opération est correctement associée à un compte et, par extension, à un client.<br>
Optimiser les performances : La stratégie Single Table permet des opérations de requêtes rapides et efficaces, en évitant les jointures complexes entre plusieurs tables.
<br>
Simplifier le développement : Avec Spring Boot et JPA, le code reste lisible et maintenable, tout en permettant de tirer parti des puissantes fonctionnalités offertes par ces frameworks.</h4>
