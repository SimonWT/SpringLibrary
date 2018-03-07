package net.proselyte.springsecurityapp.validator;

import net.proselyte.springsecurityapp.model.Book;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link net.proselyte.springsecurityapp.model.Book} class,
 * implements {@link Validator} interface.
 *
 * @author Igor Vakhula
 *
 */

@Component
public class BookValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;

        /**
         * Error if we have whitespace or number of characters lower than 8 or upper than 32 (USERNAME)
         */
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "Required");
        if (book.getTitle().length() < 2 || book.getTitle().length() > 64) {
            errors.rejectValue("title", "Size.bookForm.title");
        }



        /**
         * Error if we have whitespace or number of characters lower than 8 or upper than 32 (PASSWORD)
         */
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "Required");
        if (book.getAuthor("Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein").length() < 4 || book.getAuthor("Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein").length() > 32) {
            errors.rejectValue("author", "Size.bookForm.author");
        }



        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "Required");
        if (book.getYear().length() < 4) {
            errors.rejectValue("year", "Size.bookForm.year");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "edition", "Required");
        if (book.getEdition() < 1 || book.getEdition() > 32) {
            errors.rejectValue("edition", "Size.bookForm.edition");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "Required");
        if (book.getPrice() < 0) {
            errors.rejectValue("price", "Size.bookForm.price");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "copies", "Required");
        if (book.getCopies() < 1) {
            errors.rejectValue("copies", "Size.bookForm.copies");
        }




    }
}
