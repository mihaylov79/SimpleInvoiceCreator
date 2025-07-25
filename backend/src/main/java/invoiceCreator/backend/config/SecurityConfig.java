package invoiceCreator.backend.config;


import invoiceCreator.backend.jwt.JwtAuthFilter;
import invoiceCreator.backend.user.model.User;
import invoiceCreator.backend.user.model.UserRole;
import invoiceCreator.backend.user.repository.UserRepository;
import invoiceCreator.backend.user.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public SecurityConfig(JwtAuthFilter jwtAuthFilter, UserServiceImpl userService, PasswordEncoder passwordEncoder) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;

    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated())
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

//    Spring Security използва AuthenticationProvider,
//    за да валидира потребителите при логин (или при проверка на JWT)
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }


    //TODO Да създам методи в UserService isEmpty и save
    // за да избегна подаването директно на репото в Config-a
    @Bean
    public CommandLineRunner initializeAdmin (PasswordEncoder passwordEncoder, UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {

                User admin = User.builder()
                        .username("administrator")
                        .password(passwordEncoder.encode("admin321"))
                        .userRole(UserRole.ADMIN)
                        .active(true)
                        .build();

                userRepository.save(admin);
            }
        };
    }
}
