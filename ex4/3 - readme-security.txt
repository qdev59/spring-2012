exercice 4 :

*************************************************************************************
Objectif : 																			*
- mise en oeuvre de spring security												    *
*************************************************************************************

1. Compléter le fichier pom.xml en déclarant une dépendance vers :
   * org.springframework.security	spring-security-web						3.1.0.RELEASE
   * org.springframework.security	spring-security-taglibs					3.1.0.RELEASE
   * org.springframework.security	spring-security-config					3.1.0.RELEASE
   
2. Ajouter au web.xml le filtre suivant : 
	<filter>
		<filter-name>springSecurityFilterChain</filter-name>
		<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>springSecurityFilterChain</filter-name>
		<url-pattern>/*</url-pattern>
		<url-pattern>/j_spring_security_check</url-pattern>
	</filter-mapping>
	
3. Ajouter le namespace security au fichier applicationContext.xml et ajouter le blocs suivant :
	<security:http security="none" pattern="/rest/**" />

	<security:http security="none" pattern="/log*.jsp" />

	<security:http auto-config="true" >
		<security:form-login login-page='/login.jsp' />
		<security:logout logout-success-url="/logout.jsp" />
		<security:intercept-url pattern="/**" access="ROLE_1, ROLE_2" />
	</security:http>

	<security:authentication-manager>
		<security:authentication-provider>
			<security:user-service>
				<security:user name="jdoe" password="xyz" authorities="ROLE_1, ROLE_2" />
			</security:user-service>
		</security:authentication-provider>
	</security:authentication-manager>

4. Vérifier que l'authentification fonctionne