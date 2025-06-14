package invoiceCreator.backend.user.service.Impl;

import invoiceCreator.backend.security.CustomUserDetails;
import invoiceCreator.backend.user.model.User;
import invoiceCreator.backend.user.repository.UserRepository;
import invoiceCreator.backend.user.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
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
