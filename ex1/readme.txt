exercice 1 :

*************************************************************************************
Objectif : 
- compréhension du pom.xml
- détection des dépendances
- préparation des injections
- tissage des injections dans le contexte spring, manipulation de spring IDE
*************************************************************************************

Dans le package com.acme.ex1.domain.dao.xml et  com.acme.ex1.domain.service.xml:

1. écrire deux implémentations de l'interface MovieDao : 'FoxMovieDaoImpl' et 'WarnerMovieDaoImpl'
chacune renvoie une liste de films (liste lue dans un fichier).

2. écrire une implémentation de MovieService, la méthode findMovies s'appuie 
sur une des implémentations de MovieDao pour renvoyer une liste de films

3. Comprendre la dépendance entre le service (MovieService) et les dao (MovieDao)

4. Préparer les injections (par setter ou par constructeur) dans les classes java

5. Créer un fichier context spring dans src/main/resources (dossier com/acme/ex1/context)

6. Externaliser la gestion des dépendances dans un fichier context spring

7. Ecrire une deuxième implémentation de l'interface MovieService capable de recevoir plusieurs Dao et non plus un seul

Dans le package com.acme.ex1.domain.annotations : 

reprendre les étapes 1 à 7 (code identique) en configurant le contexte par annotations.
Utiliser pour cela les packages dao.annotations et service.annotations
Les classes seront identiques (aux annotations près), seul le contexte changera.

8. Tester le bon fonctionnement du programme en complétant la classe de test (MovieServiceImplTest)

9. Ecrire un deuxième test unitaire pour le service, en utilisant cette fois ci les mocks (JMock)

