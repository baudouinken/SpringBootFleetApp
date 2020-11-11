package com.fleet.project;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityAudotorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// get current authetication context
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String username = authentication.getName();

		// return username
		return Optional.ofNullable(username).filter(s -> !s.isEmpty());
	}

}
