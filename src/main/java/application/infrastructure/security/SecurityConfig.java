package application.infrastructure.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${APP_SECURITY_ADMIN_PASSWORD:marker-dev-password}")
    private String adminPassword;

    @Value("${APP_SECURITY_SELLER_PASSWORD:marker-dev-password}")
    private String sellerPassword;

    @Value("${APP_SECURITY_BUYER_PASSWORD:marker-dev-password}")
    private String buyerPassword;

    @Value("${APP_SECURITY_LOGISTICS_PASSWORD:marker-dev-password}")
    private String logisticsPassword;

    @Value("${APP_SECURITY_SUPERVISOR_PASSWORD:marker-dev-password}")
    private String supervisorPassword;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.withUsername("marker-admin")
                .password(passwordEncoder.encode(adminPassword))
                .roles("ADMINISTRATOR")
                .build();
        UserDetails seller = User.withUsername("marker-seller")
                .password(passwordEncoder.encode(sellerPassword))
                .roles("SELLER")
                .build();
        UserDetails buyer = User.withUsername("marker-buyer")
                .password(passwordEncoder.encode(buyerPassword))
                .roles("BUYER")
                .build();
        UserDetails logistics = User.withUsername("marker-logistics")
                .password(passwordEncoder.encode(logisticsPassword))
                .roles("LOGISTICS_OPERATOR")
                .build();
        UserDetails supervisor = User.withUsername("marker-supervisor")
                .password(passwordEncoder.encode(supervisorPassword))
                .roles("SUPERVISOR")
                .build();
        return new InMemoryUserDetailsManager(admin, seller, buyer, logistics, supervisor);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console", "/h2-console/", "/h2-console/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/catalog/**").authenticated()
                .requestMatchers("/api/users/**").hasRole("ADMINISTRATOR")
                .requestMatchers(HttpMethod.POST, "/api/buyers/**").hasAnyRole("BUYER", "ADMINISTRATOR")
                .requestMatchers(HttpMethod.GET, "/api/buyers/**").hasAnyRole("BUYER", "ADMINISTRATOR")
                .requestMatchers(HttpMethod.PUT, "/api/buyers/**").hasAnyRole("BUYER", "ADMINISTRATOR")
                .requestMatchers("/api/sellers/**").hasRole("ADMINISTRATOR")
                .requestMatchers("/api/warehouses/**").hasAnyRole("ADMINISTRATOR", "LOGISTICS_OPERATOR")
                .requestMatchers(HttpMethod.GET, "/api/products/**").authenticated()
                .requestMatchers("/api/products/**").hasAnyRole("SELLER", "ADMINISTRATOR")
                .requestMatchers("/api/inventory/**").hasAnyRole("SELLER", "ADMINISTRATOR", "LOGISTICS_OPERATOR")
                .requestMatchers("/api/carts/**").hasRole("BUYER")
                .requestMatchers("/api/orders/**").hasAnyRole("BUYER", "ADMINISTRATOR", "LOGISTICS_OPERATOR")
                .requestMatchers("/api/payments/**").hasRole("BUYER")
                .requestMatchers("/api/invoices/**").hasAnyRole("BUYER", "ADMINISTRATOR")
                .requestMatchers("/api/shipments/**").hasRole("LOGISTICS_OPERATOR")
                .requestMatchers("/api/returns/**").hasRole("BUYER")
                .requestMatchers("/api/refunds/**").hasRole("ADMINISTRATOR")
                .requestMatchers("/api/reports/**").hasAnyRole("ADMINISTRATOR", "SUPERVISOR")
                .requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll())
            .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
