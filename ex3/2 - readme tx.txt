exercice 3 :

*************************************************************************************
Objectif :
- ecriture d'un pom.xml
- détection des dépendances
- préparation des injections
- tissage des injections par annotations, manipulation de spring IDE
- éciture de tests unitaires
- mapping jpa
- manipulation d'un entityManager
- mise en oeuvre des transactions par aspect, par annotation
*************************************************************************************


1. Etudier dans ex3.broker.command les commandes et les commandHandlers

2. Créer un contexte spring pour la couche service : com/acme/appCtxBroker.xml

3. Lier les commandes aux commandRunners inscrivant dans le contexte spring la classe com.acme.common.broker.CommandProcessorImpl

4. Appliquer les transactions 
	propagation mandatory sur la couche business (par aspects).
	propagation mandatory sur les command handlers (par annotations).
	propagation required dans la méthode process (programmatique).