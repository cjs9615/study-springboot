package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(security->security
				.requestMatchers(new AntPathRequestMatcher("/member/**")).authenticated()
				.requestMatchers(new AntPathRequestMatcher("/manaber/**")).hasRole("MANAGER")
				.requestMatchers(new AntPathRequestMatcher("/manaber/**")).hasRole("ADMIN")
				.anyRequest().permitAll());
		
		http.formLogin(form->form
				.loginPage("/login")
				.defaultSuccessUrl("/loginSuccess", true));
		
		http.csrf(cf->cf.disable());
		
		return http.build();
	}

}
