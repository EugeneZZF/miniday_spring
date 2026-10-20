package eugeneZZF.miniday.identity.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eugeneZZF.miniday.identity.auth.dto.RegisterRequest;
import eugeneZZF.miniday.identity.auth.dto.UserResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor 
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional 
    public UserResponse register(RegisterRequest request){
        String normalizedEmail = request.email().trim().toLowerCase();

        if(userRepository.existsByEmail(normalizedEmail)){
            throw new IllegalArgumentException("User with this email is already exist");
        }

        String passwordHash = passwordEncoder.encode(request.password());

         User user = new User(normalizedEmail, passwordHash);
         User savedUser = userRepository.save(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getCreatedAt()
        );
    }
}
