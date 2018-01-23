package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import com.app.model.People;
import com.app.service.PeopleService;

@Controller
public class PeopleController {

    public PeopleController() {
        System.out.println("PeopleController()");
    }

    @Autowired
    private PeopleService peopleService;

    //@RequestMapping(value = "/")
    //public ModelAndView listPeople(ModelAndView model) throws IOException {
        //List<People> listPeople = peopleService.getAllPeople();
        //model.addObject("listPeople", listPeople);
        //model.setViewName("home");
        //return model;
    //}

    //@RequestMapping(value = "/")
    //public String listPeople(Model model) throws IOException {
        //model.addAttribute("listPeople", peopleService.getAllPeople());
        //return "home";
    //}

    //@RequestMapping(value = "/newPeople", method = RequestMethod.GET)
    //public ModelAndView newContact(ModelAndView model) {
        //People people = new People();
        //model.addObject("people", people);
        //model.setViewName("peopleForm");
        //return model;
    //}

    @RequestMapping(value = "/newPeople", method = RequestMethod.GET)
    public String newContact(Model model) {
        model.addAttribute("people", new People());
        return "addPeopleForm";
    }

    //@RequestMapping(value = "/savePeople", method = RequestMethod.POST)
    //public ModelAndView savePeople(@ModelAttribute People people) {
        //if (people.getId() == 0) { // if people id is 0 then creating the
            // people other updating the people
            //peopleService.addPeople(people);
        //} else {
            //peopleService.updatePeople(people);
        //}
        //return new ModelAndView("redirect:/");
    //}

    @RequestMapping(value = "/addPeople", method = RequestMethod.POST)
    public String addPeople(@ModelAttribute People people) {
        peopleService.addPeople(people);
        return "redirect:/";
    }

    @RequestMapping(value = "/editPeople", method = RequestMethod.POST)
    public String editPeople(@ModelAttribute People people) {
        peopleService.updatePeople(people);
        return "redirect:/";
    }

    //@RequestMapping(value = "/deletePeople", method = RequestMethod.GET)
    //public ModelAndView deletePeople(HttpServletRequest request) {
        //int id = Integer.parseInt(request.getParameter("id"));
        //peopleService.deletePeople(id);
        //return new ModelAndView("redirect:/");
    //}
    @RequestMapping(value = "/deletePeople", method = RequestMethod.GET)
    public String deletePeople(@RequestParam int id) {
        peopleService.deletePeople(id);
        return "redirect:/";
    }

    //@RequestMapping(value = "/editPeople", method = RequestMethod.GET)
    //public ModelAndView editContact(HttpServletRequest request) {
        //int id = Integer.parseInt(request.getParameter("id"));
        //People people = peopleService.getPeople(id);
        //ModelAndView model = new ModelAndView("addPeopleForm");
        //model.addObject("people", people);

        //return model;
    //}

    @RequestMapping(value = "/editPeople", method = RequestMethod.GET)
    public String editContact(Model model, @RequestParam int id) {
        model.addAttribute("people", peopleService.getPeople(id));
        return "editPeopleForm";
    }
}
