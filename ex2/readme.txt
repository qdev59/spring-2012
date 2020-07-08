exercice 2 :

*************************************************************************************
Objectif :
- ecriture d'un pom.xml
- détection des dépendances
- préparation des injections
- tissage des injections dans le contexte spring, manipulation de spring IDE
- éciture de tests unitaires
*************************************************************************************


1. Compléter le fichier pom.xml en déclarant la dépendance vers 
   * org.springframework	spring-context				3.1.2.RELEASE
   * org.springframework	spring-test					3.1.2.RELEASE
   * junit					junit						4.10

2. compléter l'implémentation FileTranslationDaoImpl de l'interface TranslationDao. 
Cette classe recherche dans un fichier texte (csv) le mot à traduire et renvoie la traduction.

3. Ecrire dans le contexte spring plusieurs beans faisant référence à TranslationDaoImpl :
- frenchToSpanishDao
- englishToFrenchDao
- englishToSpanishDao
Chaque bean s'appuie sur un fichier différent (fr-es.csv, en-fr.csv, en-es.csv), 
dont le nom est injecté via spring.
Ecrire un test unitaire pour un de ces beans


4. Factoriser dans une DAO parente le répertoire dans lequel se trouve les fichiers.

5. compléter les implémentations de l'interface Interpreter (package business.impl). 
Comprendre pourquoi cette classe a besoin d'une DAO.
Comprendre pourquoi cette classe peut se comporter différemment selon la dao injectée.

6. ecrire une implémentation InterpreterLocatorImpl de l'interface InterpreterLocator.
injecter dans cette classe une map de 'InterpreterImpl'.
Ecrire un test unitaire pour cette classe

7. Compléter l'implémentation de l'interface CommandProcessor en y injectant un InterpreterLocator.
Ecrire un test unitaire pour cette classe.

8. Scinder le contexte spring en deux contextes : 
- AppCtxDao.xml (pour les dao)
- AppCtxService.xml (pour les interpéteurs, l'interpretLocator et le commandProcessor).
 
9. Appliquer un aspect de type 'around' sur la méthode process