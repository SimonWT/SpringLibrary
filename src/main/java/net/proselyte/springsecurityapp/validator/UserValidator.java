package net.proselyte.springsecurityapp.validator;

import net.proselyte.springsecurityapp.model.Users.User;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link User} class,
 * implements {@link Validator} interface.
 *
 * @author Igor Vakhula
 *
 */

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        /**
         * Error if we have whitespace or number of characters lower than 8 or upper than 32 (USERNAME)
         */
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (user.getUsername().length() < 2 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }

        /**
         * If we already have user with inputed name we print error about it
         */
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        /**
         * Error if we have whitespace or number of characters lower than 8 or upper than 32 (PASSWORD)
         */
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        if (user.getName().length() < 2 || user.getName().length() > 32) {
            errors.rejectValue("name", "Size.userForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "Required");
        if (user.getSurname().length() < 2 || user.getSurname().length() > 32) {
            errors.rejectValue("surname", "Size.userForm.surname");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "Required");
        if (user.getPhone().length() != 11) {
            errors.rejectValue("phone", "Size.userForm.phone");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
        if (user.getEmail().length() < 8 || user.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.userForm.email");
        }


        /**
         * If the first password does not match with the second one
         */

    }
}
