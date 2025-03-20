package com.felipesilva.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private static final String[] PUBLIC_MATCHERS = { "/h2-console/**" };

	private static final String[] PUBLIC_MATCHERS_GET = { "/produtos/**", "/categorias/**" };

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.headers(h -> h.frameOptions(f -> f.disable()));

		http.csrf(c -> c.disable());

		http.authorizeHttpRequests(ar -> ar.requestMatchers(PUBLIC_MATCHERS).permitAll()
				.requestMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll().anyRequest().authenticated());

		http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true); // Permite credenciais como cookies
		configuration.addAllowedOrigin("*"); // Permite qualquer origem (use com cautela em produção)
		configuration.addAllowedHeader("*"); // Permite todos os cabeçalhos
		configuration.addAllowedMethod("*"); // Permite todos os métodos (GET, POST, etc.)

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return source;
	}

}
