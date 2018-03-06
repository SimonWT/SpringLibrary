package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.Article;
import net.proselyte.springsecurityapp.model.Book;
import net.proselyte.springsecurityapp.service.ArticleService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArticleController {
    private final org.jboss.logging.Logger logger = LoggerFactory.logger(BookController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/editArticle/{id}", method = RequestMethod.GET)
    public String editInfo(@PathVariable("id") Long id , Model model) {
        Article article = articleService.getArticleById(id);

        if(article!=null)
            logger.info("Article got by ID: "+article.toString());

        model.addAttribute("articleForm", article);

        return "editArticle";
    }

    @RequestMapping(value = "/editArticle/{id}",method = RequestMethod.POST)
    public String editInfo(@ModelAttribute("articleForm") Article articleForm, BindingResult bindingResult, Model model){
        articleService.update(articleForm);

        logger.info("Article updated: "+ articleForm.toString());
        return "redirect:/listOfArticles";
    }

    @RequestMapping("/deleteArticle/{id}")
    public String deleteArticle(@PathVariable("id") Long id){
        articleService.delete(id);

        return "redirect:/listOfArticles";
    }

    @RequestMapping(value = "/listOfArticlesForPatron", method = RequestMethod.GET)
    public String listOfArticlesForPatron() {
        return "listOfArticlesForPatron";
    }


}
