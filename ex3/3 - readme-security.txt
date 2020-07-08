exercice 3 :

*************************************************************************************
Objectif : 																			*
- mise en oeuvre de spring security												    *
*************************************************************************************

1. Compléter le fichier pom.xml en déclarant une dépendance vers :
   * org.springframework.security	spring-security-config					3.1.0.RELEASE
   
2. Reprendre la classe com.acme.common.broker.impl.SecurityPreProcessor. Dans la méthode preProcess :
   Récupérer le contexte de sécurité (SecurityContextHolder.getContext())
   S'il est non nul et si SecurityContextHolder.getContext().getAuthentication()!=null :
   Afficher (System.out.println) le nom de l'utilisateur 
   
   Pour aller plus loin : ajouter une annotation @RolesAllowed sur une des commande et vérifier que l'utilisateur
   en cours a un des roles permettant de 'jouer' la commande tranmise à la méthode preProcess.
   Utiliser pour cela SecurityContextHolder.getContext().getAuthentication().getAuthorities()