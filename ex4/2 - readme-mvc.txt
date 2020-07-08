exercice 4 :

*************************************************************************************
Objectif : 																			*
- mise en oeuvre de spring mvc, 												    *
- bean-validation (JSR-303)											* 												    *
*************************************************************************************

2. déclarer la prise en charge d'un pattern d'url /ui/* par la servlet spring

3. créer un controleur (com.acme.ex4.ui.controller.CandidateController) contenant 3 méthodes :
   une méthode pour présenter le formulaire de recherche de candidats, associée à l'url /ex4/ui/candidate/index
   une méthode pour procéder à la rechercher ds candidats, associée à l'url /ex4/ui/candidate/list.html
   une méthode pour présenter le détail d'un candidat, associée à l'url /ex4/ui/candidate/edit
   une méthode pour convertir un candidat en employé, associé à l'url /ex4/ui/candidate/hire

4. créer les vues correspondantes au point 4 : 
   /WEB-INF/jsp/candidates/index.jsp pour la recherche (formulaire de recherche + liste de résultats)
   /WEB-INF/jsp/candidates/detail.jsp pour la fiche détail
   		celle-ci propose aussi un petit formulaire pour déclarer le candidat comme 'embauché'. 
   
5. créer un controleur (com.acme.ex4.ui.controller.EmployeeController) contenant 1 méthode :
   une méthode pour rechercher des employés, associée à l'url /ex4/ui/employees/index

6. créer 1 une vue WEB-INF/jsp/employees/index.jsp correspondant à la recherche d'employée (point 5). 
   une méthode pour présenter le formulaire de recherche d'employés, associée à l'url /ex4/ui/employee/index
   une méthode pour procéder à la rechercher des employés, associée à l'url /ex4/ui/employee/index


7. ajouter un mécanisme de gestion des exceptions pour associer les exceptions métiers à une page d'erreur et 
les exceptions techniques à une autre page d'erreur.
   
8. ajouter l'internationalisation afin que le message de l'exception puisse être une clé, dont la valeur traduite est affichée dans la page d'erreur.

9. ajouter un mécanisme de validation pour empécher l'embauche du salarié si la date de début n'a pas été saisie.