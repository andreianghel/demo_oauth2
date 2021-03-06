package ro.luxoft.demo2authserver.config;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@Order(SecurityProperties.BASIC_AUTH_ORDER - 2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().permitAll()
                .and()
                .anonymous().disable()
                .httpBasic()
                .and()
                .authorizeRequests().anyRequest().authenticated()
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("pass").roles("USER")
                .and()
                .withUser("admin").password("adminpass").authorities("ROLE_ADMIN");
    }


}
