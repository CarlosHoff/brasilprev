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

  private static final String PRODUTO = "/v1/brasilprev/cadastraProduto";
  private static final String DELETE_PRODUTO = "/v1/brasilprev/deletaProduto/{id}";
  private static final String BUSCA_PRODUTO = "/v1/brasilprev/buscaProdutos";
  private static final String BUSCA_PRODUTO_ID = "/v1/brasilprev/buscaProdutoPeloID/{id}";
  private static final String UPDATE_PRODUTO = "/v1/brasilprev/updateProduto/{id}";
  private static final String CADASTRA_CLIENTE = "/v1/brasilprev/cadastraCliente";
  private static final String DELETE_CLIENTE = "/v1/brasilprev/deletaCliente/{id}";
  private static final String BUSCA_CLIENTE = "/v1/brasilprev/buscaClientes";
  private static final String BUSCA_CLIENTE_ID = "/v1/brasilprev/buscaClientePeloID/{id}";
  private static final String CATEGORIA = "/v1/brasilprev/cadastraCategoria";
  private static final String PEDIDO = "/v1/brasilprev/cadastraPedido";
  private static final String DELETE_PEDIDO = "/v1/brasilprev/deletaPedido/{id}";
  private static final String BUSCA_PEDIDO = "/v1/brasilprev/buscaPedidos";
  private static final String BUSCA_PEDIDO_ID = "/v1/brasilprev/buscaPedidoPeloID/{id}";
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
