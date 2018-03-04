package net.proselyte.springsecurityapp.validator;

import net.proselyte.springsecurityapp.model.Article;
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
        if (article.getJournal_title().length() < 2 || article.getJournal_title().length() > 64) {
            errors.rejectValue("journal_title", "Size.articleForm.journal_title");
        }



        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "Required");
        if (article.getPrice() < 0) {
            errors.rejectValue("price", "Size.articleForm.price");
        }



        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "article_title", "Required");
        if (article.getArticle_title().length() < 2 || article.getArticle_title().length() > 64) {
            errors.rejectValue("article_title", "Size.articleForm.article_title");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "copies", "Required");
        if (article.getCopies() < 0) {
            errors.rejectValue("copies", "Size.articleForm.copies");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publication_month_year", "Required");
        if (article.getPublication_month_year().length() < 4) {
            errors.rejectValue("publication_month_year", "Size.articleForm.publication_month_year");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "Required");
        if (article.getAuthor().length() < 2 || article.getAuthor().length() > 64) {
            errors.rejectValue("author", "Size.articleForm.author");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "editor", "Required");
        if (article.getEditor().length() < 2 || article.getEditor().length() > 64) {
            errors.rejectValue("editor", "Size.articleForm.editor");
        }




    }
}
