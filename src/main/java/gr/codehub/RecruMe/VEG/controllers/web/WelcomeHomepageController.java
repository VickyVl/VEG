package gr.codehub.RecruMe.VEG.controllers.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/recrumeVEG/")
public class WelcomeHomepageController {

    @GetMapping("welcome")
    public ModelAndView getWelcomeHomepageController() {
        return new ModelAndView("WelcomeHomepage.html");
    }
}
