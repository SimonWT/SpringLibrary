package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.Documents.Article;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.service.ArticleService;
import net.proselyte.springsecurityapp.service.DocumentService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ArticleController {
    private final org.jboss.logging.Logger logger = LoggerFactory.logger(BookController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private DocumentService docService;

    @RequestMapping(value = "/editArticle/{id}", method = RequestMethod.GET)
    public String editInfo(@PathVariable("id") Long id , Model model) {
        Document article = docService.getDocumentById(id);

        if(article!=null)
            logger.info("Article got by ID: "+article.toString());

        model.addAttribute("articleForm", article);

        return "editArticle";
    }

    @RequestMapping(value = "/editArticle/{id}",method = RequestMethod.POST)
    public String editInfo(@ModelAttribute("articleForm") Article articleForm, BindingResult bindingResult, Model model){
        docService.update(articleForm);

        logger.info("Article updated: "+ articleForm.toString());
        return "redirect:/listOfArticles";
    }

    @RequestMapping("/deleteArticle/{id}")
    public String deleteArticle(@PathVariable("id") Long id){
        docService.delete(id);

        return "redirect:/listOfArticles";
    }

    @RequestMapping(value = "/listOfArticlesForPatron", method = RequestMethod.GET)
    public String listOfArticlesForPatron() {
        return "listOfArticlesForPatron";
    }

    @RequestMapping(value = "/listOfArticles", method = RequestMethod.GET)
    public String listOfArticles(Model model){
        List<Article> articleList = docService.getListOfArticle();
        model.addAttribute(articleList);
        return "listOfArticles";
    }

}
