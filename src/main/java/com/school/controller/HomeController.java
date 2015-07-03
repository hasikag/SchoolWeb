package com.school.controller;


import com.school.model.School;
import com.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hga
 * Date: 7/2/15
 * Time: 1:35 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class HomeController {
    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value="/")
    public ModelAndView listContact(ModelAndView model) throws IOException{
        List<School> listSchool = schoolService.list();
        model.addObject("listSchool", listSchool);
        model.setViewName("home");

        return model;
    }

    @RequestMapping(value = "/newSchool", method = RequestMethod.GET)
    public ModelAndView newSchool(ModelAndView model) {
        School newSchool = new School();
        model.addObject("school", newSchool);
        model.setViewName("SchoolForm");
        return model;
    }

    @RequestMapping(value = "/saveSchool", method = RequestMethod.POST)
    public ModelAndView saveSchool(@ModelAttribute School school) {
        schoolService.saveOrUpdate(school);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteSchool", method = RequestMethod.GET)
    public ModelAndView deleteSchool(HttpServletRequest request) {
        int schoolId = Integer.parseInt(request.getParameter("id"));
        schoolService.delete(schoolId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editSchool", method = RequestMethod.GET)
    public ModelAndView editSchool(HttpServletRequest request) {
        int schoolId = Integer.parseInt(request.getParameter("id"));
        School school = schoolService.get(schoolId);
        ModelAndView model = new ModelAndView("SchoolForm");
        model.addObject("school", school);

        return model;
    }
}

