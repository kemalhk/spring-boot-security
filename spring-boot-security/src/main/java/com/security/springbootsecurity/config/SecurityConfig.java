package com.security.springbootsecurity.config;

import com.security.springbootsecurity.auth.TokenManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
;


@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenManager jwtUtil;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/basic").hasRole("USER")
                    .antMatchers(HttpMethod.POST, "/basic").hasRole("ADMIN")
                    .and()
                .csrf().disable();

    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic().disable()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/basic").hasRole("USER")
//                .antMatchers(HttpMethod.POST, "/basic").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JwtAutHenticationFilter(authenticationManager(), jwtUtil))
//                .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtUtil));
//    }
}
