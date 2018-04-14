package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.Booking.History;
import net.proselyte.springsecurityapp.model.Documents.Article;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Users.User;
import net.proselyte.springsecurityapp.service.ArticleService;
import net.proselyte.springsecurityapp.service.DocumentService;
import net.proselyte.springsecurityapp.service.HistoryService;
import net.proselyte.springsecurityapp.service.UserService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {
    private final org.jboss.logging.Logger logger = LoggerFactory.logger(BookController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private DocumentService docService;

    @Autowired
    private UserService userService;

    @Autowired
    private HistoryService historyService;

    @RequestMapping(value = "/addArticle", method = RequestMethod.GET)
    public ModelAndView addArticle(Model model) {
        model.addAttribute("articleForm", new Article());

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        ModelAndView mav = new ModelAndView();

        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("surname", user.getSurname());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());
        mav.setViewName("addArticle");

        mav.addObject("user", userData);

        return mav;

    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public String addArticle(@ModelAttribute("articleForm") Article articleForm, BindingResult bindingResult, Model model) throws ParseException {
        //TODO: Article Validation
        // articleValidator.validate(articleForm, bindingResult);


        if (bindingResult.hasErrors()) {
            return "addArticle";
        }

        articleForm.parseDate();
        docService.save(articleForm);

        return "redirect:/admin";

    }


    @RequestMapping(value = "/editArticle/{id}", method = RequestMethod.GET)
    public ModelAndView editInfo(@PathVariable("id") Long id , Model model) {
        Document article = docService.getDocumentById(id);

        if(article!=null) {
            logger.info("Article got by ID: " + article.toString());
            java.util.Date date = ((Article) article).getDate();
            String dateString = "";
            if(date!=null) dateString = date.toString().substring(0,10);
            ((Article) article).setDateString(dateString);
        }

        model.addAttribute("articleForm", article);

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        ModelAndView mav = new ModelAndView();

        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("surname", user.getSurname());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());
        mav.setViewName("editArticle");

        mav.addObject("user", userData);

        return mav;
    }

    @RequestMapping(value = "/editArticle/{id}",method = RequestMethod.POST)
    public String editInfo(@ModelAttribute("articleForm") Article articleForm, BindingResult bindingResult, Model model) throws ParseException {

        articleForm.parseDate();
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
    public ModelAndView listOfArticlesForPatron(Model model) {
        //TODO: user Cookie for that
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        Long userId = user.getId();
        List<Article> articleList = docService.getListOfArticle();

        for(Article article: articleList){
            Long articleId  = article.getId();
            List<History> historyList= historyService.getListHistoriesByIdAndDocId(userId,articleId);
            int status = -1;

            if (historyList!=null && !historyList.isEmpty()){
                History userHistory = historyList.get(historyList.size()-1);
                status = userHistory.getStatus();
            }

            if(article.getCopies() == 0 ) status = 4;

//            if(status != 0){
//                if(article.getCopies() == 0) status = 4;  //Go to Queue
//                else status = 1;                            //Simple CheckOut
//            }
                                                            //else Renew + Return
            article.setStatus(status);
            article.setDateString(DateToString(article.getDate(),0,10));
        }

        model.addAttribute(articleList);

        ModelAndView mav = new ModelAndView();
        /*Map<String, String> message1 = new HashMap<String, String>();
        message1.put("message1", "Hello World");
        mav.setViewName("welcome");
        mav.addObject("message", message1);*/
        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("surname", user.getSurname());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());
        mav.setViewName("listOfArticlesForPatron");

        mav.addObject("user", userData);
        model.addAttribute(articleList);
        return mav;
    }

    @RequestMapping(value = "/listOfArticles", method = RequestMethod.GET)
    public ModelAndView listOfArticles(Model model){

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        ModelAndView mav = new ModelAndView();

        /*Map<String, String> message1 = new HashMap<String, String>();
        message1.put("message1", "Hello World");
        mav.setViewName("welcome");
        mav.addObject("message", message1);*/

        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("surname", user.getSurname());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());
        mav.setViewName("listOfArticles");

        mav.addObject("user", userData);


        List<Article> articleList = docService.getListOfArticle();
        model.addAttribute(articleList);
        return mav;
    }

    public String DateToString(Date date,int start, int finish){
        String yearString = "";
        if(date!=null) yearString = date.toString().substring(start, finish);
        return yearString;
    }

}
