package net.proselyte.springsecurityapp.validator;

import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link AudioVideo} class,
 * implements {@link Validator} interface.
 *
 * @author Igor Vakhula
 *
 */

@Component
public class AudioVideoValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return AudioVideo.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AudioVideo audioVideo = (AudioVideo) o;


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "Required");
        if (audioVideo.getAuthors().length() < 2 || audioVideo.getAuthors().length() > 64) {
            errors.rejectValue("author", "Size.audioVideoForm.author");
        }



        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "Required");
        if (audioVideo.getTitle().length() < 2 || audioVideo.getTitle().length() > 64) {
            errors.rejectValue("title", "Size.audioVideoForm.title");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "Required");
        if (audioVideo.getPrice() <= 0) {
            errors.rejectValue("price", "Size.audioVideoForm.price");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "copies", "Required");
        if (audioVideo.getCopies() < 0) {
            errors.rejectValue("copies", "Size.audioVideoForm.copies");
        }




    }
}
