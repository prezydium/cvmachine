package org.prezydium.cvmachine.controller;

import org.prezydium.cvmachine.model.CVModel;
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
        if (httpSession.getAttribute("cvModel") == null) {
            modelAndView.addObject("userData", new UserData());
        } else {
            CVModel cvModel = (CVModel) httpSession.getAttribute("cvModel");
            modelAndView.addObject("userData", cvModel.getUserData());
        }
        return modelAndView;
    }

    @PostMapping("/personaldata")
    public RedirectView savePersonalData(@ModelAttribute UserData userDataFromForm, HttpSession httpSession) {
        LOG.info("Processing user: ".concat(userDataFromForm.toString()));
        CVModel cvModel = (CVModel) httpSession.getAttribute("cvModel");
        if (cvModel == null){
            cvModel = new CVModel();
        }
        cvModel.setUserData(userDataFromForm);
        httpSession.setAttribute("cvModel", cvModel);
        return new RedirectView("/");
    }
}
