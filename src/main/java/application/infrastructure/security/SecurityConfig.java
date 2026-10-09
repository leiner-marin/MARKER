package application.infrastructure.security;

import jakarta.servlet.Servlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    ServletContextInitializer h2ConsoleServletContextInitializer() {
        return servletContext -> {
            try {
                Class<?> servletClass = Class.forName("org.h2.server.web.JakartaWebServlet");
                Servlet servlet = (Servlet) servletClass.getDeclaredConstructor().newInstance();

                var registration = servletContext.addServlet("H2Console", servlet);
                registration.setLoadOnStartup(1);
                registration.addMapping("/h2-console");
                registration.addMapping("/h2-console/*");
                registration.setInitParameter("webAllowOthers", "false");
                registration.setInitParameter("trace", "false");
            } catch (Exception ex) {
                throw new IllegalStateException("Unable to register H2 console servlet", ex);
            }
        };
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console", "/h2-console/", "/h2-console/**").permitAll()
                .requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll())
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**"))
            .headers(headers -> headers
                .frameOptions(frame -> frame.sameOrigin()))
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
