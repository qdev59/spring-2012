1. Compléter le fichier pom.xml en déclarant une dépendance vers :
   * org.springframework	spring-jms					3.1.2.RELEASE
   
2. Ecrire le code du serveur (com.acme.ex5.messaging.Server)

3. Ecrire le code du client asynchrone en indiquant au moment de l'envoi 
la queue dans laquelle le serveur doit renvoyer la réponse

4. Implémenter la méthode onMessage du client asynchrone afin qu'il puisse recevoir la réponse à la "question qu'il a posée"
et que le serveur a envoyée sur la queue des réponses

4. Inscrire dans le contexte les beans 'techniques' nécessaires au bon fonctionnement 
de la discussion client / serveur
=> 2 queues
=> 1 jms template
=> un MessageListenerContainer pour les 'récepteurs' de messages