1. Compléter le fichier pom.xml en déclarant une dépendance vers :
   * javax.inject			javax.inject				1
   * com.acme				ex3							0.0.1
   * org.springframework	spring-webmvc				3.1.2.RELEASE

2. Déclarer la servlet spring sous le nom 'rest' dans le fichier web.xml, l'associer au pattern d'url /rest/*

3. Mettre en oeuvre un endpoint REST (com.acme.ex4.HrEndpoint) contenant 4 méthodes, gérant respectivement les URL suivante : 
http://localhost:8080/ex4/rest/candidate/{id} en GET renvoie le détail d'un candidat
http://localhost:8080/ex4/rest/employee/{id} en GET renvoie le détail d'un employe
http://localhost:8080/ex4/rest/candidates en POST renvoie une liste de candidats sur la base d'un CandidateFilter recu via la requête HTTP
http://localhost:8080/ex4/rest/employees en POST renvoie une liste d'employés sur la base d'un EmployeeFilter via la requête HTTP