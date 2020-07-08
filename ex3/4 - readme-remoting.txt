exercice 3 :

*************************************************************************************
Objectif : 																			*
- mise en oeuvre du remoting (côté client) avec HttpInvoker	   						*
*************************************************************************************

1. Compléter le fichier pom.xml en déclarant une dépendance vers :
   * org.springframework.security	spring-security-remoting				3.1.0.RELEASE
   
2. Dans le fichier appCtxBroker.xml de ex3 : 
   ajouter pour la propriété neighbours un ou plusieurs HttpInvokerProxyFactoryBean 
   vers les autre CommandProcessor disponibles sur le réseau et exposés avec HttpInvoker.