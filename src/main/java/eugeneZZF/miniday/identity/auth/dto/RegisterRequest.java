package eugeneZZF.miniday.identity.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
    @NotBlank(message = "Email обязателен")
    @Email(message = "Некорректный формат email")
    @Size(max = 255, message = "Email не должен превышать 255 символов")
    String email,

    @NotBlank(message = "Пароль обязателен")
    @Size(min = 8, max = 72, message = "Пароль должен содержать от 8 до 72 символов")
    String password
) {

}
