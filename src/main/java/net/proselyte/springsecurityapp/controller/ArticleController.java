package net.proselyte.springsecurityapp.controller;


import net.proselyte.springsecurityapp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/deleteArticle/{id}")
    public String deleteArticle(@PathVariable("id") Long id){
        articleService.delete(id);

        return "redirect:/listOfArticles";
    }


}
