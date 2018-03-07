package net.proselyte.springsecurityapp.controller;


import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.service.AudioVideoMaterialService;
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
public class AudioVideoController {
    private final org.jboss.logging.Logger logger = LoggerFactory.logger(AudioVideoController.class);

    @Autowired
    private AudioVideoMaterialService audioVideoMaterialService;

    @RequestMapping(value = "/editAudioVideo/{id}", method = RequestMethod.GET)
    public String editInfo(@PathVariable("id") Long id , Model model) {
        AudioVideo audioVideo = audioVideoMaterialService.getAudioVideoById(id);

        if(audioVideo!=null)
            logger.info("AV got by ID: " + audioVideo.toString());

        model.addAttribute("AVForm", audioVideo);

        return "editAudioVideo";
    }

    @RequestMapping(value = "/editAudioVideo/{id}",method = RequestMethod.POST)
    public String editInfo(@ModelAttribute("AVForm") AudioVideo AVForm, BindingResult bindingResult, Model model){
        audioVideoMaterialService.update(AVForm);

        logger.info("AV updated: "+ AVForm.toString());
        return "redirect:/listOfAudioVideoMaterial";
    }


    @RequestMapping("/deleteAudioVideo/{id}")
    public String deleteAudioVideo(@PathVariable("id") Long id){
        audioVideoMaterialService.delete(id);

        return "redirect:/listOfAudioVideoMaterial";
    }

    @RequestMapping(value = "/listOfAudioVideoMaterialForPatron", method = RequestMethod.GET)
    public String listOfAVForPatron() {
        return "listOfAudioVideoMaterialForPatron";
    }




}