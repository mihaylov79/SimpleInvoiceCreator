package invoiceCreator.backend.user.service.Impl;

import invoiceCreator.backend.common.exceptions.UsernameAlreadyExist;
import invoiceCreator.backend.security.CustomUserDetails;
import invoiceCreator.backend.user.model.User;
import invoiceCreator.backend.user.model.UserRole;
import invoiceCreator.backend.user.repository.UserRepository;
import invoiceCreator.backend.user.service.UserService;
import invoiceCreator.backend.web.dto.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void registerUser(RegisterRequest request) {
        Optional<User> optionalUser = repository.findByUsername(request.getUsername());

        if (optionalUser.isPresent()) {
            throw new UsernameAlreadyExist("Потребител с това потребителско име вече съществува в базата данни!");
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .birthDate(request.getBirthdate())
                .employerCompany(request.getCompany())
                .userRole(UserRole.USER)
                .active(true)
                .build();

        repository.save(user);

        //TODO Да проверя ако firstName или LastName не бъдат попълнение ще хвърли ли грешка!
    }

    public void getUserByUsername(String username) {
        repository.findByUsername(username)
                  .orElseThrow(()-> new RuntimeException("Потребител с потребителско име : %s не съществува."
                  .formatted(username)));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User with username %s was not found".formatted(username)));

        return new CustomUserDetails(user.getId(),
                                     user.getUsername(),
                                     user.getPassword(),
                                     user.getUserRole(),
                                     user.isActive());
    }

}
