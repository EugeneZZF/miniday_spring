package eugeneZZF.miniday.identity.auth;

import eugeneZZF.miniday.identity.auth.dto.RegisterRequest;
import eugeneZZF.miniday.identity.auth.dto.UserResponse;
import eugeneZZF.miniday.identity.user.UserService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(
            @Valid @RequestBody RegisterRequest request
    ) {
        return userService.register(request);
    }
}