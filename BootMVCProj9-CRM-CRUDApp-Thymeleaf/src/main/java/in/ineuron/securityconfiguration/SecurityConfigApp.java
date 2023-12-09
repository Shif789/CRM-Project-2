package in.ineuron.securityconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {

	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Bean
	public SecurityFilterChain customFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		//.csrf().disable()
		.authorizeHttpRequests()
		.antMatchers("/","/user/register","/login").permitAll()
//		.antMatchers("/bank/offers").authenticated()
//		.antMatchers("/bank/balance").hasAnyAuthority("CUSTOMER","MANAGER")
//		.antMatchers("/bank/loanApprove").hasAuthority("MANAGER")
		.anyRequest().authenticated()
		.and().formLogin()
		.and().oauth2Login()
//		.defaultSuccessUrl("/customer/list", true) // to redirect main page
//		.loginPage("/user/showLogin") // GET mode request to custom login page
//		.loginProcessingUrl("/login") // POST mode request to inbuilt login
//		.failureUrl("/user/showLogin?error")// wrong credentials redirects to custom login page
		.and().rememberMe()
		.and().logout()
//		.logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
//		.logoutSuccessUrl("/user/showLogin?logout")
//		.and().exceptionHandling().accessDeniedPage("/bank/denied")
		.and().sessionManagement().maximumSessions(10).maxSessionsPreventsLogin(true)
		;
		return httpSecurity.build();
	}
	
}
