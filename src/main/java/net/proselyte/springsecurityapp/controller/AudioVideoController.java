package net.proselyte.springsecurityapp.controller;


import net.proselyte.springsecurityapp.model.Booking.History;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Users.User;
import net.proselyte.springsecurityapp.service.AudioVideoMaterialService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AudioVideoController {
    private final org.jboss.logging.Logger logger = LoggerFactory.logger(AudioVideoController.class);

    @Autowired
    private AudioVideoMaterialService audioVideoMaterialService;

    @Autowired
    private DocumentService docService;

    @Autowired
    private UserService userService;

    @Autowired
    private HistoryService historyService;

    @RequestMapping(value = "/addAudioVideoMaterial", method = RequestMethod.GET)
    public ModelAndView addAudioVideoMaterial(Model model) {
        model.addAttribute("audioVideoForm", new AudioVideo());

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
        mav.setViewName("addAudioVideoMaterial");

        mav.addObject("user", userData);

        return mav;

    }

    @RequestMapping(value = "/addAudioVideoMaterial", method = RequestMethod.POST)
    public String addAudioVideoMaterial(@ModelAttribute("addAudioVideoMaterial") AudioVideo audioVideoForm, BindingResult bindingResult, Model model) {
       //TODO: AuidoVideo Validation
        //audioVideoValidator.validate(audioVideoForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "addAudioVideoMaterial";
        }

        docService.save(audioVideoForm);
        return "redirect:/admin";
    }



    @RequestMapping(value = "/editAudioVideo/{id}", method = RequestMethod.GET)
    public ModelAndView editInfo(@PathVariable("id") Long id , Model model) {
        Document audioVideo = docService.getDocumentById(id);

        if(audioVideo!=null)
            logger.info("AV got by ID: " + audioVideo.toString());

        model.addAttribute("AVForm", audioVideo);

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
        mav.setViewName("editAudioVideo");

        mav.addObject("user", userData);

        return mav;
    }

    @RequestMapping(value = "/editAudioVideo/{id}",method = RequestMethod.POST)
    public String editInfo(@ModelAttribute("AVForm") AudioVideo AVForm, BindingResult bindingResult, Model model){
        docService.update(AVForm);

        logger.info("AV updated: "+ AVForm.toString());
        return "redirect:/listOfAudioVideoMaterial";
    }


    @RequestMapping("/deleteAudioVideo/{id}")
    public String deleteAudioVideo(@PathVariable("id") Long id){
        docService.delete(id);

        return "redirect:/listOfAudioVideoMaterial";
    }

    //TODO:
    @RequestMapping(value = "/listOfAudioVideoMaterialForPatron", method = RequestMethod.GET)
    public ModelAndView listOfAVForPatron(Model model) {
        //TODO: user Cookie for that
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        Long userId = user.getId();

        List<AudioVideo> audioVideoList = docService.getListOfAudioVideo();

        for(AudioVideo audioVideo: audioVideoList){
            Long avId  = audioVideo.getId();
            List<History> historyList= historyService.getListHistoriesByIdAndDocId(userId,avId);

            int status = -1;

            if (historyList!=null && !historyList.isEmpty()){
                History userHistory = historyList.get(historyList.size()-1);
                status = userHistory.getStatus();
            }

            if(status != 0 ){
                if(audioVideo.getCopies() == 0) status = 2;  //Go to Queue
                else status = 3;                            //Simple CheckOut
            }                                                 //else Renew + Return
            audioVideo.setStatus(status);
        }

        model.addAttribute(audioVideoList);

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
        mav.setViewName("listOfAudioVideoMaterialForPatron");

        mav.addObject("user", userData);
        return mav;
    }

    @RequestMapping(value="/listOfAudioVideoMaterial", method = RequestMethod.GET)
    public ModelAndView listOfAudioVideoMaterials(Model model){
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
        mav.setViewName("listOfAudioVideoMaterial");

        mav.addObject("user", userData);



        List<AudioVideo> audioVideoList = docService.getListOfAudioVideo();
        model.addAttribute(audioVideoList);
        return mav;
    }


}