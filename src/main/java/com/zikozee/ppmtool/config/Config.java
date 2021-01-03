package com.zikozee.ppmtool.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaAuditing
public class Config {

    @Value("${frontend.url}")
    private String webUrl;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/project")
                        .allowedOrigins(webUrl, "another domain")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowCredentials(false)//specifies if cross-domain requests can have authorization credentials or not.
                .maxAge(3600);//Maximum age (in seconds) of the cache duration for pre-flight responses.
//                registry.addMapping("/api/jjv")
//                        .allowedOrigins("ANOTHER URL")

            }
        };
    }
}

//Using Spring Security
/* READ: -->> https://www.baeldung.com/spring-security-cors-preflight

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
             .cors()  //The cors() method will add the Spring-provided CorsFilter to the application context which in turn bypasses the authorization checks for OPTIONS requests.
             .and()
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .httpBasic();  // sample configuring of security

    }
}
 */
