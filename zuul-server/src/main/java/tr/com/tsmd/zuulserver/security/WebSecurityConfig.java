package tr.com.tsmd.zuulserver.security;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tr.com.tsmd.common.security.JwtConfig;

@EnableWebSecurity  // Enable security config. This annotation denotes config for spring security.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private JwtConfig jwtConfig;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .cors().and()
        .csrf().disable()
        // make sure we use stateless session; session won't be used to store user's state.
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        // handle an authorized attempts
        .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
        .and()
        // Add a filter to validate the tokens with every request
        .addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
        // authorization requests config
        .authorizeRequests()
        // allow all who are accessing "auth" service
        .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
        .antMatchers(HttpMethod.POST, jwtConfig.getSsUri()).permitAll()
        .antMatchers(HttpMethod.DELETE, jwtConfig.getUri()).permitAll()
        .antMatchers(HttpMethod.DELETE, jwtConfig.getSsUri()).permitAll()
        .antMatchers(HttpMethod.GET, jwtConfig.getcUri()).permitAll()
        .antMatchers(HttpMethod.POST, jwtConfig.getcUri()).permitAll()
        .antMatchers(HttpMethod.DELETE, jwtConfig.getcUri()).permitAll()
        // must be an admin if trying to access admin area (authentication is also required here)
        .antMatchers("/catalog/**").hasRole("ADMIN")
        // Any other request must be authenticated
        .anyRequest().authenticated();
  }

  @Bean
  public JwtConfig jwtConfig() {
    return new JwtConfig();
  }
}
