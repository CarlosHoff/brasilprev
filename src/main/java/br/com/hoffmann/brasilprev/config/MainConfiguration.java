package br.com.hoffmann.brasilprev.config;

import br.com.hoffmann.brasilprev.security.ImplementsUserDetailsService;
import br.com.hoffmann.brasilprev.security.JWTAuthenticationFilter;
import br.com.hoffmann.brasilprev.security.JWTLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class MainConfiguration extends WebSecurityConfigurerAdapter {

    private static final String PRODUTO = "/v1/brasilprev/cadastraProduto";
    private static final String CLIENTE = "/v1/brasilprev/cadastraCliente";
    private static final String CATEGORIA = "/v1/brasilprev/cadastraCategoria";
    private static final String PEDIDO = "/v1/brasilprev/cadastraPedido";
    private static final String LOGIN = "/v1/brasilprev/login";

    @Autowired
    private ImplementsUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers(HttpMethod.POST, LOGIN).permitAll()
            .antMatchers(HttpMethod.POST, PRODUTO).permitAll()
            .antMatchers(HttpMethod.POST, CLIENTE).permitAll()
            .antMatchers(HttpMethod.POST, CATEGORIA).permitAll()
            .antMatchers(HttpMethod.POST, PEDIDO).permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/materialize/**", "/style/**");
    }
}
