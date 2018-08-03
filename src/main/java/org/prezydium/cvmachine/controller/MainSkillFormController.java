package org.prezydium.cvmachine.controller;

import org.prezydium.cvmachine.model.MainSkill;
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
public class MainSkillFormController {

    private Logger LOG = LoggerFactory.getLogger(MainSkillFormController.class);

    @GetMapping(path = "/main-skill")
    public ModelAndView personalDataProvider(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("main-skill");
        if (httpSession.getAttribute("mainSkill") == null) {
            modelAndView.addObject("mainSkill", new MainSkill());
        } else {
            modelAndView.addObject("mainSkill", httpSession.getAttribute("mainSkill"));
        }
        return modelAndView;
    }

    @PostMapping("/main-skill")
    public RedirectView savePersonalData(@ModelAttribute MainSkill mainSkill, HttpSession httpSession) {
        LOG.info("Processing experience: ".concat(mainSkill.toString()));
        httpSession.setAttribute("mainSkill", mainSkill);
        return new RedirectView("/");
    }
}
