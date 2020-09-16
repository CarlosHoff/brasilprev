package br.com.hoffmann.brasilprev.config;

import br.com.hoffmann.brasilprev.security.ImplementsUserDetailsService;
import br.com.hoffmann.brasilprev.security.JWTAuthenticationFilter;
import br.com.hoffmann.brasilprev.security.JWTLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MainConfiguration extends WebSecurityConfigurerAdapter {

  private static final String PRODUTO = "/v1/brasilprev/cadastraproduto";
  private static final String DELETE_PRODUTO = "/v1/brasilprev/deletaproduto/**";
  private static final String BUSCA_PRODUTO = "/v1/brasilprev/buscaprodutos";
  private static final String BUSCA_PRODUTO_ID = "/v1/brasilprev/buscaprodutopeloid";
  private static final String UPDATE_PRODUTO = "/v1/brasilprev/updateproduto/**";
  private static final String CADASTRA_CLIENTE = "/v1/brasilprev/cadastracliente";
  private static final String DELETE_CLIENTE = "/v1/brasilprev/deletacliente/**";
  private static final String BUSCA_CLIENTE = "/v1/brasilprev/buscaclientes";
  private static final String BUSCA_CLIENTE_ID = "/v1/brasilprev/buscaclientepeloid";
  private static final String CATEGORIA = "/v1/brasilprev/cadastracategoria";
  private static final String PEDIDO = "/v1/brasilprev/cadastrapedido";
  private static final String DELETE_PEDIDO = "/v1/brasilprev/deletapedido/**";
  private static final String BUSCA_PEDIDO = "/v1/brasilprev/buscapedidos";
  private static final String BUSCA_PEDIDO_ID = "/v1/brasilprev/buscapedidopeloid";
  private static final String LOGIN = "/v1/brasilprev/login";

  @Autowired
  private ImplementsUserDetailsService userDetailsService;

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf().disable().authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers(HttpMethod.POST, LOGIN).permitAll()
        .antMatchers(HttpMethod.POST, CADASTRA_CLIENTE).permitAll()
        .antMatchers(HttpMethod.POST, CATEGORIA).permitAll()
        .antMatchers(HttpMethod.POST, PEDIDO).permitAll()
        .antMatchers(HttpMethod.POST, PRODUTO).permitAll()
        .antMatchers(HttpMethod.DELETE, DELETE_CLIENTE).permitAll()
        .antMatchers(HttpMethod.DELETE, DELETE_PEDIDO).permitAll()
        .antMatchers(HttpMethod.DELETE, DELETE_PRODUTO).permitAll()
        .antMatchers(HttpMethod.GET, BUSCA_CLIENTE).permitAll()
        .antMatchers(HttpMethod.GET, BUSCA_CLIENTE_ID).permitAll()
        .antMatchers(HttpMethod.GET, BUSCA_PEDIDO).permitAll()
        .antMatchers(HttpMethod.GET, BUSCA_PEDIDO_ID).permitAll()
        .antMatchers(HttpMethod.GET, BUSCA_PRODUTO).permitAll()
        .antMatchers(HttpMethod.GET, BUSCA_PRODUTO_ID).permitAll()
        .antMatchers(HttpMethod.PUT, UPDATE_PRODUTO).permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new JWTLoginFilter(LOGIN, authenticationManager()),
            UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
  }
}
