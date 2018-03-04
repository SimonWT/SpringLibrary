package net.proselyte.springsecurityapp.validator;

import net.proselyte.springsecurityapp.model.Article;
import net.proselyte.springsecurityapp.model.AudioVideo;
import net.proselyte.springsecurityapp.model.Book;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link net.proselyte.springsecurityapp.model.AudioVideo} class,
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
        if (audioVideo.getAuthor().length() < 2 || audioVideo.getAuthor().length() > 64) {
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
