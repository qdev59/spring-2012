package com.acme.common.broker.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.acme.common.broker.AbstractCommand;
import com.acme.common.broker.CommandPreProcessor;

public class SecurityPreProcessor implements CommandPreProcessor {

	@Override
	public void preProcess(AbstractCommand command) {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null && context.getAuthentication() != null) {
			String username = context.getAuthentication().getName();
			System.out.println(username + " tries to run " + command.toString());
			if(command.getClass().isAnnotationPresent(RolesAllowed.class))
			{
				RolesAllowed ra = command.getClass().getAnnotation(RolesAllowed.class);
				List<String> rolesAllowed = Arrays.asList(ra.value());
				for(GrantedAuthority authz : context.getAuthentication().getAuthorities())
				{
					if(rolesAllowed.contains(authz.getAuthority()))
					{
						System.out.println(username+" is allowed to run "+command.toString());
						return;
					}
				}
				//throw new SecurityException(username+" is not allowed to run "+command.toString());

			}
		}
	}
}
