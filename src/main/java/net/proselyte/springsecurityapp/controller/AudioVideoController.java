package net.proselyte.springsecurityapp.controller;


import net.proselyte.springsecurityapp.service.ArticleService;
import net.proselyte.springsecurityapp.service.AudioVideoMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AudioVideoController {

    @Autowired
    private AudioVideoMaterialService audioVideoMaterialService;

    @RequestMapping("/deleteAudioVideo/{id}")
    public String deleteAudioVideo(@PathVariable("id") Long id){
        audioVideoMaterialService.delete(id);

        return "redirect:/listOfAudioVideoMaterial";
    }

    @RequestMapping(value = "/listOfAudioVideoMaterialForPatron", method = RequestMethod.GET)
    public String listOfAudioVideoMaterialForPatron() {
        return "listOfAudioVideoMaterialForPatron";
    }

}
