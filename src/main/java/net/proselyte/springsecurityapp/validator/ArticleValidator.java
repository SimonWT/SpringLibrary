package net.proselyte.springsecurityapp.validator;

import net.proselyte.springsecurityapp.model.Documents.Article;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link Book} class,
 * implements {@link Validator} interface.
 *
 * @author Igor Vakhula
 *
 */

@Component
public class ArticleValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Article.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Article article = (Article) o;


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "journal_title", "Required");
        if (article.getJournal().length() < 2 || article.getJournal().length() > 64) {
            errors.rejectValue("journal_title", "Size.articleForm.journal_title");
        }



        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "Required");
        if (article.getPrice() < 0) {
            errors.rejectValue("price", "Size.articleForm.price");
        }



        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "article_title", "Required");
        if (article.getTitle().length() < 2 || article.getTitle().length() > 64) {
            errors.rejectValue("article_title", "Size.articleForm.article_title");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "copies", "Required");
        if (article.getCopies() < 0) {
            errors.rejectValue("copies", "Size.articleForm.copies");
        }

        //TODO: Разобраться с Date
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publication_month_year", "Required");
        if (article.getDate().toString().length() < 4) {
            errors.rejectValue("publication_month_year", "Size.articleForm.publication_month_year");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "Required");
        if (article.getAuthors().length() < 2 || article.getAuthors().length() > 64) {
            errors.rejectValue("author", "Size.articleForm.author");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "editor", "Required");
        if (article.getEditors().length() < 2 || article.getEditors().length() > 64) {
            errors.rejectValue("editor", "Size.articleForm.editor");
        }




    }
}
