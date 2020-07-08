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


1. Compléter le fichier pom.xml en déclarant une dépendance vers :
   * org.springframework	spring-orm					3.1.2.RELEASE
   * org.springframework	spring-web					3.1.2.RELEASE
   * org.hibernate			hibernate-entitymanager 	3.6.9.Final
   * org.hibernate			hibernate-validator 		4.2.0.Final
   * org.hibernate			hibernate-ehcache 			3.6.9.Final


2. Ecrire un mapping par annnotations

3. Préparer un contexte com/acme/ex3a/appCtxConfig.xml contenant une datasource configuré à partir du fichier datasource.properties et de la classe com.training.ex3.utils.MyDatasource 

4. Ajouter au contexte un EntityManagerFactory au contexte

5. Ajouter le transactionManager dans le contexte appCtxConfig.xml 

6. Compléter l'implémentation CandidateManagerImpl et de EmployeeManagerImpl en utilisant l'entityManager. 

7. Créer un contexte com/acme/ex3a/appCtxMain.xml et y inscrire les managers développés en 6. 

8. Créer un contexte com/acme/ex3a/appCtx.xml qui importe les deux précédents.