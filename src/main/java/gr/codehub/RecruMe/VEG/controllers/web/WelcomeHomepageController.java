package gr.codehub.RecruMe.VEG.controllers.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * WelcomeHomepageController used here to dispatch the data from the "WelcomeHomepage.html" file, in order to
 * create the welcoming page of the RecrumeVEG Services.
 * Formatting of the Welcome Homepage completed with HTML and CSS.
 * Homepage created as an example of the connection between the back-end Spring Boot RESTful API and the
 * web front-end visible to the user.
 */

@RestController
@RequestMapping("/recrumeVEG/")
public class WelcomeHomepageController {

    @GetMapping("welcome")
    public ModelAndView getWelcomeHomepageController() {
        return new ModelAndView("WelcomeHomepage.html");
    }
}
