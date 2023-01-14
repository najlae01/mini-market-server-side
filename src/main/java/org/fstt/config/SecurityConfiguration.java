package org.fstt.config;

import org.fstt.metier.AppUserMetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	

	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] resources = new String[]{
                "/",
                "/home",
                "/pictureCheckCode",
                "/include/**",
                "/css/**",
                "/icons/**",
                "/images/**",
                "/js/**",
                "/resources/**",
                "/layer/**",
                "/static/**",
                "/js/**",
                "/img/**",
                "/webjars/**"
        };
		http.csrf().disable()
		.authorizeRequests()
		//.antMatchers("/", "/home").hasAnyAuthority("ADMIN", "Client", "Fournisseur")
		//.antMatchers("/auth/**").hasAnyAuthority("ADMIN", "Client", "Fournisseur")
		//.antMatchers("/dashboard").hasAnyAuthority("ADMIN")
		.antMatchers("/**").permitAll()
		.antMatchers("/","/public/**", "/resources/**","/resources/public/**", "/static/**", "/static/images/**", "/resources/static/images/**", "/resources/public/**", "/target/classes/static/images/**")
        .permitAll()
		.antMatchers(resources).permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403");
		http.cors();
	}

	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//In-Memory
		auth.inMemoryAuthentication().withUser("Najlae").password(passwordEncoder().encode("test@123")).authorities("USER", "ADMIN");
		
		//Database Auth
		auth.userDetailsService(appUserMetier).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
	
}
