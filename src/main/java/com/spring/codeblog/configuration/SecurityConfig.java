package com.spring.codeblog.configuration;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //todas as URI que nao vao precisar de autorizacao, quando elas forem acessadas, nao sera testado o auth
    private static final String[] AUTH_LIST = {
            "/",
            "/posts",
            "/posts/{id}"
    };
    //obs: para inserir um new post sera necessario autorizacao

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers(AUTH_LIST).permitAll() // todos que estiverem em auth list esta autorizado
                .anyRequest().authenticated()// as demais sera necessario autenticar
                .and().formLogin().permitAll()//permite acesso pagina login
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
    //Define o usuario para autenticacao em memoria
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("Fernando").password("{noop}123").roles("ADMIN");
    }
    //obs: para que a senha funcione necessario colocar noop

    //fica como exemplo, nao sera utilizado
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/bootstrap/**");
//        web.ignoring().antMatchers("/bootstrap/**", "/style/**");
    }
}
