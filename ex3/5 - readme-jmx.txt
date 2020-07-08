exercice 3 :

*************************************************************************************
Objectif : 																			*
- mise en oeuvre de jmx										   						*
*************************************************************************************

   
1. Dans le fichier appCtxBroker de ex3 : 
   ajouter pour la propriété preProcessors et postProcessors une référence vers LoggerPrePostProcessor.
   
2. Ajouter à la classe un champ boolean enabled (avec le getter et le setter)

3. Dans LoggerPrePostProcessor : ajouter les annotations permettant d'exposer l'objet en JMX (et les accesseurs du champ enabled) 

4. Modifier la méthode log pour qu'elle prenne en compte la valeur du champ enabled

5. Ajouter au contexte appCtxBroker.xml la directive permettant d'activer l'auto exportation des beans en JMX.

