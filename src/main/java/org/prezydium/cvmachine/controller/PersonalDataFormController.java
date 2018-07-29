package org.prezydium.cvmachine.controller;

import org.prezydium.cvmachine.model.UserData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class PersonalDataFormController {

    private Logger LOG = LoggerFactory.getLogger(PersonalDataFormController.class);

    @GetMapping(path = "/personaldata")
    public ModelAndView personalDataProvider(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("personaldata");
        if (httpSession.getAttribute("userData") == null) {
            modelAndView.addObject("userData", new UserData());
        } else {
            modelAndView.addObject("userData", httpSession.getAttribute("userData"));
        }
        return modelAndView;
    }

    @PostMapping("/personaldata")
    public RedirectView savePersonalData(@ModelAttribute UserData userDataFromForm, HttpSession httpSession) {
        LOG.info("Processing user: ".concat(userDataFromForm.toString()));
        httpSession.setAttribute("userData", userDataFromForm);
        return new RedirectView("/");
    }
}
